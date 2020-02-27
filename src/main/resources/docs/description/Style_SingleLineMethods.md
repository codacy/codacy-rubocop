
This cop checks for single-line method definitions that contain a body.
It will accept single-line methods with no body.

# Examples

```ruby
# bad
def some_method; body end
def link_to(url); {:name => url}; end
def @table.columns; super; end

# good
def self.resource_class=(klass); end
def @table.columns; end# good
def no_op; end# bad
def no_op; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SingleLineMethods)