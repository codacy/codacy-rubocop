##Patterns: Lint_UselessAccessModifier
##Issue: {"severity": "Warn", "line": 5, "patternId": "Lint_UselessAccessModifier"}

class Foo
  private

  def self.some_method
  end
end