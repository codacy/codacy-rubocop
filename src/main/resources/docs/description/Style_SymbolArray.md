
This cop can check for array literals made up of symbols that are not
using the %i() syntax.

Alternatively, it checks for symbol arrays using the %i() syntax on
projects which do not want to use that syntax.

Configuration option: MinSize
If set, arrays with fewer elements than this value will not trigger the
cop. For example, a `MinSize of `3` will not enforce a style on an array
of 2 or fewer elements.

# Examples

```ruby
# good
%i[foo bar baz]

# bad
[:foo, :bar, :baz]# good
[:foo, :bar, :baz]

# bad
%i[foo bar baz]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SymbolArray)