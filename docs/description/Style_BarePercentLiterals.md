
Checks if usage of `%()` or `%Q()` matches configuration.
Consistent use of one style makes the codebase easier
to read.

# Examples

```ruby
# bad
%Q(He said: "#{greeting}")
%q{She said: 'Hi'}

# good
%(He said: "#{greeting}")
%{She said: 'Hi'}# bad
%|He said: "#{greeting}"|
%/She said: 'Hi'/

# good
%Q|He said: "#{greeting}"|
%q/She said: 'Hi'/
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/BarePercentLiterals)