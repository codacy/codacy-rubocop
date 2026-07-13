
Enforces empty line after guard clause.

This cop allows a SimpleCov directive comment after guard clause because
SimpleCov excludes code from the coverage report by wrapping it in such directives.
Both the legacy `# :nocov:` comment and the newer `# simplecov:disable` /
`# simplecov:enable` comments are recognized:

[source,ruby]
----
def foo
  # :nocov:
  return if condition
  # :nocov:
  bar
end

def foo
  # simplecov:disable
  return if condition
  # simplecov:enable
  bar
end
----

Refer to SimpleCov's documentation for more details:
https://github.com/simplecov-ruby/simplecov#ignoringskipping-code

# Examples

```ruby

# bad
def foo
  return if need_return?
  bar
end

# good
def foo
  return if need_return?

  bar
end

# good
def foo
  return if something?
  return if something_different?

  bar
end

# also good
def foo
  if something?
    do_something
    return if need_return?
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLineAfterGuardClause)