
Avoid instance variables in class methods.

# Examples

```ruby
# bad
class User
  def self.notify(info)
    @info = validate(info)
    Notifier.new(@info).deliver
  end
end

class Model
  class << self
    def table_name(name)
      @table_name = name
    end
  end
end

class Host
  %i[uri port].each do |key|
    define_singleton_method("#{key}=") do |value|
      instance_variable_set("@#{key}", value)
    end
  end
end

module Example
  module ClassMethods
    def test(params)
      @params = params
    end
  end
end

module Example
  class_methods do
    def test(params)
      @params = params
    end
  end
end

module Example
  module_function

  def test(params)
    @params = params
  end
end

module Example
  def test(params)
    @params = params
  end

  module_function :test
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/ThreadSafety/InstanceVariableInClassMethod)