
Checks unexpected overrides of the `Data` built-in methods
via `Data.define`.

# Examples

```ruby
# bad
Bad = Data.define(:members, :clone, :to_s)
b = Bad.new(members: [], clone: true, to_s: 'bad')
b.members #=> [] (overriding `Data#members`)
b.clone #=> true (overriding `Object#clone`)
b.to_s #=> "bad" (overriding `Data#to_s`)

# good
Good = Data.define(:id, :name)
g = Good.new(id: 1, name: "foo")
g.members #=> [:id, :name]
g.clone #=> #<data Good id=1, name="foo">
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DataDefineOverride)