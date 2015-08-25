##Performance Detect Usage

```detect``` has much better performance than calling first or last on ```select.first, select.last, find_all.first, find_all.last```

**Example:**


```
# bad
[].select { |item| true }.first
[].select { |item| true }.last
[].find_all { |item| true }.first
[].find_all { |item| true }.last

# good
[].detect { |item| true }
[].reverse.detect { |item| true }
```


