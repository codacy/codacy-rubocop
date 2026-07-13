
Checks for excessive nesting of conditional and looping constructs.
Deeply nested code is harder to read, understand, and maintain.
Extracting nested logic into methods improves clarity.

You can configure if blocks are considered using the `CountBlocks` and `CountModifierForms`
options. When both are set to `false` (the default) blocks and modifier forms are not
counted towards the nesting level. Set them to `true` to include these in the nesting level
calculation as well.

The maximum level of nesting allowed is configurable.

# Examples

```ruby
# bad
if condition1
  if condition2
    if condition3
      if condition4
        do_something
      end
    end
  end
end

# good
if condition1
  if condition2
    if condition3
      do_something
    end
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Metrics/BlockNesting)