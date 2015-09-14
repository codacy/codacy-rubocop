 Use the new lambda literal syntax for single line body blocks. Use the lambda method for multi-line blocks.

 **Example:**

 ```
# bad
l = lambda { |a, b| a + b }
l.call(1, 2)

# correct, but looks extremely awkward
l = ->(a, b) do
  tmp = a * 7
  tmp * b / 50
end

# good
l = ->(a, b) { a + b }
l.call(1, 2)

l = lambda do |a, b|
  tmp = a * 7
  tmp * b / 50
end
 ```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Lambda)