
This cop checks for *when;* uses in *case* expressions.

# Examples

```ruby
# bad
case foo
when 1; 'baz'
when 2; 'bar'
end

# good
case foo
when 1 then 'baz'
when 2 then 'bar'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/WhenThen)