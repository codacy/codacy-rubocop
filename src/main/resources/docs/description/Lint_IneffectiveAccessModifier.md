
This cop checks for `private` or `protected` access modifiers which are
applied to a singleton method. These access modifiers do not make
singleton methods private/protected. `private_class_method` can be
used for that.

# Examples

```ruby

# bad

class C
  private

  def self.method
    puts 'hi'
  end
end
# good

class C
  def self.method
    puts 'hi'
  end

  private_class_method :method
end
# good

class C
  class << self
    private

    def method
      puts 'hi'
    end
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/IneffectiveAccessModifier)