##Require Parentheses

Checks for expressions where there is a call to a predicate method with at least one argument, where no parentheses are used around parameter list, and a boolean operator, && or ||, is used in the last argument.

**Example:**

 ```
  #dont do like this
  if day.is? :tuesday && month == :jan

  end

  #do it like this instead
  if day.is?(:tuesday) && month == :jan

  end
 ```