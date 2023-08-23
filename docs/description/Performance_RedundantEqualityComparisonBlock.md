
Checks for uses `Enumerable#all?`, `Enumerable#any?`, `Enumerable#one?`,
and `Enumerable#none?` are compared with `===` or similar methods in block.

By default, `Object#===` behaves the same as `Object#==`, but this
behavior is appropriately overridden in subclass. For example,
`Range#===` returns `true` when argument is within the range.

This cop has `AllowRegexpMatch` option and it is true by default because
`regexp.match?('string')` often used in block changes to the opposite result:

[source,ruby]
----
[/pattern/].all? { |regexp| regexp.match?('pattern') } # => true
[/pattern/].all? { |regexp| regexp =~ 'pattern' }      # => true
[/pattern/].all?('pattern')                            # => false
----

# Examples

```ruby
# bad
items.all? { |item| pattern === item }
items.all? { |item| item == other }
items.all? { |item| item.is_a?(Klass) }
items.all? { |item| item.kind_of?(Klass) }

# good
items.all?(pattern)
items.all?(Klass)
# good
items.all? { |item| item =~ pattern }
items.all? { |item| item.match?(pattern) }
# bad
items.all? { |item| item =~ pattern }
items.all? { |item| item.match?(pattern) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/RedundantEqualityComparisonBlock)