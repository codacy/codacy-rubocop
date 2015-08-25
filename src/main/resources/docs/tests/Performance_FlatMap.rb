##Patterns: Performance_FlatMap

##Warn: Performance_FlatMap
[1, 2, 3, 4].map { |e| [e, e] }.flatten(1)

[1, 2, 3, 4].flat_map { |e| [e, e] }


