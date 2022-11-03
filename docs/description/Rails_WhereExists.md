
Enforces consistent style when using `exists?`.

Two styles are supported for this cop. When EnforcedStyle is 'exists'
then the cop enforces `exists?(...)` over `where(...).exists?`.

When EnforcedStyle is 'where' then the cop enforces
`where(...).exists?` over `exists?(...)`.

# Examples

```ruby
# bad
User.where(name: 'john').exists?
User.where(['name = ?', 'john']).exists?
User.where('name = ?', 'john').exists?
user.posts.where(published: true).exists?

# good
User.exists?(name: 'john')
User.where('length(name) > 10').exists?
user.posts.exists?(published: true)# bad
User.exists?(name: 'john')
User.exists?(['name = ?', 'john'])
User.exists?('name = ?', 'john')
user.posts.exists?(published: true)

# good
User.where(name: 'john').exists?
User.where(['name = ?', 'john']).exists?
User.where('name = ?', 'john').exists?
user.posts.where(published: true).exists?
User.where('length(name) > 10').exists?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/WhereExists)