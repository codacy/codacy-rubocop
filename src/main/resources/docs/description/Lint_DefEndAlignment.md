Aligning the end keyword with the begining of the function definition improves the code readbility.

Two modes are supported through the AlignWith configuration parameter. If it's set to start_of_line (which is the default), the end shall be aligned with the start of the line where the def keyword is. If it's set to def, the end shall be aligned with the def keyword.


    private def foo
    end

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DefEndAlignment)