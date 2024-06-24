
Checks that Faker arguments style is based on Faker 2.
Use keyword arguments instead of positional arguments.

# Examples

```ruby
# bad
Avatar.image(slug, size, format)

# good
Avatar.image(slug: slug, size: size, format: format)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Faker/DeprecatedArguments)