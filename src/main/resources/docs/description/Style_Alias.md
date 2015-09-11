##Alias_method over Alias

You should always use **alias_method** when  aliasing methods of modules, classes, or singleton classes
at runtime, as the lexical scope of alias leads to unpredictabillity in these [cases](https://github.com/bbatsov/ruby-style-guide#alias-method).

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Alias)
