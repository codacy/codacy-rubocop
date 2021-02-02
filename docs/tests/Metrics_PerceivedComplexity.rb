##Patterns: Metrics_PerceivedComplexity

##Warn: Metrics_PerceivedComplexity
def my_method
  if cond
      case var
      when 1 then func_one
      when 2 then func_two
      when 3 then func_three
      when 4..10 then func_other
      end
  else
    do_other until a && c
    do_something until a && b
  end
end
