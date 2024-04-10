
Checks for common mistakes in example descriptions.

This cop will correct docstrings that begin with 'should' and 'it'.
This cop will also look for insufficient examples and call them out.

The autocorrect is experimental - use with care! It can be configured
with CustomTransform (e.g. have => has) and IgnoredWords (e.g. only).

Use the DisallowedExamples setting to prevent unclear or insufficient
descriptions. Please note that this config will not be treated as
case sensitive.

# Examples

```ruby
# bad
it 'should find nothing' do
end

# good
it 'finds nothing' do
end# bad
it 'it does things' do
end

# good
it 'does things' do
end# bad
it 'works' do
end

# good
it 'marks the task as done' do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ExampleWording)