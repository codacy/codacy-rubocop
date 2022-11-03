
Enforces the use of dot-separated locale keys instead of specifying the `:scope` option
with an array or a single symbol in `I18n` translation methods.
Dot-separated notation is easier to read and trace the hierarchy.

# Examples

```ruby
# bad
I18n.t :record_invalid, scope: [:activerecord, :errors, :messages]
I18n.t :title, scope: :invitation

# good
I18n.t 'activerecord.errors.messages.record_invalid'
I18n.t :record_invalid, scope: 'activerecord.errors.messages'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/DotSeparatedKeys)