
Checks for directive scopes that can be expressed with the tighter
next-statement forms: a `disable`/`enable` pair, an
`enable`/`disable` pair, or a `push`/`pop` with signed arguments
wrapping exactly one statement. A statement-scoped directive cannot
drift as the surrounding code changes and needs no closing boundary.

# Examples

```ruby
# bad
# rubocop:disable Metrics/AbcSize
def foo
end
# rubocop:enable Metrics/AbcSize

# good
# rubocop:disable-next Metrics/AbcSize
def foo
end

# bad
# rubocop:push -Metrics/AbcSize
def foo
end
# rubocop:pop

# good
# rubocop:disable-next Metrics/AbcSize
def foo
end

# bad
# rubocop:disable Metrics/AbcSize
# rubocop:push +Metrics/AbcSize
def foo
end
# rubocop:pop
# rubocop:enable Metrics/AbcSize

# good
# rubocop:disable Metrics/AbcSize
# rubocop:enable-next Metrics/AbcSize
def foo
end
# rubocop:enable Metrics/AbcSize

# good - the region spans more than one statement
# rubocop:disable Metrics/AbcSize
def foo
end

def bar
end
# rubocop:enable Metrics/AbcSize
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/DirectiveScope)