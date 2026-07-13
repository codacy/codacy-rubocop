
Checks that source files have no utf-8 encoding comments.
Since Ruby 2.0, UTF-8 is the default source encoding, so
these comments are no longer necessary and just add noise.

# Examples

```ruby
# bad
# encoding: UTF-8
# coding: UTF-8
# -*- coding: UTF-8 -*-

# good
# No encoding comment needed
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Encoding)