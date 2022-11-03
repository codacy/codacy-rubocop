
Identifies places where `if-elsif` constructions
can be replaced with `case-when`.

# Examples

```ruby
# bad
if status == :active
  perform_action
elsif status == :inactive || status == :hibernating
  check_timeout
else
  final_action
end

# good
case status
when :active
  perform_action
when :inactive, :hibernating
  check_timeout
else
  final_action
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CaseLikeIf)