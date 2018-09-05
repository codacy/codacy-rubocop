
This cop checks whether the end keywords of method definitions are
aligned properly.

Two modes are supported through the EnforcedStyleAlignWith configuration
parameter. If it's set to `start_of_line` (which is the default), the
`end` shall be aligned with the start of the line where the `def`
keyword is. If it's set to `def`, the `end` shall be aligned with the
`def` keyword.

# Examples

```ruby
# bad

private def foo
            end

# good

private def foo
end# bad

private def foo
            end

# good

private def foo
        end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/DefEndAlignment)