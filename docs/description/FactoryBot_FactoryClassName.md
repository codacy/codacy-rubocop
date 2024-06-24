
Use string value when setting the class attribute explicitly.

This cop would promote faster tests by lazy-loading of
application files. Also, this could help you suppress potential bugs
in combination with external libraries by avoiding a preload of
application files from the factory files.

# Examples

```ruby
# bad
factory :foo, class: Foo do
end

# good
factory :foo, class: 'Foo' do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/FactoryBot/FactoryClassName)