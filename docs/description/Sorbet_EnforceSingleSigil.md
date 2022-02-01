
This cop checks that there is only one Sorbet sigil in a given file

For example, the following class with two sigils

```ruby
# typed: true
# typed: true
# frozen_string_literal: true
class Foo; end
```

Will be corrected as:

```ruby
# typed: true
# frozen_string_literal: true
class Foo; end
```

Other comments or magic comments are left in place.

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/EnforceSingleSigil)