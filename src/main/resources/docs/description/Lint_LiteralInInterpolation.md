##Literal in Interpolation

Checks if there is some interpolation with a literal inside it it is pointless since a literal is a fixed value

**Example:**

```
#Dont do this
"result is #{10}"

#Do this instead since it is a fixed number
"result is 10"
```