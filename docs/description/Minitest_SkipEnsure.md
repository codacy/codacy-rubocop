
Checks that `ensure` call even if `skip`. It is unexpected that `ensure` will be called when skipping test.
If conditional `skip` is used, it checks that `ensure` is also called conditionally.

On the other hand, it accepts `skip` used in `rescue` because `ensure` may be teardown process to `begin`
setup process.

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
  if condition
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