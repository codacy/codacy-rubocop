
Identifies usages of `ancestors.include?` and change them to use `<=` instead.

# Examples

```ruby
# bad
A.ancestors.include?(B)

# good
A <= B
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/AncestorsInclude)