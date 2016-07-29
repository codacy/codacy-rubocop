##Patterns: Rails_Delegate

##Warn: Rails_Delegate
def foo
  bar.foo
end

delegate :foo, to: :bar
