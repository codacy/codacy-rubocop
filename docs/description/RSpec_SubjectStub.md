
Checks for stubbed test subjects.

Checks nested subject stubs for innermost subject definition
when subject is also defined in parent example groups.

# Examples

```ruby
# bad
describe Article do
  subject(:article) { Article.new }

  it 'indicates that the author is unknown' do
    allow(article).to receive(:author).and_return(nil)
    expect(article.description).to include('by an unknown author')
  end
end

# bad
describe Article do
  subject(:foo) { Article.new }

  context 'nested subject' do
    subject(:article) { Article.new }

    it 'indicates that the author is unknown' do
      allow(article).to receive(:author).and_return(nil)
      expect(article.description).to include('by an unknown author')
    end
  end
end

# good
describe Article do
  subject(:article) { Article.new(author: nil) }

  it 'indicates that the author is unknown' do
    expect(article.description).to include('by an unknown author')
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/SubjectStub)