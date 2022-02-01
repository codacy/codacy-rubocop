
This cop is used to identify usages of `where.take` and change them to use `find_by` instead.

And `where(...).first` can return different results from `find_by`.
(They order records differently, so the "first" record can be different.)

If you also want to detect `where.first`, you can set `IgnoreWhereFirst` to false.

# Examples

```ruby
# bad
User.where(name: 'Bruce').take

# good
User.find_by(name: 'Bruce')# good
User.where(name: 'Bruce').first# bad
User.where(name: 'Bruce').first
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/FindBy)