##Performance Size

Choose ```size``` over ```count``` since size comes from the same implementation as length and they run on constant time which is alot better

***Example:***

```
#bad
[1, 2, 3].count

#good
[1, 2, 3].size
```