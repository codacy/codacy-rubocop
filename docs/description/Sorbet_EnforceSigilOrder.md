
Checks that the Sorbet sigil comes as the first magic comment in the file, after the encoding comment if any.

The expected order for magic comments is: (en)?coding, typed, warn_indent then frozen_string_literal.

The ordering is for consistency only, except for the encoding comment which must be first, if present.

For example, the following bad ordering:

```ruby
# frozen_string_literal: true
# typed: true
class Foo; end
```

Will be corrected as:

```ruby
# typed: true
# frozen_string_literal: true
class Foo; end
```

Only `(en)?coding`, `typed`, `warn_indent` and `frozen_string_literal` magic comments are considered,
other comments or magic comments are left in the same place.

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/EnforceSigilOrder)