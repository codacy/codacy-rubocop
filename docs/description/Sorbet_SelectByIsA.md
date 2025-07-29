
Suggests using `grep` over `select` when using it only for type narrowing.

# Examples

```ruby

# bad
strings_or_integers.select { |e| e.is_a?(String) }
strings_or_integers.filter { |e| e.is_a?(String) }
strings_or_integers.select { |e| e.kind_of?(String) }

# good
strings_or_integers.grep(String)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/SelectByIsA)