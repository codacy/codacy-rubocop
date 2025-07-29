
Checks for usage of `include_examples`.

`include_examples`, unlike `it_behaves_like`, does not create its
own context. As such, using `subject`, `let`, `before`/`after`, etc.
within shared examples included with `include_examples` can have
unexpected behavior and side effects.

Prefer using `it_behaves_like` instead.

# Examples

```ruby
# bad
include_examples 'examples'

# good
it_behaves_like 'examples'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/IncludeExamples)