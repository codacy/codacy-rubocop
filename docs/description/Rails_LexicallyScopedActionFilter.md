
Checks that methods specified in the filter's `only` or
`except` options are defined within the same class or module.

# Examples

```ruby
# bad
class LoginController < ApplicationController
  before_action :require_login, only: %i[index settings logout]

  def index
  end
end

# good
class LoginController < ApplicationController
  before_action :require_login, only: %i[index settings logout]

  def index
  end

  def settings
  end

  def logout
  end
end# bad
module FooMixin
  extend ActiveSupport::Concern

  included do
    before_action proc { authenticate }, only: :foo
  end
end

# good
module FooMixin
  extend ActiveSupport::Concern

  included do
    before_action proc { authenticate }, only: :foo
  end

  def foo
    # something
  end
endclass ContentController < ApplicationController
  def update
    @content.update(content_attributes)
  end
end

class ArticlesController < ContentController
  before_action :load_article, only: [:update]

  # the cop requires this method, but it relies on behavior defined
  # in the superclass, so needs to invoke `super`
  def update
    super
  end

  private

  def load_article
    @content = Article.find(params[:article_id])
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/LexicallyScopedActionFilter)