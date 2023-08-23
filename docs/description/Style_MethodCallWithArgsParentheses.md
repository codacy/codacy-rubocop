
Enforces the presence (default) or absence of parentheses in
method calls containing parameters.

In the default style (require_parentheses), macro methods are allowed.
Additional methods can be added to the `AllowedMethods` or
`AllowedPatterns` list. These options are valid only in the default
style. Macros can be included by either setting `IgnoreMacros` to false
or adding specific macros to the `IncludedMacros` list.

Precedence of options is as follows:

1. `AllowedMethods`
2. `AllowedPatterns`
3. `IncludedMacros`

If a method is listed in both `IncludedMacros` and `AllowedMethods`,
then the latter takes precedence (that is, the method is allowed).

In the alternative style (omit_parentheses), there are three additional
options.

1. `AllowParenthesesInChaining` is `false` by default. Setting it to
   `true` allows the presence of parentheses in the last call during
   method chaining.

2. `AllowParenthesesInMultilineCall` is `false` by default. Setting it
    to `true` allows the presence of parentheses in multi-line method
    calls.

3. `AllowParenthesesInCamelCaseMethod` is `false` by default. This
    allows the presence of parentheses when calling a method whose name
    begins with a capital letter and which has no arguments. Setting it
    to `true` allows the presence of parentheses in such a method call
    even with arguments.

NOTE: The style of `omit_parentheses` allows parentheses in cases where
omitting them results in ambiguous or syntactically incorrect code.

Non-exhaustive list of examples:

- Parentheses are required allowed in method calls with arguments inside
  literals, logical operators, setting default values in position and
  keyword arguments, chaining and more.
- Parentheses are allowed in method calls with arguments inside
  operators to avoid ambiguity.
  triple-dot syntax introduced in Ruby 2.7 as omitting them starts an
  endless range.
- Parentheses are allowed when forwarding arguments with the
  triple-dot syntax introduced in Ruby 2.7 as omitting them starts an
  endless range.
- Parentheses are required in calls with arguments when inside an
  endless method definition introduced in Ruby 3.0.
- Ruby 3.1's hash omission syntax allows parentheses if the method call
  is in conditionals and requires parentheses if the call
  is not the value-returning expression. See
  https://bugs.ruby-lang.org/issues/18396.
- Parentheses are required in anonymous arguments, keyword arguments
  and block passing in Ruby 3.2.

# Examples

```ruby

# bad
array.delete e

# good
array.delete(e)

# good
# Operators don't need parens
foo == bar

# good
# Setter methods don't need parens
foo.bar = baz

# okay with `puts` listed in `AllowedMethods`
puts 'test'

# okay with `^assert` listed in `AllowedPatterns`
assert_equal 'test', x
# bad
array.delete(e)

# good
array.delete e

# bad
action.enforce(strict: true)

# good
action.enforce strict: true

# good
# Parentheses are allowed for code that can be ambiguous without
# them.
action.enforce(condition) || other_condition

# good
# Parentheses are allowed for calls that won't produce valid Ruby
# without them.
yield path, File.basename(path)

# good
# Omitting the parentheses in Ruby 3.1 hash omission syntax can lead
# to ambiguous code. We allow them in conditionals and non-last
# expressions. See https://bugs.ruby-lang.org/issues/18396
if meets(criteria:, action:)
  safe_action(action) || dangerous_action(action)
end
# good
class Foo
  bar :baz
end
# bad
class Foo
  bar :baz
end
# bad
foo.enforce(
  strict: true
)

# good
foo.enforce \
  strict: true
# good
foo.enforce(
  strict: true
)

# good
foo.enforce \
  strict: true
# bad
foo().bar(1)

# good
foo().bar 1
# good
foo().bar(1)

# good
foo().bar 1
# bad
Array(1)

# good
Array 1
# good
Array(1)

# good
Array 1
# bad
"#{t('this.is.bad')}"

# good
"#{t 'this.is.better'}"
# good
"#{t('this.is.good')}"

# good
"#{t 'this.is.also.good'}"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MethodCallWithArgsParentheses)