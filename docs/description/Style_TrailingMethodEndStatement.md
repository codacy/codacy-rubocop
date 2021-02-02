
This cop checks for trailing code after the method definition.

# Examples

```ruby
# bad
def some_method
do_stuff; end

def do_this(x)
  baz.map { |b| b.this(x) } end

def foo
  block do
    bar
  end end

# good
def some_method
  do_stuff
end

def do_this(x)
  baz.map { |b| b.this(x) }
end

def foo
  block do
    bar
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TrailingMethodEndStatement)