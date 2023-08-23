
Makes sure that RBI files are always located under the defined allowed paths.

Options:

* `AllowedPaths`: A list of the paths where RBI files are allowed (default: ["rbi/**", "sorbet/rbi/**"])

# Examples

```ruby
# bad
# lib/some_file.rbi
# other_file.rbi

# good
# rbi/external_interface.rbi
# sorbet/rbi/some_file.rbi
# sorbet/rbi/any/path/for/file.rbi
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidRBIOutsideOfAllowedPaths)