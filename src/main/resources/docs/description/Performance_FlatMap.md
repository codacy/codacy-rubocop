##Increase Performance with FlatMap

To increase the performance of your code use **flat_map** instead of using **map.flatten**

**Example:**

```
#bad
[1, 2, 3, 4].map { |e| [e, e] }.flatten(1)

#good
[1, 2, 3, 4].flat_map { |e| [e, e] }
```