
Checks dynamic `find_by_*` methods.
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
User.find_by_token_for(:password_reset, token)

# good
User.find_by_sql(users_sql)
User.find_by_token_for(:password_reset, token)# bad
Specification.find_by_name('backend').gem_dir
page.find_by_id('a_dom_id').click

# good
Gem::Specification.find_by_name('backend').gem_dir
page.find_by_id('a_dom_id').click
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/DynamicFindBy)