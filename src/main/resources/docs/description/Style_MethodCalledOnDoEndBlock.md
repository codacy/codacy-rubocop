Prefer {...} over do...end for single-line blocks. Avoid using {...} for multi-line blocks (multiline chaining is always ugly). Always use do...end for "control flow" and "method definitions" (e.g. in Rakefiles and certain DSLs). Avoid do...end when chaining.

**Example:**

```
names = %w(Bozhidar Steve Sarah)

# bad
names.each do |name|
  puts name
end

# good
names.each { |name| puts name }

# bad
names.select do |name|
  name.start_with?('S')
end.map { |name| name.upcase }

# good
names.select { |name| name.start_with?('S') }.map(&:upcase)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MethodCalledOnDoEndBlock)