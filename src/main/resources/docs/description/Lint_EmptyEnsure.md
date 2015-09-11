##Empty Ensure Block

Checks for empty ensure blocks since it it pointless to have one inside your code


```
begin
 #something that might raise an exception
rescue
 #code that deals with that exception
ensure
 #If you have this empty you can remove it


#You should have:
begin
  #something that might raise an exception

rescue
  #code that deals with that exception

ensure
  #ensure that this code always runs, no matter what

```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EmptyEnsure)
