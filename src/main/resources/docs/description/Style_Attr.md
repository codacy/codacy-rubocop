##Attr_reader over Attr

Choose the usage of attr_reader over attr since attr creates a single attribute accessor and it was
deprecated in 1.9

**Examples:**

```
#bad
attr :something, true
attr :one, :two, :three

#good
attr_accessor :something
attr_reader :one, :two, :three
```