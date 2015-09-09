Aligning the end keyword greatly improves the code readbility.

Two modes are supported through the AlignWith configuration parameter. If it's set to keyword (which is the default), the end shall be aligned with the start of the keyword (if, class, etc.). If it's set to variable the end shall be aligned with the left-hand-side of the variable assignment, if there is one.

Ex:

    variable = if true
               end


[SOURCE](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EndAlignment)