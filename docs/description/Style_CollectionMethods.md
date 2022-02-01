
This cop enforces the use of consistent method names
from the Enumerable module.

You can customize the mapping from undesired method to desired method.

e.g. to use `detect` over `find`:

  Style/CollectionMethods:
    PreferredMethods:
      find: detect

# Examples

```ruby
# These examples are based on the default mapping for `PreferredMethods`.

# bad
items.collect
items.collect!
items.inject
items.detect
items.find_all
items.member?

# good
items.map
items.map!
items.reduce
items.find
items.select
items.include?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CollectionMethods)