
Checks for absolute XPath searches on Capybara elements.

An XPath starting with `//` searches from the document root, even when
the query is called on an element. Use `.//` to stay within it.
Direct RSpec `let` and named `subject` element definitions are
recognized.

# Examples

```ruby
# bad
page.find('.dialog').find(:xpath, '//button')
dialog = page.find('.dialog')
dialog.find(:xpath, '//button')
RSpec.describe 'dialog' do
  let(:dialog) { find('.dialog') }
  it { dialog.find(:xpath, '//button') }
end

# good
page.find('.dialog').find(:xpath, './/button')
page.find(:xpath, '//button')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/AbsoluteXPathInElementScope)