
Avoid instance variables in rack middleware.

Middlewares are initialized once, meaning any instance variables are shared between executor threads.
To avoid potential race conditions, it's recommended to design middlewares to be stateless
or to implement proper synchronization mechanisms.

# Examples

```ruby
# bad
class CounterMiddleware
  def initialize(app)
    @app = app
    @counter = 0
  end

  def call(env)
    app.call(env)
  ensure
    @counter += 1
  end
end

# good
class CounterMiddleware
  def initialize(app)
    @app = app
    @counter = Concurrent::AtomicReference.new(0)
  end

  def call(env)
    app.call(env)
  ensure
    @counter.update { |ref| ref + 1 }
  end
end

class IdentityMiddleware
  def initialize(app)
    @app = app
  end

  def call(env)
    app.call(env)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/ThreadSafety/RackMiddlewareInstanceVariable)