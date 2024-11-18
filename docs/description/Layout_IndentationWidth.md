
Checks for indentation that doesn't use the specified number of spaces.
The indentation width can be configured using the `Width` setting. The default width is 2.

See also the `Layout/IndentationConsistency` cop which is the companion to this one.

# Examples

```ruby
# bad
class A
 def test
  puts 'hello'
 end
end

# good
class A
  def test
    puts 'hello'
  end
end# bad
module A
class B
  def test
  puts 'hello'
  end
end
end

# good
module A
class B
  def test
    puts 'hello'
  end
end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/IndentationWidth)