
Checks for the use of a `return` with a value in `begin..end` blocks
in the context of instance variable assignment such as memoization.
Using `return` with a value in these blocks can lead to unexpected behavior
as the `return` will exit the method that contains and not set the values
of the instance variable.

# Examples

```ruby

# bad
def foo
  @foo ||= begin
    return 1 if bar
    2
  end
end

# bad
def foo
  @foo = begin
    return 1 if bar
    2
  end
end

# bad
def foo
  @foo += begin
    return 1 if bar
    2
  end
end

# bad - using return in rescue blocks still exits the method
def foo
  @foo ||= begin
    bar
  rescue
    return 2 if baz
  end
end

# good
def foo
  @foo ||= begin
    if bar
      1
    else
      2
    end
  end
end

# good - not an assignment to an instance variable
def foo
  foo = begin
    return 1 if bar
    2
  end
end

# good - proper exception handling without return
def foo
  @foo ||= begin
    bar
  rescue
    baz ? 2 : 3
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/NoReturnInMemoization)