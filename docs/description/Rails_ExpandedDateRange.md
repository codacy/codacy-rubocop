
This cop checks for expanded date range. It only compatible `..` range is targeted.
Incompatible `...` range is ignored.

# Examples

```ruby
# bad
date.beginning_of_day..date.end_of_day
date.beginning_of_week..date.end_of_week
date.beginning_of_month..date.end_of_month
date.beginning_of_quarter..date.end_of_quarter
date.beginning_of_year..date.end_of_year

# good
date.all_day
date.all_week
date.all_month
date.all_quarter
date.all_year
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ExpandedDateRange)