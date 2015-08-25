##Patterns: Lint_DuplicateMethods

class SomeClass
  def some_method
  end

  ##Err: Lint_DuplicateMethods
  def some_method
  end
end

class SomeNewMethod
  def some
  end

  def some_method
  end
end