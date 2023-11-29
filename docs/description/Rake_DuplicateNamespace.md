
If namespaces are defined with the same name, Rake executes the both namespaces
in definition order.
It is redundant. You should squash them into one definition.
This cop detects it.

# Examples

```ruby
# bad
namespace :foo do
  task :bar do
  end
end
namespace :foo do
  task :hoge do
  end
end

# good
namespace :foo do
  task :bar do
  end
  task :hoge do
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rake/DuplicateNamespace)