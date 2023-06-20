
Identifies usages of http methods like `get`, `post`,
`put`, `patch` without the usage of keyword arguments in your tests and
change them to use keyword args. This cop only applies to Rails >= 5.
If you are running Rails < 5 you should disable the
Rails/HttpPositionalArguments cop or set your TargetRailsVersion in your
.rubocop.yml file to 4.2.

NOTE: It does not detect any cases where `include Rack::Test::Methods` is used
which makes the http methods incompatible behavior.

# Examples

```ruby
# bad
get :new, { user_id: 1}

# good
get :new, params: { user_id: 1 }
get :new, **options
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/HttpPositionalArguments)