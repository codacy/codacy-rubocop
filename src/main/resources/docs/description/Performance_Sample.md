##Performance Sample

Choose using ```sample``` over ```shuffle.first, shuffle.last, shuffle[]``` since the performance is better


**Example:**

```
#bad
[1, 2, 3].shuffle.first

#good
[1, 2, 3].sample
```