
This cop checks if usage of %() or %Q() matches configuration.

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