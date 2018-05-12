
Modifiers should be indented as deep as method definitions, or as deep
as the class/module keyword, depending on configuration.

# Examples

```ruby
# bad
class Plumbus
private
  def smooth; end
end

# good
class Plumbus
  private
  def smooth; end
end# bad
class Plumbus
  private
  def smooth; end
end

# good
class Plumbus
private
  def smooth; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/AccessModifierIndentation)