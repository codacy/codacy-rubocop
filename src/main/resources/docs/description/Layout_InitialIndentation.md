
This cops checks for indentation of the first non-blank non-comment
line in a file.

# Examples

```ruby
# bad
   class A
     def foo; end
   end

# good
class A
  def foo; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/InitialIndentation)