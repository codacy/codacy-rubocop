
Checks that the cyclomatic complexity of methods is not higher
than the configured maximum. The cyclomatic complexity is the number of
linearly independent paths through a method. The algorithm counts
decision points and adds one.

An if statement (or unless or ?:) increases the complexity by one. An
else branch does not, since it doesn't add a decision point. The &&
operator (or keyword and) can be converted to a nested if statement,
and ||/or is shorthand for a sequence of ifs, so they also add one.
Loops can be said to have an exit condition, so they add one.
Blocks that are calls to builtin iteration methods
(e.g. `ary.map{...}`) also add one, others are ignored.

# Examples

```ruby

def each_child_node(*types)               # count begins: 1
  unless block_given?                     # unless: +1
    return to_enum(__method__, *types)
  end

  children.each do |child|                # each{}: +1
    next unless child.is_a?(Node)         # unless: +1

    yield child if types.empty? ||        # if: +1, ||: +1
                   types.include?(child.type)
  end

  self
end                                       # total: 6
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Metrics/CyclomaticComplexity)