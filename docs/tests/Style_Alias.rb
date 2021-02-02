##Patterns: Style_Alias

##Info: Style_Alias
other.class_eval { alias :full_name :given_name }

other.class_eval { alias_method :full_name, :given_name }
