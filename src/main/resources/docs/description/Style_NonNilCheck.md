
This cop checks for non-nil checks, which are usually redundant.

Non-nil checks are allowed if they are the final nodes of predicate.

  # good
  def signed_in?
    !current_user.nil?
  end

# Examples

```ruby

# bad
if x != nil
end

# good (when not allowing semantic changes)
# bad (when allowing semantic changes)
if !x.nil?
end

# good (when allowing semantic changes)
if x
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NonNilCheck)