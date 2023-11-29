
Checks that no class, module, or constant is declared.

Constants, including classes and modules, when declared in a block
scope, are defined in global namespace, and leak between examples.

If several examples may define a `DummyClass`, instead of being a
blank slate class as it will be in the first example, subsequent
examples will be reopening it and modifying its behavior in
unpredictable ways.
Even worse when a class that exists in the codebase is reopened.

Anonymous classes are fine, since they don't result in global
namespace name clashes.

# Examples

```ruby
# bad
describe SomeClass do
  OtherClass = Struct.new
  CONSTANT_HERE = 'I leak into global namespace'
end

# good
describe SomeClass do
  before do
    stub_const('OtherClass', Struct.new)
    stub_const('CONSTANT_HERE', 'I only exist during this example')
  end
end# bad
describe SomeClass do
  class FooClass < described_class
    def double_that
      some_base_method * 2
    end
  end

  it { expect(FooClass.new.double_that).to eq(4) }
end

# good - anonymous class, no constant needs to be defined
describe SomeClass do
  let(:foo_class) do
    Class.new(described_class) do
      def double_that
        some_base_method * 2
      end
    end
  end

  it { expect(foo_class.new.double_that).to eq(4) }
end

# good - constant is stubbed
describe SomeClass do
  before do
    foo_class = Class.new(described_class) do
                  def do_something
                  end
                end
    stub_const('FooClass', foo_class)
  end

  it { expect(FooClass.new.double_that).to eq(4) }
end# bad
describe SomeClass do
  module SomeModule
    class SomeClass
      def do_something
      end
    end
  end
end

# good
describe SomeClass do
  before do
    foo_class = Class.new(described_class) do
                  def do_something
                  end
                end
    stub_const('SomeModule::SomeClass', foo_class)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/LeakyConstantDeclaration)