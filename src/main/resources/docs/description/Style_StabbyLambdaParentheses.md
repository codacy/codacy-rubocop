
Check for parentheses around stabby lambda arguments.
There are two different styles. Defaults to `require_parentheses`.

# Examples

```ruby
# bad
->a,b,c { a + b + c }

# good
->(a,b,c) { a + b + c}# bad
->(a,b,c) { a + b + c }

# good
->a,b,c { a + b + c}
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/StabbyLambdaParentheses)