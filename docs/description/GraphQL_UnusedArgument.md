
Arguments should either be listed explicitly or **rest should be in the resolve signature
(and similar methods, such as #authorized?).

# Examples

```ruby
# good

class SomeResolver < Resolvers::Base
  argument :arg1, String, required: true
  argument :user_id, String, required: true, loads: Types::UserType
  argument :post_id, String, loads: Types::PostType, as: :article
  argument :comment_ids, String, loads: Types::CommentType

  def authorized?(arg1:, user:, article:, comments:); end
  def resolve(arg1:, user:, article:, comments:); end
end

# good

class SomeResolver < Resolvers::Base
  argument :arg1, String, required: true
  argument :user_id, String, required: true, loads: Types::UserType
  argument :comment_ids, String, loads: Types::CommentType

  def resolve(arg1:, **rest); end
end

# good

class SomeResolver < Resolvers::Base
  type SomeType, null: false

  argument :arg1, String, required: true
  argument :arg2, String, required: true

  def resolve(args); end
end

# bad

class SomeResolver < Resolvers::Base
  type SomeType, null: false

  argument :arg1, String, required: true
  argument :arg2, String, required: true

  def authorized?; end
  def resolve(arg1:); end
end

# bad

class SomeResolver < Resolvers::Base
  type SomeType, null: false

  argument :arg1, String, required: true
  argument :arg2, String, required: true

  def resolve; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/UnusedArgument)