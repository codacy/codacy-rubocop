
Looks for inline rendering within controller actions.

# Examples

```ruby
# bad
class ProductsController < ApplicationController
  def index
    render inline: "<% products.each do |p| %><p><%= p.name %></p><% end %>", type: :erb
  end
end

# good
# app/views/products/index.html.erb
# <% products.each do |p| %>
#   <p><%= p.name %></p>
# <% end %>

class ProductsController < ApplicationController
  def index
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RenderInline)