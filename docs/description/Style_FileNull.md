
Use `File::NULL` instead of hardcoding the null device (`/dev/null` on Unix-like
OSes, `NUL` or `NUL:` on Windows), so that code is platform independent.
Only looks for full string matches, substrings within a longer string are not
considered.

However, only files that use the string `'/dev/null'` are targeted for detection.
This is because the string `'NUL'` is not limited to the null device.
This behavior results in false negatives when the `'/dev/null'` string is not used,
but it is a trade-off to avoid false positives. `NULL:`
Unlike `'NUL'`, `'NUL:'` is regarded as something like `C:` and is always detected.

NOTE: Uses inside arrays and hashes are ignored.

# Examples

```ruby
# bad
'/dev/null'
'NUL'
'NUL:'

# good
File::NULL

# ok - inside an array
null_devices = %w[/dev/null nul]

# ok - inside a hash
{ unix: "/dev/null", windows: "nul" }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/FileNull)