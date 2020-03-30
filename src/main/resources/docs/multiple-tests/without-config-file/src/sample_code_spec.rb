# Should not throw any exception
# configurations must be passed by codacy param

describe MyClass do
    let(:calculator) { Factorial.new }
    let(:foobar) { blahblah }
    let(:baz) { bar }
    let(:a) { b }
    it "finds the factorial of 5" do
      expect(calculator.factorial_of(5)).to eq(120)
    end
end

caller[1]
caller.first
caller_locations[1]
caller_locations.first
