
Identifies redundant spec type.

After setting up rspec-rails, you will have enabled
`config.infer_spec_type_from_file_location!` by default in
spec/rails_helper.rb. This cop works in conjunction with this config.
If you disable this config, disable this cop as well.

# Examples

```ruby
# bad
# spec/models/user_spec.rb
RSpec.describe User, type: :model do
end

# good
# spec/models/user_spec.rb
RSpec.describe User do
end

# good
# spec/models/user_spec.rb
RSpec.describe User, type: :common do
end# .rubocop.yml
# RSpecRails/InferredSpecType:
#   Inferences:
#     services: service

# bad
# spec/services/user_spec.rb
RSpec.describe User, type: :service do
end

# good
# spec/services/user_spec.rb
RSpec.describe User do
end

# good
# spec/services/user_spec.rb
RSpec.describe User, type: :common do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpecRails/InferredSpecType)