You should use the Ruby 1.9 hash literal syntax when your hash keys are symbols.

**Example: **

 ```
# bad
hash = { :one => 1, :two => 2, :three => 3 }

# good
hash = { one: 1, two: 2, three: 3 }
 ```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/HashSyntax)