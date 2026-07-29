[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7cb874a40208406dbe62fe96d6b3a727)](https://www.codacy.com/gh/codacy/codacy-rubocop?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=codacy/codacy-rubocop&amp;utm_campaign=Badge_Grade)
[![Build Status](https://circleci.com/gh/codacy/codacy-rubocop.svg?style=shield&circle-token=:circle-token)](https://circleci.com/gh/codacy/codacy-rubocop)

# Codacy Rubocop

This is the docker engine we use at Codacy to have [Rubocop](https://www.rubocop.org) support.
You can also create a docker to integrate the tool and language of your choice!
See the [codacy-engine-scala-seed](https://github.com/codacy/codacy-engine-scala-seed) repository for more information.

## Usage

You can create the docker by doing:

```
sbt universal:stage
docker build -t codacy-rubocop .
```

The docker is ran with the following command:

```
docker run -it -v $srcDir:/src  <DOCKER_NAME>:<DOCKER_VERSION>
```

## Add plugin

Rubocop is moving some checks to separate repositories, as an example you can check
https://github.com/rubocop-hq/rubocop/pull/6890

There are some important details to take into consideration:
- Add dependency to Gemfile
- Add it to src/main/scala/codacy/rubocop/Rubocop.scala

```diff
- private val plugins: List[String] = List("rubocop-performance")
+ private val plugins: List[String] = List("rubocop-performance", "rubocop-style")
```

- Add it to doc_generation/codacy/rubocop/generator.rb

```diff
- $plugins = ["rubocop-performance"]
+ $plugins = ["rubocop-performance", "rubocop-style"]
```

- `bundle install` so the examples for the documentation are made available at
`vendor/bundle/ruby/{ruby_version}/gems/{plugin}/lib/rubocop/cop/*/*.rb`
- Adding the plugin to the `$plugins` will also make the script to *require* it,
to be able to fetch Cops for the base documentation

## Test

We use the [codacy-plugins-test](https://github.com/codacy/codacy-plugins-test) to test our external tools integration.
You can follow the instructions there to make sure your tool is working as expected.

## Update Version with Docs

```sh
bundle update
bundle config set --local path 'vendor/bundle'
bundle install
./scripts/doc_generate.sh <docs_location>
```

Notes on the documentation generation:
- You need to *require* the plugin, so they are injected on the *registry* when fetching the available Cops
- After the `bundle install` the documentation generator will fetch examples from the Cops of the added plugins

## Agent Playbook: Updating This Repository End-to-End

This section is written for an AI coding agent (or a human) tasked with updating this repo — most commonly bumping the wrapped RuboCop version (and its cop plugins), but also base image / orb / dependency bumps. Follow it top to bottom; it tells you what to change, how to regenerate derived files, how to test locally, and how to interpret CI so you can iterate on failures without guessing.

### 1. What this repository is

This is a **Codacy engine**: a thin Scala wrapper (`src/main/scala/codacy/rubocop/Rubocop.scala`, built on `codacy-engine-scala-seed`) that packages [RuboCop](https://www.rubocop.org) — plus a large set of RuboCop cop plugins (`rubocop-rails`, `rubocop-performance`, `rubocop-rspec`, etc., listed in the `Gemfile`) — as a Docker image Codacy's platform runs against a customer's Ruby source code. The Scala side only orchestrates: it shells out to the `rubocop` gem at runtime and translates its output/config into Codacy's API shapes.

The `docs/` directory is machine-consumed configuration, not just documentation:

- `docs/patterns.json` — the full list of RuboCop cops ("patterns") Codacy knows about, their parameters/defaults, and which are enabled out of the box, plus a top-level `"version"` field recording the RuboCop version the docs were generated from. **Generated file, do not hand-edit.**
- `docs/description/*.md` and `docs/description/description.json` — human-readable titles/descriptions per pattern, used in the Codacy UI. **Generated, do not hand-edit.**
- `docs/tests/*` and `docs/multiple-tests/*` — fixtures used by `codacy-plugins-test` to validate the engine actually produces the results it claims for real code samples.
- `docs/tool-description.md` — short blurb about the tool, hand-maintained.

Both generated artifacts above come from two Ruby scripts run via `scripts/doc_generate.sh`: `doc_generation/rubocop_doc/generator.rb` (scrapes RuboCop/plugin cop YAML+YARD docs into markdown) and `doc_generation/codacy/rubocop/generator.rb` (turns that into `docs/patterns.json` and `docs/description/description.json`). These need the gems actually installed locally (`bundle install`) since they introspect the installed cop classes — they are not simple web scrapers.

### 2. Files that encode versions — check all of these on every update

| File | What it controls | What to check |
|---|---|---|
| `Gemfile` → `gem "rubocop"` (unpinned) and the `gem "rubocop-*"` plugin lines | Which RuboCop core/plugin versions `bundle update` will resolve to | RuboCop itself is **not version-pinned here** — the actual resolved version only shows up in `Gemfile.lock` after `bundle update`. If a plugin needs pinning to a specific version, add a version constraint on its line. |
| `Gemfile.lock` | The exact resolved RuboCop + plugin + transitive dependency versions actually shipped | Regenerated by `bundle update` / `bundle install` — do not hand-edit; commit the regenerated file. |
| `docs/patterns.json` → top-level `"version"` field | The RuboCop version recorded in the generated pattern catalog | Set automatically by the doc generator when re-run after the gem bump — verify it matches the new `Gemfile.lock` version after regeneration. |
| `src/main/scala/codacy/rubocop/Rubocop.scala` → `plugins` list (and the "legacy requires" block) | Which cop plugins are `require`d/enabled when the engine invokes RuboCop | Add new plugin gems here (mirrors the `doc_generation/codacy/rubocop/generator.rb` `$plugins` list — keep both in sync, see the "Add plugin" section above). |
| `doc_generation/codacy/rubocop/generator.rb` → `$plugins` | Which plugins the doc generator `require`s so their cops are picked up when building `docs/patterns.json` | Keep in sync with the `plugins` list in `Rubocop.scala` above. |
| `build.sbt` → `codacy-engine-scala-seed`, `scala-xml`, `jackson-dataformat-yaml`, `play-json` versions, `scalaVersion` | Codacy's engine SDK and Scala-side dependencies — unrelated to the RuboCop version | Only touch when explicitly asked to bump these, or when a build failure forces it (e.g. `codacy-engine-scala-seed` API changes). |
| `Dockerfile` → `ARG BASE_IMAGE=ruby:<version>-alpine<version>` | The Ruby runtime the gems and the engine binary run on | Only bump if the new RuboCop/gem versions raise the minimum Ruby requirement, or if asked explicitly. |
| `project/build.properties` / `project/plugins.sbt` | sbt version / the `codacy-sbt-plugin` version | Rarely needs touching; check only if the build itself fails to load. |
| `.circleci/config.yml` → `codacy/base` and `codacy/plugins-test` orb versions | Shared CircleCI steps (checkout/versioning/sbt build/docker publish/tagging) and the `codacy-plugins-test` runner | Check the latest published orb versions if asked to bump them; not tied to RuboCop bumps. |

### 3. Step-by-step update procedure

1. **Bump RuboCop / plugins**: run `bundle update` (optionally `bundle update rubocop <plugin-gems...>` to scope it) to refresh `Gemfile.lock` to the desired versions. If a specific version is required, add a constraint to the relevant `Gemfile` line first.
2. **If a new plugin gem was added**, add it to `Gemfile`, to the `plugins` list in `src/main/scala/codacy/rubocop/Rubocop.scala`, and to `$plugins` in `doc_generation/codacy/rubocop/generator.rb` (see the "Add plugin" section above for the exact pattern).
3. **Install with the vendored path and regenerate the docs** (this is what the Dockerfile's `doc-generator` stage does):
   ```sh
   bundle config set --local path 'vendor/bundle'
   bundle install
   ./scripts/doc_generate.sh .
   ```
   Review the diff under `docs/description/` and `docs/patterns.json` for new/removed/renamed cops, and check `docs/patterns.json`'s `"version"` field reflects the new RuboCop version.
4. **Update fixtures** under `docs/tests/` and `docs/multiple-tests/` if cop behavior/naming changed in a way that breaks existing expectations.
5. **Build and format the Scala side**: `sbt "scalafmtCheckAll; test:scalafmt; scalafmt; universal:stage"`.
6. **Build the Docker image**: `docker build -t codacy-rubocop .` (this re-runs the doc generation inside the multi-stage build too, so it's a good cross-check that step 3 was done correctly).
7. **Run `codacy-plugins-test` locally** before pushing — clone https://github.com/codacy/codacy-plugins-test and run its multiple-tests (`run_multiple_tests`) DockerTest command against your local image tag, per that repo's instructions.
8. **Iterate on failures**, re-running only the relevant test command after each fix.
9. **Commit** the `Gemfile`/`Gemfile.lock` bump together with the regenerated `docs/` files and any Scala plugin-list changes in one change.
10. **Push and open a PR.** CI (`.circleci/config.yml`) runs `codacy/checkout_and_version` -> `publish_docker_local` (scalafmt checks + `universal:stage` + `docker build`) -> `plugins_test` (`codacy_plugins_test/run`, multiple tests) -> `codacy/publish_docker` (master only) -> `codacy/tag_version`.
11. **Poll the PR's real CI checks until they all pass — local validation is NOT the finish line.** After every push, run `gh pr checks <pr-url>` and keep re-polling (short sleep while any check is `pending`) until all checks finish. If a check fails, fetch its actual log (the CircleCI job for the failing step — don't guess), find the true root cause, fix it, push again (never `--no-verify`, never force-push), and re-poll. Repeat until every check is green. The CI environment's toolchain (Ruby/gem resolution, JVM, sbt) can differ subtlely from your local one, so a clean local run does not guarantee CI passes — this repo's history shows follow-up "fix" commits landing right after a version-bump PR (e.g. a bump PR merged, then a same-day fix commit touching `.circleci/config.yml`, `Dockerfile`, `build.sbt`, and `Rubocop.scala` together) precisely because something only surfaced once real CI ran. Only stop iterating when every check passes, or you hit a genuine product/infra decision that needs a human — in which case explain it in the PR rather than guessing.

### 4. Common failure modes and fixes

| Symptom | Likely cause | Fix |
|---|---|---|
| `scalafmtCheckAll` fails in CI/locally | Generated or hand-edited Scala file not formatted | Run `sbt scalafmt` then re-run the check command |
| Doc generator run fails or produces empty/garbled descriptions | Plugin not `require`d, or gems not installed under `vendor/bundle` before running `scripts/doc_generate.sh` | Ensure the plugin is listed in both `$plugins` (generator) and `plugins` (`Rubocop.scala`), then re-run `bundle install` with the vendored path before regenerating |
| `plugins_test` (multiple-tests) fails on a specific fixture | A cop was renamed/removed/added upstream, or default enablement/parameters changed between RuboCop versions | Regenerate docs, diff `docs/patterns.json`, and update the relevant fixture under `docs/multiple-tests/` to match the new (verified correct) output |
| CI `publish_docker`/`tag_version` don't run on your branch | Expected — gated to `master` only in `.circleci/config.yml` | Nothing to fix |

### 5. Definition of done

- RuboCop/plugin version bump(s) reflected in `Gemfile`/`Gemfile.lock`, and in the Scala `plugins` list plus the doc generator's `$plugins` list if a plugin was added or removed.
- Generated docs (`docs/patterns.json`, `docs/description/*`) regenerated and committed, with fixture inconsistencies under `docs/tests/`/`docs/multiple-tests/` resolved.
- Local `scalafmt`/`universal:stage` build passes.
- Docker image builds successfully (`docker build -t codacy-rubocop .`).
- `codacy-plugins-test` passes locally against the freshly built image.
- **After pushing and opening/updating the PR, every CI check on it is green.** Poll `gh pr checks <pr-url>` and iterate on any failure (fetch the real CI log, fix, push, re-poll) until all pass — a passing local build is not sufficient, because the CI toolchain can differ from your local one (see step 11).

## What is Codacy?

[Codacy](https://www.codacy.com/) is an Automated Code Review Tool that monitors your technical debt, helps you improve your code quality, teaches best practices to your developers, and helps you save time in Code Reviews.

### Among Codacy’s features:

- Identify new Static Analysis issues
- Commit and Pull Request Analysis with GitHub, BitBucket/Stash, GitLab (and also direct git repositories)
- Auto-comments on Commits and Pull Requests
- Integrations with Slack, HipChat, Jira, YouTrack
- Track issues in Code Style, Security, Error Proneness, Performance, Unused Code and other categories

Codacy also helps keep track of Code Coverage, Code Duplication, and Code Complexity.

Codacy supports PHP, Python, Ruby, Java, JavaScript, and Scala, among others.

### Free for Open Source

Codacy is free for Open Source projects.
