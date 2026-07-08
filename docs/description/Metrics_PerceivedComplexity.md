
Tries to produce a complexity score that's a measure of the
complexity the reader experiences when looking at a method. For that
reason it considers `when` nodes as something that doesn't add as much
complexity as an `if` or a `&&`. Except if it's one of those special
`case`/`when` constructs where there's no expression after `case`. Then
the cop treats it as an `if`/`elsif`/`elsif`... and lets all the `when`
nodes count. In contrast to the CyclomaticComplexity cop, this cop
considers `else` nodes as adding complexity.

A `case`/`in` branch whose pattern is a simple literal (e.g. `in 1`, `in "red"`, `in 1..10`)
or a constant/type (e.g. `in Integer`) and has no guard is just as easy to read as a `when`
branch, so it is discounted the same way. Branches with structural patterns (e.g. array,
hash, or find patterns), bindings, alternatives, or a guard add the full complexity of
a decision point.

# Examples

```ruby

def example_1                   # 1
  if cond                       # 1
    case var                    # 2 (0.8 + 4 * 0.2, rounded)
    when 1 then func_one
    when 2 then func_two
    when 3 then func_three
    when 4..10 then func_other
    end
  else                          # 1
    do_something until a && b   # 2
  end                           # ===
end                             # 7 complexity points

def example_2                   # 1
  case color                    # 1 (3 * 0.2, rounded)
  in "red" then func_red
  in "blue" then func_blue
  in "green" then func_green
  end                           # ===
end                             # 2 complexity points
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Metrics/PerceivedComplexity)