
Checks for `case` statements whose `when` conditions are only proc/lambda
literals and value literals (with at least one proc).

Such a `case` is just a harder-to-read `if`/`elsif` tree with a needless
performance cost: a `when` clause matches using `pattern === subject`,
and for a proc `Proc#===` is an alias for `Proc#call`. Every inline proc
literal therefore allocates a brand new `Proc` object each time the
`case` is evaluated (on a hot path, once per branch per call) and adds
`Proc#call` indirection, where an `if`/`elsif` allocates nothing. For a
value literal (number, string, symbol, `nil`, `true`, `false`) `===` is
`==`, so the whole statement is exactly equivalent to `if`/`elsif` using
`Proc#call` and `==`. Use `if`/`elsif` instead.

Constants assigned a proc literal or a value literal *in the same file*
are resolved and treated as such. Constants defined in other files cannot
be resolved: a bare `when SOME_CONST` is indistinguishable from matching
against a class, so those are left alone to avoid flagging idiomatic
`case obj when SomeClass`.

Cases that use class, range, or regexp patterns are also left alone:
those rely on `===` in ways that read far worse as `if` conditions
(`is_a?`, `cover?`, `match?`), which is exactly what `case` is for.

# Examples

```ruby

# bad - every `when` is a proc (a new proc is allocated on each call)
case value
when ->(x) { x > 10 } then :big
when ->(x) { x < 0 }  then :negative
else :other
end

# bad - only procs and value literals (including value-literal constants)
NAME = "widget"
case value
when NAME             then :named
when ->(x) { x > 10 } then :big
end

# good - no proc allocation, and easier to read
if value > 10
  :big
elsif value < 0
  :negative
else
  :other
end

# good - a class/range/regexp pattern makes `case` the clearer choice,
# even alongside a proc.
case value
when Integer          then :int
when ->(x) { x > 10 } then :big
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ProcCaseWhen)