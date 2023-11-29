
Ensure that subject is defined using subject helper.

# Examples

```ruby
# bad
let(:subject) { foo }
let!(:subject) { foo }
subject(:subject) { foo }
subject!(:subject) { foo }

# bad
block = -> {}
let(:subject, &block)

# good
subject(:test_subject) { foo }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/SubjectDeclaration)