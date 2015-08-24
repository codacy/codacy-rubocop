##Patterns: Lint_DuplicateMethods
##Issue: {"severity": "Err", "line": 8, "patternId": "Lint_DuplicateMethods"}

class SomeClass
  def some_method
  end

  def some_method
  end
end

class SomeNewMethod
  def some
  end

  def some_method
  end
end