
Checks that `T::Struct` property names use the configured style.
The supported styles and name filters match `Naming/MethodName`.

# Examples

```ruby
# bad
class User < T::Struct
  const :firstName, String
  prop :lastName, String
end

# good
class User < T::Struct
  const :first_name, String
  prop :last_name, String
end

# bad
class User < T::Struct
  const :first_name, String
  prop :last_name, String
end

# good
class User < T::Struct
  const :firstName, String
  prop :lastName, String
end

# good
class User < T::Struct
  const :legacyName, String
end

# bad
class User < T::Struct
  const :legacy_name, String
end

# bad
class User < T::Struct
  const :name_v1, String
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/StructPropName)