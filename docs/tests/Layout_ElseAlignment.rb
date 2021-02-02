##Patterns: Layout_ElseAlignment


# Pick a random number.
rno = rand(100) + 1
print "Your magic number is ", rno, "
"

# Perform all sort of totally uselss test on it and report the results.
if rno % 2 == 1 then
    print "Ooooh, that's an odd number.
"
  ##Info: Layout_ElseAlignment
  else
    print "That's an even number.
"
    if rno > 2 then
        print "It's not prime, BTW.
"
    end
end

# Perform all sort of totally uselss test on it and report the results.
if rno % 2 == 1 then
    print "Ooooh, that's an odd number.
"
else
    print "That's an even number.
"
    if rno > 2 then
        print "It's not prime, BTW.
"
    end
end
