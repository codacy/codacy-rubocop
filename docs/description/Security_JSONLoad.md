
Checks for the use of JSON class methods which have potential
security issues.

`JSON.load` and similar methods allow deserialization of arbitrary ruby objects:

[source,ruby]
----
require 'json/add/string'
result = JSON.load('{ "json_class": "String", "raw": [72, 101, 108, 108, 111] }')
pp result # => "Hello"
----

Never use `JSON.load` for untrusted user input. Prefer `JSON.parse` unless you have
a concrete use-case for `JSON.load`.

NOTE: Starting with `json` gem version 2.8.0, triggering this behavior without explicitly
passing the `create_additions` keyword argument emits a deprecation warning, with the
goal of being secure by default in the next major version 3.0.0.

# Examples

```ruby
# bad
JSON.load('{}')
JSON.restore('{}')

# good
JSON.parse('{}')
JSON.unsafe_load('{}')

# good - explicit use of `create_additions` option
JSON.load('{}', create_additions: true)
JSON.load('{}', create_additions: false)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Security/JSONLoad)