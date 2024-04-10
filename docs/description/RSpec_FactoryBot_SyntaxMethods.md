
Use shorthands from `FactoryBot::Syntax::Methods` in your specs.

# Examples

```ruby
# bad
FactoryBot.create(:bar)
FactoryBot.build(:bar)
FactoryBot.attributes_for(:bar)

# good
create(:bar)
build(:bar)
attributes_for(:bar)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/FactoryBot/SyntaxMethods)