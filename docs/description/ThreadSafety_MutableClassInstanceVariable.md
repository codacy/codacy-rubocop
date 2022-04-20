
This cop checks whether some class instance variable isn't a
mutable literal (e.g. array or hash).

It is based on Style/MutableConstant from RuboCop.
See https://github.com/rubocop-hq/rubocop/blob/master/lib/rubocop/cop/style/mutable_constant.rb

Class instance variables are a risk to threaded code as they are shared
between threads. A mutable object such as an array or hash may be
updated via an attr_reader so would not be detected by the
ThreadSafety/ClassAndModuleAttributes cop.

Strict mode can be used to freeze all class instance variables, rather
than just literals.
Strict mode is considered an experimental feature. It has not been
updated with an exhaustive list of all methods that will produce frozen
objects so there is a decent chance of getting some false positives.
Luckily, there is no harm in freezing an already frozen object.

# Examples

```ruby
# bad
class Model
  @list = [1, 2, 3]
end

# good
class Model
  @list = [1, 2, 3].freeze
end

# good
class Model
  @var = <<~TESTING.freeze
    This is a heredoc
  TESTING
end

# good
class Model
  @var = Something.new
end# bad
class Model
  @var = Something.new
end

# bad
class Model
  @var = Struct.new do
    def foo
      puts 1
    end
  end
end

# good
class Model
  @var = Something.new.freeze
end

# good
class Model
  @var = Struct.new do
    def foo
      puts 1
    end
  end.freeze
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/ThreadSafety/MutableClassInstanceVariable)