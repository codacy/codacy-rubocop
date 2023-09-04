
Disallows declaring implicit conversion methods.
Since Sorbet is a nominal (not structural) type system,
implicit conversion is currently unsupported.

# Examples

```ruby

# bad
def to_str; end

# good
def to_str(x); end

# bad
def self.to_str; end

# good
def self.to_str(x); end

# bad
alias to_str to_s
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ImplicitConversionMethod)