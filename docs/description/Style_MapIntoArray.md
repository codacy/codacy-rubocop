
Checks for usages of `each` with `<<`, `push`, or `append` which
can be replaced by `map`.

If `PreferredMethods` is configured for `map` in `Style/CollectionMethods`,
this cop uses the specified method for replacement.

NOTE: The return value of `Enumerable#each` is `self`, whereas the
return value of `Enumerable#map` is an `Array`. They are not autocorrected
when a return value could be used because these types differ.

NOTE: It only detects when the mapping destination is a local variable
initialized as an empty array and referred to only by the pushing operation.
This is because, if not, it's challenging to statically guarantee that the
mapping destination variable remains an empty array:

[source,ruby]
----
src.each { |e| @dest << e * 2 } # `src` method may mutate `@dest`

dest = []
src.each { |e| dest << transform(e, dest) } # `transform` method may mutate `dest`
----

# Examples

```ruby
# bad
dest = []
src.each { |e| dest << e * 2 }
dest

# good
dest = src.map { |e| e * 2 }

# good - contains another operation
dest = []
src.each { |e| dest << e * 2; puts e }
dest
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MapIntoArray)