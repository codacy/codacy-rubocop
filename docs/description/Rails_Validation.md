
Checks for the use of old-style attribute validation macros.

# Examples

```ruby
# bad
validates_acceptance_of :foo
validates_comparison_of :foo
validates_confirmation_of :foo
validates_exclusion_of :foo
validates_format_of :foo
validates_inclusion_of :foo
validates_length_of :foo
validates_numericality_of :foo
validates_presence_of :foo
validates_absence_of :foo
validates_size_of :foo
validates_uniqueness_of :foo

# good
validates :foo, acceptance: true
validates :foo, confirmation: true
validates :foo, comparison: true
validates :foo, exclusion: true
validates :foo, format: true
validates :foo, inclusion: true
validates :foo, length: true
validates :foo, numericality: true
validates :foo, presence: true
validates :foo, absence: true
validates :foo, length: true
validates :foo, uniqueness: true
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/Validation)