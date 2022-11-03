
Checks for the use of `I18n.locale=` method.

The `locale` attribute persists for the rest of the Ruby runtime, potentially causing
unexpected behavior at a later time.
Using `I18n.with_locale` ensures the code passed in the block is the only place `I18n.locale` is affected.
It eliminates the possibility of a `locale` sticking around longer than intended.

# Examples

```ruby
# bad
I18n.locale = :fr

# good
I18n.with_locale(:fr) do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/I18nLocaleAssignment)