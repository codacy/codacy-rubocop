##Time over Date

You should choose Time over Date since Date does not know anything about the Rails time zone.

**Examples:**

```
#good
Time.zone.today

#really bad options
Date.today
date.to_time
```