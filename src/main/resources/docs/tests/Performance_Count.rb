##Patterns: Performance_Count

##Warn: Performance_Count
[1, 2, 3].select { |e| e > 2 }.size

[1, 2, 3].count { |e| e > 2 }
