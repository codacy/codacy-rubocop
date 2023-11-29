
Checks for opportunities to use `expect { ... }.to output`.

# Examples

```ruby
# bad
$stdout = StringIO.new
my_app.print_report
$stdout = STDOUT
expect($stdout.string).to eq('Hello World')

# good
expect { my_app.print_report }.to output('Hello World').to_stdout
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ExpectOutput)