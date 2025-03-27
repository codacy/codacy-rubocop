
This cop flags the usage of `git ls-files` in gemspec
and suggests to use a plain Ruby alternative, like `Dir`,
`Dir.glob`, or `Rake::FileList` instead.

# Examples

```ruby

# bad
Gem::Specification.new do |spec|
  spec.files = `git ls-files`.split("\n")
end

# good
Gem::Specification.new do |spec|
  spec.files = Dir["lib/**/*", "LICENSE", "README.md"]
end

# bad
Gem::Specification.new do |spec|
  spec.files = Dir.chdir(File.expand_path(__dir__)) do
    `git ls-files -z`.split("\\x0").reject { |f| f.match(%r{^(test|spec|features)/}) }
  end
end

# good
require "rake/file_list"

Gem::Specification.new do |spec|
  spec.files = Rake::FileList["**/*"].exclude(*File.read(".gitignore").split)
end

# bad
Gem::Specification.new do |spec|
  spec.files        = `git ls-files -- lib/`.split("\n")
  spec.executables  = `git ls-files -- bin/*`.split("\n").map{ |f| File.basename(f) }
end

# good
Gem::Specification.new do |spec|
  spec.files        = Dir.glob("lib/**/*")
  spec.executables  = Dir.glob("bin/*").map{ |f| File.basename(f) }
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Packaging/GemspecGit)