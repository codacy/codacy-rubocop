
This cop looks for has_(one|many) and belongs_to associations where
Active Record can't automatically determine the inverse association
because of a scope or the options used. Using the blog with order scope
example below, traversing the a Blog's association in both directions
with `blog.posts.first.blog` would cause the `blog` to be loaded from
the database twice.

`:inverse_of` must be manually specified for Active Record to use the
associated object in memory, or set to `false` to opt-out. Note that
setting `nil` does not stop Active Record from trying to determine the
inverse automatically, and is not considered a valid value for this.

# Examples

```ruby
# good
class Blog < ApplicationRecord
  has_many :posts
end

class Post < ApplicationRecord
  belongs_to :blog
end# bad
class Blog < ApplicationRecord
  has_many :posts, -> { order(published_at: :desc) }
end

class Post < ApplicationRecord
  belongs_to :blog
end

# good
class Blog < ApplicationRecord
  has_many(:posts,
    -> { order(published_at: :desc) },
    inverse_of: :blog
  )
end

class Post < ApplicationRecord
  belongs_to :blog
end

# good
class Blog < ApplicationRecord
  with_options inverse_of: :blog do
    has_many :posts, -> { order(published_at: :desc) }
  end
end

class Post < ApplicationRecord
  belongs_to :blog
end

# good
# When you don't want to use the inverse association.
class Blog < ApplicationRecord
  has_many(:posts,
    -> { order(published_at: :desc) },
    inverse_of: false
  )
end# bad
class Picture < ApplicationRecord
  belongs_to :imageable, polymorphic: true
end

class Employee < ApplicationRecord
  has_many :pictures, as: :imageable
end

class Product < ApplicationRecord
  has_many :pictures, as: :imageable
end

# good
class Picture < ApplicationRecord
  belongs_to :imageable, polymorphic: true
end

class Employee < ApplicationRecord
  has_many :pictures, as: :imageable, inverse_of: :imageable
end

class Product < ApplicationRecord
  has_many :pictures, as: :imageable, inverse_of: :imageable
end# bad
# However, RuboCop can not detect this pattern...
class Physician < ApplicationRecord
  has_many :appointments
  has_many :patients, through: :appointments
end

class Appointment < ApplicationRecord
  belongs_to :physician
  belongs_to :patient
end

class Patient < ApplicationRecord
  has_many :appointments
  has_many :physicians, through: :appointments
end

# good
class Physician < ApplicationRecord
  has_many :appointments
  has_many :patients, through: :appointments
end

class Appointment < ApplicationRecord
  belongs_to :physician, inverse_of: :appointments
  belongs_to :patient, inverse_of: :appointments
end

class Patient < ApplicationRecord
  has_many :appointments
  has_many :physicians, through: :appointments
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/InverseOf)