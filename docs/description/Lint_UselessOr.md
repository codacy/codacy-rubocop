
Checks for useless OR (`||` and `or`) expressions.

Some methods always return a truthy value, even when called
on `nil` (e.g. `nil.to_i` evaluates to `0`). Therefore, OR expressions
appended after these methods will never evaluate.

# Examples

```ruby

# bad
x.to_a || fallback
x.to_c || fallback
x.to_d || fallback
x.to_i || fallback
x.to_f || fallback
x.to_h || fallback
x.to_r || fallback
x.to_s || fallback
x.to_sym || fallback
x.intern || fallback
x.inspect || fallback
x.hash || fallback
x.object_id || fallback
x.__id__ || fallback

x.to_s or fallback

# good - if fallback is same as return value of method called on nil
x.to_a # nil.to_a returns []
x.to_c # nil.to_c returns (0+0i)
x.to_d # nil.to_d returns 0.0
x.to_i # nil.to_i returns 0
x.to_f # nil.to_f returns 0.0
x.to_h # nil.to_h returns {}
x.to_r # nil.to_r returns (0/1)
x.to_s # nil.to_s returns ''
x.to_sym # nil.to_sym raises an error
x.intern # nil.intern raises an error
x.inspect # nil.inspect returns "nil"
x.hash # nil.hash returns an Integer
x.object_id # nil.object_id returns an Integer
x.__id__ # nil.object_id returns an Integer

# good - if the intention is not to call the method on nil
x&.to_a || fallback
x&.to_c || fallback
x&.to_d || fallback
x&.to_i || fallback
x&.to_f || fallback
x&.to_h || fallback
x&.to_r || fallback
x&.to_s || fallback
x&.to_sym || fallback
x&.intern || fallback
x&.inspect || fallback
x&.hash || fallback
x&.object_id || fallback
x&.__id__ || fallback

x&.to_s or fallback
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UselessOr)