
Checks for debug calls (such as `debugger` or `binding.pry`) that should
not be kept for production code.

The cop can be configured using `DebuggerMethods`. By default, a number of gems
debug entrypoints are configured (`Kernel`, `Byebug`, `Capybara`, `debug.rb`,
`Pry`, `Rails`, `RubyJard`, and `WebConsole`). Additional methods can be added.

Specific default groups can be disabled if necessary:

[source,yaml]
----
Lint/Debugger:
  DebuggerMethods:
    WebConsole: ~
----

You can also add your own methods by adding a new category:

[source,yaml]
----
Lint/Debugger:
  DebuggerMethods:
    MyDebugger:
      MyDebugger.debug_this
----

Some gems also ship files that will start a debugging session when required,
for example `require 'debug/start'` from `ruby/debug`. These requires can
be configured through `DebuggerRequires`. It has the same structure as
`DebuggerMethods`, which you can read about above.

# Examples

```ruby

# bad (ok during development)

# using pry
def some_method
  binding.pry
  do_something
end

# bad (ok during development)

# using byebug
def some_method
  byebug
  do_something
end

# good

def some_method
  do_something
end
# bad (ok during development)

def some_method
  my_debugger
end
# bad (ok during development)

require 'my_debugger/start'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/Debugger)