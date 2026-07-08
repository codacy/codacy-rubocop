
Checks for unreachable `in` pattern branches in `case...in` statements.

An `in` branch is unreachable when a previous branch uses an unguarded
catch-all pattern that matches any value unconditionally. Any `in` branches
(and `else`) that follow such a catch-all are dead code.

A catch-all pattern is one of:

* A bare variable capture (`in x`)
* An underscore (`in _`)
* A pattern alias where the left side is a catch-all (`in _ => y`)
* An alternation pattern where at least one alternative is a catch-all
  (`in _ | Integer`)

NOTE: A catch-all pattern with a guard clause (e.g., `in _ if condition`)
does NOT make subsequent branches unreachable because the guard might
not be satisfied.

# Examples

```ruby

# bad
case value
in Integer
  handle_integer
in x
  handle_other
in String
  handle_string
else
  handle_else
end

# good
case value
in Integer
  handle_integer
in String
  handle_string
in x
  handle_other
end

# bad - else is unreachable after catch-all
case value
in Integer
  handle_integer
in _
  handle_other
else
  handle_else
end

# good - guard clause means catch-all might not match
case value
in x if x.positive?
  handle_positive
in Integer
  handle_integer
else
  handle_other
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UnreachablePatternBranch)