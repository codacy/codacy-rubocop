##Handle Exceptions

Checks to see if a rescue block is empty since is pointless to have one if it is empty

```
#Dont do this

begin
  #some code
rescue

ensure
  #some more code
```