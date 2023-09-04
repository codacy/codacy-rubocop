
Correct `send` expressions in include statements by constant literals.

Sorbet, the static checker, is not (yet) able to support constructs on the
following form:

```ruby
class MyClass
  include send_expr
end
```

Multiple occurences of this can be found in Shopify's code base like:

```ruby
include Rails.application.routes.url_helpers
```
or
```ruby
include Polaris::Engine.helpers
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidIncludeConstLiteral)