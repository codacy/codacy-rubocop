
Checks for deprecated global expectations
and autocorrects them to use expect format.

# Examples

```ruby
# bad
musts.must_equal expected_musts
wonts.wont_match expected_wonts
musts.must_raise TypeError

# good
_(musts).must_equal expected_musts
_(wonts).wont_match expected_wonts
_ { musts }.must_raise TypeError

expect(musts).must_equal expected_musts
expect(wonts).wont_match expected_wonts
expect { musts }.must_raise TypeError

value(musts).must_equal expected_musts
value(wonts).wont_match expected_wonts
value { musts }.must_raise TypeError# bad
musts.must_equal expected_musts
wonts.wont_match expected_wonts
musts.must_raise TypeError

expect(musts).must_equal expected_musts
expect(wonts).wont_match expected_wonts
expect { musts }.must_raise TypeError

value(musts).must_equal expected_musts
value(wonts).wont_match expected_wonts
value { musts }.must_raise TypeError

# good
_(musts).must_equal expected_musts
_(wonts).wont_match expected_wonts
_ { musts }.must_raise TypeError# bad
musts.must_equal expected_musts
wonts.wont_match expected_wonts
musts.must_raise TypeError

_(musts).must_equal expected_musts
_(wonts).wont_match expected_wonts
_ { musts }.must_raise TypeError

value(musts).must_equal expected_musts
value(wonts).wont_match expected_wonts
value { musts }.must_raise TypeError

# good
expect(musts).must_equal expected_musts
expect(wonts).wont_match expected_wonts
expect { musts }.must_raise TypeError# bad
musts.must_equal expected_musts
wonts.wont_match expected_wonts
musts.must_raise TypeError

_(musts).must_equal expected_musts
_(wonts).wont_match expected_wonts
_ { musts }.must_raise TypeError

expect(musts).must_equal expected_musts
expect(wonts).wont_match expected_wonts
expect { musts }.must_raise TypeError

# good
value(musts).must_equal expected_musts
value(wonts).wont_match expected_wonts
value { musts }.must_raise TypeError
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/GlobalExpectations)