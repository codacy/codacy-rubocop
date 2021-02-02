
This cop checks for endless methods.

It can enforce either the use of endless methods definitions
for single-lined method bodies, or disallow endless methods.

Other method definition types are not considered by this cop.

The supported styles are:
* allow_single_line (default) - only single line endless method definitions are allowed.
* allow_always - all endless method definitions are allowed.
* disallow - all endless method definitions are disallowed.

NOTE: Incorrect endless method definitions will always be
corrected to a multi-line definition.

# Examples

```ruby
# good
def my_method() = x

# bad, multi-line endless method
def my_method() = x.foo
                   .bar
                   .baz# good
def my_method() = x

# good
def my_method() = x.foo
                   .bar
                   .baz# bad
def my_method; x end

# bad
def my_method() = x.foo
                   .bar
                   .baz
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EndlessMethod)