
Checks for places where I18n "lazy" lookup can be used.

This cop has two different enforcement modes. When the EnforcedStyle
is `lazy` (the default), explicit lookups are added as offenses.

When the EnforcedStyle is `explicit` then lazy lookups are added as
offenses.

# Examples

```ruby
# en.yml
# en:
#   books:
#     create:
#       success: Book created!

# bad
class BooksController < ApplicationController
  def create
    # ...
    redirect_to books_url, notice: t('books.create.success')
  end
end

# good
class BooksController < ApplicationController
  def create
    # ...
    redirect_to books_url, notice: t('.success')
  end
end# bad
class BooksController < ApplicationController
  def create
    # ...
    redirect_to books_url, notice: t('.success')
  end
end

# good
class BooksController < ApplicationController
  def create
    # ...
    redirect_to books_url, notice: t('books.create.success')
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/I18nLazyLookup)