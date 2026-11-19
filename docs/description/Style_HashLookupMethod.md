
Enforces the use of either `Hash#[]` or `Hash#fetch` for hash lookup.

This cop can be configured to prefer either bracket-style (`[]`)
or fetch-style lookup. It is disabled by default.

When enforcing `fetch` style, only single-argument bracket access is flagged.
When enforcing `brackets` style, only `fetch` calls with a single key
argument are flagged (not those with default values or blocks).

# Examples

```ruby
# bad
hash.fetch(key)

# good
hash[key]

# good - fetch with default value is allowed
hash.fetch(key, default)

# good - fetch with block is allowed
hash.fetch(key) { default }

# good - `ENV.fetch` is left to `Style/FetchEnvVar` when it is enabled
ENV.fetch(key)

# bad
hash[key]

# good
hash.fetch(key)

# good - `Array[]` and `Hash[]` are constructors
Array[element]
Hash[pairs]

# good
Rails.cache.fetch(name, options) { block }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/HashLookupMethod)