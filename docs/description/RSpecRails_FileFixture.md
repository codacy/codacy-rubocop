
Prefer `file_fixture` over hardcoded paths into `spec/fixtures`.

# Examples

```ruby
# bad
Rails.root.join('spec', 'fixtures', 'files', 'example.pdf')

# good
file_fixture('example.pdf')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpecRails/FileFixture)