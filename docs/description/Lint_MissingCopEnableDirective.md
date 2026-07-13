
Checks that there is an `# rubocop:enable ...` statement
after a `# rubocop:disable ...` statement. This will prevent leaving
cop disables on wide ranges of code, that later contributors to
a file wouldn't be aware of.

You can set `MaxRangeSize` to define the maximum number of
consecutive lines a cop can be disabled for.

- `.inf` any size (default)
- `0` allows only single-line disables
- `1` means the maximum allowed is as follows:

[source,ruby]
----
# rubocop:disable SomeCop
a = 1
# rubocop:enable SomeCop
----

# Examples

```ruby

# good
# rubocop:disable Layout/SpaceAroundOperators
x= 0
# rubocop:enable Layout/SpaceAroundOperators
# y = 1
# EOF

# bad
# rubocop:disable Layout/SpaceAroundOperators
x= 0
# EOF


# good
# rubocop:disable Layout/SpaceAroundOperators
x= 0
# With the previous, there are 2 lines on which cop is disabled.
# rubocop:enable Layout/SpaceAroundOperators

# bad
# rubocop:disable Layout/SpaceAroundOperators
x= 0
x += 1
# Including this, that's 3 lines on which the cop is disabled.
# rubocop:enable Layout/SpaceAroundOperators
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/MissingCopEnableDirective)