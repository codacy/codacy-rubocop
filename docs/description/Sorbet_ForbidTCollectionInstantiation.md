
Disallows instantiating Sorbet collection types. Instantiate the Ruby
collection directly and declare its type separately when needed.

Checks `T::Array`, `T::Hash`, `T::Set`, `T::Range`,
`T::Enumerator`, `T::Enumerator::Lazy`, and `T::Enumerator::Chain`,
with or without type arguments.

Set `AutocorrectToRBS: true` to replace Sorbet constructors with Ruby
constructors. RBS inline type annotations are added only to assignments.
Assignments with an existing RBS annotation or an untranslatable type
are not autocorrected.
Empty Array and Hash constructors use literals unless arguments, blocks,
or comments inside the call need to be preserved.

# Examples

```ruby
# bad
T::Array[String].new
T::Hash[Symbol, Integer].new
T::Set[String].new
T::Array.new

# good
Array.new
Hash.new
Set.new
T.let(Array.new, T::Array[String])
Set.new #: Set[String]

# bad
arr = T::Array[String].new
items = T::Set[T.nilable(String)].new(values)
consume(T::Array[String].new)

# good
arr = [] #: Array[String]
items = Set.new(values) #: Set[String?]
consume([])
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTCollectionInstantiation)