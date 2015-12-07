Always have a consistent indentation since it provides aditional readability to your code

**Example:**

```
# bad
class A
  def test
    puts 'hello'
     puts 'world'
  end
end

# good
class A
  def test
    puts 'hello'
    puts 'world'
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/IndentationConsistency)
