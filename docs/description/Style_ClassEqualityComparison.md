
Enforces the use of `Object#instance_of?` instead of class comparison
for equality.
`==`, `equal?`, and `eql?` custom method definitions are allowed by default.
These are customizable with `AllowedMethods` option.

# Examples

```ruby
# bad
var.class == Date
var.class.equal?(Date)
var.class.eql?(Date)
var.class.name == 'Date'

# good
var.instance_of?(Date)# good
def ==(other)
  self.class == other.class && name == other.name
end

def equal?(other)
  self.class.equal?(other.class) && name.equal?(other.name)
end

def eql?(other)
  self.class.eql?(other.class) && name.eql?(other.name)
end# bad
def eq(other)
  self.class.eq(other.class) && name.eq(other.name)
end# good
def eq(other)
  self.class.eq(other.class) && name.eq(other.name)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ClassEqualityComparison)