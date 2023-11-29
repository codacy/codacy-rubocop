
Checks that left braces for adjacent single line lets are aligned.

# Examples

```ruby
# bad
let(:foobar) { blahblah }
let(:baz) { bar }
let(:a) { b }

# good
let(:foobar) { blahblah }
let(:baz)    { bar }
let(:a)      { b }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/AlignLeftLetBrace)