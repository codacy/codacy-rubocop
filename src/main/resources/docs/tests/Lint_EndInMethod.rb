##Patterns: Lint_EndInMethod

def methoda
	a = 4
	if true
	##Warn: Lint_EndInMethod
	  END { # This END is executed
	  puts "if" # This code is registered
	  puts a # The variable is visible; prints "4"
	}
	else
	##Warn: Lint_EndInMethod
	  END { puts "else" } # This is not executed
	end
end

def methodb
	a = 4
	if true
	  at_exit { # This END is executed
	  puts "if" # This code is registered
	  puts a # The variable is visible; prints "4"
	}
	else
	  at_exit { puts "at_exit" } # This is not executed
	end
end
