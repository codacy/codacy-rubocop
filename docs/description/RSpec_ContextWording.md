
Checks that `context` docstring starts with an allowed prefix.

The default list of prefixes is minimal. Users are encouraged to tailor
the configuration to meet project needs. Other acceptable prefixes may
include `if`, `unless`, `for`, `before`, `after`, or `during`.
They may consist of multiple words if desired.

If both `Prefixes` and `AllowedPatterns` are empty, this cop will always
report an offense. So you need to set at least one of them.

This cop can be customized allowed context description pattern
with `AllowedPatterns`. By default, there are no checking by pattern.

# Examples

```ruby
# .rubocop.yml
# RSpec/ContextWording:
#   Prefixes:
#     - when
#     - with
#     - without
#     - if
#     - unless
#     - for# bad
context 'the display name not present' do
  # ...
end

# good
context 'when the display name is not present' do
  # ...
end
# .rubocop.yml
# RSpec/ContextWording:
#   AllowedPatterns:
#     - とき$# bad
context '条件を満たす' do
  # ...
end

# good
context '条件を満たすとき' do
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ContextWording)