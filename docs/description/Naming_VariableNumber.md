
Makes sure that all numbered variables use the
configured style, snake_case, normalcase, or non_integer,
for their numbering.

Additionally, `CheckMethodNames` and `CheckSymbols` configuration options
can be used to specify whether method names and symbols should be checked.
Both are enabled by default.

# Examples

```ruby
# bad
:some_sym_1
variable_1 = 1

def some_method_1; end

def some_method1(arg_1); end

# good
:some_sym1
variable1 = 1

def some_method1; end

def some_method1(arg1); end# bad
:some_sym1
variable1 = 1

def some_method1; end

def some_method_1(arg1); end

# good
:some_sym_1
variable_1 = 1

def some_method_1; end

def some_method_1(arg_1); end# bad
:some_sym1
:some_sym_1

variable1 = 1
variable_1 = 1

def some_method1; end

def some_method_1; end

def some_methodone(arg1); end
def some_methodone(arg_1); end

# good
:some_symone
:some_sym_one

variableone = 1
variable_one = 1

def some_methodone; end

def some_method_one; end

def some_methodone(argone); end
def some_methodone(arg_one); end

# In the following examples, we assume `EnforcedStyle: normalcase` (default).# bad
def some_method_1; end# good
def some_method_1; end# bad
:some_sym_1# good
:some_sym_1# good
expect(Open3).to receive(:capture3)# good
:some_sym_v1
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/VariableNumber)