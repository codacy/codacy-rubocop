When calculating the length of an Enumerable there are several ways you can do it
but some are better than others because of how fast they are, ```length``` is as fast as
it gets since it's complexity is approximately O(1) but it only works on concrete
classes (like Array and String).

Invoking size is the same as invoking length It comes down to a matter of personal preference
if you like the word better.

Count, however is very slow compared to the other two so avoid using it if you can use size or length


**Examples:**

```
# bad
[1, 2, 3].select { |e| e > 2 }.size
[1, 2, 3].reject { |e| e > 2 }.size
[1, 2, 3].select { |e| e > 2 }.length
[1, 2, 3].reject { |e| e > 2 }.length
[1, 2, 3].select { |e| e > 2 }.count { |e| e.odd? }
[1, 2, 3].reject { |e| e > 2 }.count { |e| e.even? }
array.select(&:value).count

# good
[1, 2, 3].count { |e| e > 2 }
[1, 2, 3].count { |e| e < 2 }
[1, 2, 3].count { |e| e > 2 && e.odd? }
[1, 2, 3].count { |e| e < 2 && e.even? }
Model.select('field AS field_one').count
Model.select(:value).count
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/Count)