
This cop ensures empty class/module definitions in RBI files are
done on a single line rather than being split across multiple lines.

# Examples

```ruby

# bad
module SomeModule
end

# good
module SomeModule; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/SingleLineRbiClassModuleDefinitions)