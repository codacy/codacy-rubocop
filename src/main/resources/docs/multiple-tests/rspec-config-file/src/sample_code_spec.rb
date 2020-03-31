describe MyClass do
    let(:calculator) { Factorial.new }
    let(:foobar) { blahblah }
    let(:baz) { bar }
    let(:a) { b }
    it "finds the factorial of 5" do
      expect(calculator.factorial_of(5)).to eq(120)
    end
end

## next lines should trigger a performance issue
## if rubocop-performance was required
## (on config file or command line param --require)
caller[1]
caller.first
caller_locations[1]
caller_locations.first
