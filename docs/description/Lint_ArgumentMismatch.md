
Checks for calls that pass the wrong number of positional arguments to a
method whose definition is known from the project index.

The check is powered by the project-wide index, so it only runs when
`AllCops/UseProjectIndex` is enabled and the `rubydex` gem is installed.
Without the index the cop does nothing.

Only calls on constant receivers (`Foo.bar`) are considered, and only
when the receiver resolves in the index, its entire ancestry is resolved
(so a method inherited from a gem or the standard library never produces
an offense), and the called method resolves to a single, unambiguous
signature. Calls that forward arguments (`*`, `**`, `...`) are skipped
because their argument count is not statically known. Keyword arguments
passed to a method that declares no keyword parameters are counted as the
single positional hash they collapse into, matching Ruby's semantics.

Constructor calls (`Foo.new`) and keyword-argument validation are out of
scope: only positional arity of explicitly defined singleton methods is
checked. `new` is skipped outright, because `Class#new` is not in the
index: any `new` the index does find sits below it in the method
resolution order, where Ruby would never reach it.

# Examples

```ruby
# Given the project defines:
#   class Report
#     def self.generate(source, format); end
#   end

# bad
Report.generate(source)

# bad
Report.generate(source, :pdf, :extra)

# good
Report.generate(source, :pdf)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ArgumentMismatch)