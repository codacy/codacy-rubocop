##Patterns: Metrics_BlockNesting

def hello
  while x < 10
    while j < 11
      while y < 12
        ##Warn: Metrics_BlockNesting
        while hello < 13

        end
      end
    end
  end
end
