
Identifies places where `if-elsif` constructions
can be replaced with `case-when`.

# Examples

```ruby
# bad
if status == :active
  perform_action
elsif status == :inactive || status == :hibernating
  check_timeout
elsif status == :invalid
  report_invalid
else
  final_action
end

# good
case status
when :active
  perform_action
when :inactive, :hibernating
  check_timeout
when :invalid
  report_invalid
else
  final_action
end# good
if status == :active
  perform_action
elsif status == :inactive || status == :hibernating
  check_timeout
elsif status == :invalid
  report_invalid
else
  final_action
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CaseLikeIf)