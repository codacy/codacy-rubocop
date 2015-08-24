##String Conversion In Interpolation

Checks for string conversion in interpolation, which is redundant

```
#this is redundant
"result is #{something.to_s}"

#change it to this
"result is #{something}"
```