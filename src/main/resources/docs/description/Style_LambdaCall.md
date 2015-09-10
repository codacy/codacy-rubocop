This patterns enforces a consistent use of the lambda.(args) syntax.

Ex:

    # bad
    lambda.(x, y)
    
    # good
    lambda.call(x, y)

[SOURCE](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/LambdaCall)