
This cop checks for single-line method definitions that contain a body.
It will accept single-line methods with no body.

Endless methods added in Ruby 3.0 are also accepted by this cop.

If `Style/EndlessMethod` is enabled with `EnforcedStyle: allow_single_line` or
`allow_always`, single-line methods will be auto-corrected to endless
methods if there is only one statement in the body.

# Examples

```ruby
# bad
def some_method; body end
def link_to(url); {:name => url}; end
def @table.columns; super; end

# good
def self.resource_class=(klass); end
def @table.columns; end
def some_method() = body# good
def no_op; end# bad
def no_op; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SingleLineMethods)