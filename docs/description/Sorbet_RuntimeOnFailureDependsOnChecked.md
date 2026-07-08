
Checks that `on_failure` is not used without `checked(:tests)` or `checked(:always)`.

# Examples

```ruby

# bad
sig { params(x: Integer).returns(Integer).on_failure(:raise) }
def plus_one(x)
  x + 1
end

# good
sig { params(x: Integer).returns(Integer).checked(:always).on_failure(:raise) }
def plus_one(x)
  x + 1
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/RuntimeOnFailureDependsOnChecked)