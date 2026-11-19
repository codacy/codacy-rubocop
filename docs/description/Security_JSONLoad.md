
Checks for the use of JSON class methods which have potential
security issues.

`JSON.load` and similar methods allow deserialization of arbitrary ruby objects:

[source,ruby]
----
require 'json/add/string'
result = JSON.load('{ "json_class": "String", "raw": [72, 101, 108, 108, 111] }')
pp result # => "Hello"
----

Never use `JSON.load` for untrusted user input. Prefer `JSON.parse` unless you have
a concrete use-case for `JSON.load`.

NOTE: Starting with `json` gem version 2.8.0, triggering this behavior without explicitly
passing the `create_additions` keyword argument emits a deprecation warning, with the
goal of being secure by default in the next major version 3.0.0.

NOTE: Before `json` gem version 2.17.0, `JSON.load` only takes options as its third
argument. A hash passed as the second argument is taken as the `proc` argument, so
its `create_additions` option is ignored. Which `json` version runs can't be told
statically (the lockfile may resolve a newer one than the default gem loaded in
production), so options passed as the second argument are always reported. Pass
`nil` as the second argument instead.

# Examples

```ruby
# bad
JSON.load('{}')
JSON.restore('{}')

# bad - ignored by `json` older than 2.17.0
JSON.load('{}', create_additions: false)

# good
JSON.parse('{}')
JSON.unsafe_load('{}')

# good - explicit use of `create_additions` option
JSON.load('{}', nil, create_additions: true)
JSON.load('{}', nil, create_additions: false)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Security/JSONLoad)