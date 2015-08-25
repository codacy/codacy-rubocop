##Hash Alignment

You should align the elements of the hash spanning multiple lines

**Example:**

```
#bad
menu_item = { spam => foo, bar => foo, something => hello, hey => hi,
pizza => italy, more => less }

#good
menu_item = {
     spam => foo, bar => foo, something => hello, hey => hi,
     pizza => italy, more => less
}

#also good
menu_item =
{ spam => foo, bar => foo, something => hello, hey => hi,
     pizza => italy, more => less }
```