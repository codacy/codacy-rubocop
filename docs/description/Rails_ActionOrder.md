
Enforces consistent ordering of the standard Rails RESTful controller actions.

The cop is configurable and can enforce any ordering of the standard actions.
All other methods are ignored.

[source,yaml]
----
 Rails/ActionOrder:
   ExpectedOrder:
     - index
     - show
     - new
     - edit
     - create
     - update
     - destroy
----

# Examples

```ruby
# bad
def index; end
def destroy; end
def show; end

# good
def index; end
def show; end
def destroy; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ActionOrder)