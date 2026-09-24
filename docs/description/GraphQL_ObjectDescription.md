
This cop checks if a type (object, input, interface, scalar, union,
 mutation, subscription, and resolver) has a description.

 Only classes that actually declare a GraphQL type are checked: those whose
 superclass resolves to a GraphQL base (`Object`, `InputObject`, `Union`,
 `Enum`, `Scalar`, or anything ending in `Mutation`, `Subscription` or
 `Resolver`), plus modules that `include` an `*Interface` base. Plain Ruby
 classes that happen to live alongside types - error classes, analyzers,
 validators, loaders, generators - are skipped, so they no longer need to be
 silenced one by one.

 Two kinds of real type declarations are also skipped, because neither
 surfaces a description in the schema: abstract `Base*` types that other
 types inherit from, and (unless `IgnoreRootTypes` is disabled) the root
 operation types `Query`, `Mutation` and `Subscription`.

# Examples

```ruby
# good

class Types::UserType < Types::BaseObject
  description "Represents application user"
  # ...
end

# bad

class Types::UserType < Types::BaseObject
  # ...
end

# good - not a GraphQL type, so no description is expected

class TrackingInfoNotAvailable < StandardError; end
class UserLoader < GraphQL::Batch::Loader; end

# good - abstract base and root operation types carry no description

class Types::BaseObject < GraphQL::Schema::Object; end
class Types::Query < Types::BaseObject; end

# good - `ApplicationType` is not a recognized GraphQL base, so this
# class is not checked

class Types::UserType < ApplicationType
end

# bad - `ApplicationType` is now treated as a GraphQL base

class Types::UserType < ApplicationType
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/ObjectDescription)