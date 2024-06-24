
Avoid double negative condition.

Credit to Warut: https://github.com/mdsol/tenjin/pull/621#discussion_r748106992

# Examples

```ruby
# bad
do_something unless a != b

# good
do_something if a == b
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Mdsol/UnlessNotEqual)