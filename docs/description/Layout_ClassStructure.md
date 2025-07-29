
Checks if the code style follows the `ExpectedOrder` configuration:

`Categories` allows us to map macro names into a category.

Consider an example of code style that covers the following order:

* Module inclusion (`include`, `prepend`, `extend`)
* Constants
* Associations (`has_one`, `has_many`)
* Public attribute macros (`attr_accessor`, `attr_writer`, `attr_reader`)
* Other macros (`validates`, `validate`)
* Public class methods
* Initializer
* Public instance methods
* Protected attribute macros (`attr_accessor`, `attr_writer`, `attr_reader`)
* Protected instance methods
* Private attribute macros (`attr_accessor`, `attr_writer`, `attr_reader`)
* Private instance methods

NOTE: Simply enabling the cop with `Enabled: true` will not use
the example order shown below.
To enforce the order of macros like `attr_reader`,
you must define both `ExpectedOrder` *and* `Categories`.

You can configure the following order:

[source,yaml]
----
 Layout/ClassStructure:
   ExpectedOrder:
     - module_inclusion
     - constants
     - association
     - public_attribute_macros
     - public_delegate
     - macros
     - public_class_methods
     - initializer
     - public_methods
     - protected_attribute_macros
     - protected_methods
     - private_attribute_macros
     - private_delegate
     - private_methods
----

Instead of putting all literals in the expected order, is also
possible to group categories of macros. Visibility levels are handled
automatically.

[source,yaml]
----
 Layout/ClassStructure:
   Categories:
     association:
       - has_many
       - has_one
     attribute_macros:
       - attr_accessor
       - attr_reader
       - attr_writer
     macros:
       - validates
       - validate
     module_inclusion:
       - include
       - prepend
       - extend
----

If you only set `ExpectedOrder`
without defining `Categories`,
macros such as `attr_reader` or `has_many`
will not be recognized as part of a category, and their order will not be validated.
For example, the following will NOT raise any offenses, even if the order is incorrect:

[source,yaml]
----
Layout/ClassStructure:
  Enabled: true
  ExpectedOrder:
    - public_attribute_macros
    - initializer
----

To make it work as expected, you must also specify `Categories` like this:

[source,yaml]
----
Layout/ClassStructure:
  ExpectedOrder:
    - public_attribute_macros
    - initializer
  Categories:
    attribute_macros:
      - attr_reader
      - attr_writer
      - attr_accessor
----

# Examples

```ruby
# bad
# Expect extend be before constant
class Person < ApplicationRecord
  has_many :orders
  ANSWER = 42

  extend SomeModule
  include AnotherModule
end

# good
class Person
  # extend and include go first
  extend SomeModule
  include AnotherModule

  # inner classes
  CustomError = Class.new(StandardError)

  # constants are next
  SOME_CONSTANT = 20

  # afterwards we have public attribute macros
  attr_reader :name

  # followed by other macros (if any)
  validates :name

  # then we have public delegate macros
  delegate :to_s, to: :name

  # public class methods are next in line
  def self.some_method
  end

  # initialization goes between class methods and instance methods
  def initialize
  end

  # followed by other public instance methods
  def some_method
  end

  # protected attribute macros and methods go next
  protected

  attr_reader :protected_name

  def some_protected_method
  end

  # private attribute macros, delegate macros and methods
  # are grouped near the end
  private

  attr_reader :private_name

  delegate :some_private_delegate, to: :name

  def some_private_method
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/ClassStructure)