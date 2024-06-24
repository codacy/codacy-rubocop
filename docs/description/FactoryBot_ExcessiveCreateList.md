
Check for excessive model creation in a list.

# Examples

```ruby
# We do not allow more than 10 items to be created

# bad
create_list(:merge_request, 1000, state: :opened)

# good
create_list(:merge_request, 10, state: :opened)# We do not allow more than 20 items to be created

# bad
create_list(:merge_request, 1000, state: :opened)

# good
create_list(:merge_request, 15, state: :opened)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/FactoryBot/ExcessiveCreateList)