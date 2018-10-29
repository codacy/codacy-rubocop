
This cop enforces the use of consistent method names
from the Enumerable module.

Unfortunately we cannot actually know if a method is from
Enumerable or not (static analysis limitation), so this cop
can yield some false positives.

You can customize the mapping from undesired method to desired method.

e.g. to use `detect` over `find`:

  Style/CollectionMethods:
    PreferredMethods:
      find: detect

The default mapping for `PreferredMethods` behaves as follows.

# Examples

```ruby
# bad
items.collect
items.collect!
items.inject
items.detect
items.find_all

# good
items.map
items.map!
items.reduce
items.find
items.select
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CollectionMethods)