##Block Alignment

Checks whether the end keywords are aligned properly for do end blocks

```
#don't do this
variable = lambda  do |i|
i
	end
				
#do this instead
variable = lambda do |i|
i
end 
```