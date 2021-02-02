
This cop checks dynamic `find_by_*` methods.
Use `find_by` instead of dynamic method.
See. https://rails.rubystyle.guide#find_by

# Examples

```ruby
# bad
User.find_by_name(name)
User.find_by_name_and_email(name)
User.find_by_email!(name)

# good
User.find_by(name: name)
User.find_by(name: name, email: email)
User.find_by!(email: email)# bad
User.find_by_query(users_query)

# good
User.find_by_sql(users_sql)# bad
Specification.find_by_name('backend').gem_dir

# good
Gem::Specification.find_by_name('backend').gem_dir
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/DynamicFindBy)