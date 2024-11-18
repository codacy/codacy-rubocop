
Checks for multiple `defined?` calls joined by `&&` that can be combined
into a single `defined?`.

When checking that a nested constant or chained method is defined, it is
not necessary to check each ancestor or component of the chain.

# Examples

```ruby
# bad
defined?(Foo) && defined?(Foo::Bar) && defined?(Foo::Bar::Baz)

# good
defined?(Foo::Bar::Baz)

# bad
defined?(foo) && defined?(foo.bar) && defined?(foo.bar.baz)

# good
defined?(foo.bar.baz)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CombinableDefined)