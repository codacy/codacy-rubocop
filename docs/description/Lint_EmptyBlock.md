
Checks for blocks without a body.
Such empty blocks are typically an oversight or we should provide a comment
be clearer what we're aiming for.

Empty lambdas and procs are ignored by default.

NOTE: For backwards compatibility, the configuration that allows/disallows
empty lambdas and procs is called `AllowEmptyLambdas`, even though it also
applies to procs.

# Examples

```ruby
# bad
items.each { |item| }

# good
items.each { |item| puts item }# good
items.each do |item|
  # TODO: implement later (inner comment)
end

items.each { |item| } # TODO: implement later (inline comment)# bad
items.each do |item|
  # TODO: implement later (inner comment)
end

items.each { |item| } # TODO: implement later (inline comment)# good
allow(subject).to receive(:callable).and_return(-> {})

placeholder = lambda do
end
(callable || placeholder).call

proc { }

Proc.new { }# bad
allow(subject).to receive(:callable).and_return(-> {})

placeholder = lambda do
end
(callable || placeholder).call

proc { }

Proc.new { }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EmptyBlock)