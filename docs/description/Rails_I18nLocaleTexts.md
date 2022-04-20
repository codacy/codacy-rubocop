
Enforces use of I18n and locale files instead of locale specific strings.

# Examples

```ruby
# bad
class User < ApplicationRecord
  validates :email, presence: { message: "must be present" }
end

# good
# config/locales/en.yml
# en:
#   activerecord:
#     errors:
#       models:
#         user:
#           blank: "must be present"

class User < ApplicationRecord
  validates :email, presence: true
end

# bad
class PostsController < ApplicationController
  def create
    # ...
    redirect_to root_path, notice: "Post created!"
  end
end

# good
# config/locales/en.yml
# en:
#   posts:
#     create:
#       success: "Post created!"

class PostsController < ApplicationController
  def create
    # ...
    redirect_to root_path, notice: t(".success")
  end
end

# bad
class UserMailer < ApplicationMailer
  def welcome(user)
    mail(to: user.email, subject: "Welcome to My Awesome Site")
  end
end

# good
# config/locales/en.yml
# en:
#   user_mailer:
#     welcome:
#       subject: "Welcome to My Awesome Site"

class UserMailer < ApplicationMailer
  def welcome(user)
    mail(to: user.email)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/I18nLocaleTexts)