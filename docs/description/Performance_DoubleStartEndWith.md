
Checks for consecutive `#start_with?` or `#end_with?` calls.
These methods accept multiple arguments, so in some cases like when
they are separated by `||`, they can be combined into a single method call.

`IncludeActiveSupportAliases` configuration option is used to check for
`starts_with?` and `ends_with?`. These methods are defined by Active Support.

# Examples

```ruby
# bad
str.start_with?("a") || str.start_with?(Some::CONST)
str.start_with?("a", "b") || str.start_with?("c")
!str.start_with?(foo) && !str.start_with?(bar)
str.end_with?(var1) || str.end_with?(var2)

# good
str.start_with?("a", Some::CONST)
str.start_with?("a", "b", "c")
!str.start_with?(foo, bar)
str.end_with?(var1, var2)# good
str.starts_with?("a", "b") || str.starts_with?("c")
str.ends_with?(var1) || str.ends_with?(var2)

str.starts_with?("a", "b", "c")
str.ends_with?(var1, var2)# bad
str.starts_with?("a", "b") || str.starts_with?("c")
str.ends_with?(var1) || str.ends_with?(var2)

# good
str.starts_with?("a", "b", "c")
str.ends_with?(var1, var2)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/DoubleStartEndWith)