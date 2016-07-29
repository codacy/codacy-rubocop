##Patterns: Lint_UselessAccessModifier

class Foo
  ##Warn: Lint_UselessAccessModifier
  private

  def self.some_method
  end
end
