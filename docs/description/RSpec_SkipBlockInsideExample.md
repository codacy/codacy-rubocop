
Checks for passing a block to `skip` within examples.

# Examples

```ruby
# bad
it 'does something' do
  skip 'not yet implemented' do
    do_something
  end
end

# good
it 'does something' do
  skip 'not yet implemented'
  do_something
end

# good - when outside example
skip 'not yet implemented' do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/SkipBlockInsideExample)