
Checks that code in an `ensure` block does not run when the test is skipped.
If `skip` is conditional, the `ensure` block must also be conditional,
using the negation of the skip condition so that it runs only when the test runs.

On the other hand, `skip` used inside a `rescue` clause is accepted,
because the `ensure` block may serve as teardown for resources created in the `begin` setup.

# Examples

```ruby

# bad
def test_skip
  skip 'This test is skipped.'

  assert 'foo'.present?
ensure
  do_something
end

# bad
def test_conditional_skip
  skip 'This test is skipped.' if condition

  assert do_something
ensure
  do_teardown
end

# good
def test_skip
  skip 'This test is skipped.'

  begin
    assert 'foo'.present?
  ensure
    do_something
  end
end

# good
def test_conditional_skip
  skip 'This test is skipped.' if condition

  assert do_something
ensure
  unless condition
    do_teardown
  end
end

# good
def test_skip_is_used_in_rescue
  do_setup
  assert do_something
rescue
  skip 'This test is skipped.'
ensure
  do_teardown
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/SkipEnsure)