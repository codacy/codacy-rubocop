
Correct superclass `send` expressions by constant literals.

Sorbet, the static checker, is not (yet) able to support constructs on the
following form:

```ruby
class Foo < send_expr; end
```

Multiple occurences of this can be found in Shopify's code base like:

```ruby
class ShopScope < Component::TrustedIdScope[ShopIdentity::ShopId]
```
or
```ruby
class ApiClientEligibility < Struct.new(:api_client, :match_results, :shop)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidSuperclassConstLiteral)