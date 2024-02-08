
Checks that GraphQL Argument definitions prepare arguments use String or constants
instead of `prepare: CONST_REF`
This allows better Sorbet typing.

Preference is given to an input object declaring a `def prepare(...); end` method

# Examples

```ruby
# bad
PREPARE = ->(input, context) { ... }

argument :input, prepare: PREPARE

# good
def input_prepare(input); ...; end

argument :input, prepare: :input_prepare
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/PrepareMethod)