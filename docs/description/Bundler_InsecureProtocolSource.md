
Passing symbol arguments to `source` (e.g. `source :rubygems`) is
deprecated because they default to using HTTP requests. Instead, specify
`'https://rubygems.org'` if possible, or `'http://rubygems.org'` if not.

When autocorrecting, this cop will replace symbol arguments with
`'https://rubygems.org'`.

This cop will not replace existing sources that use `http://`. This may
be necessary where HTTPS is not available. For example, where using an
internal gem server via an intranet, or where HTTPS is prohibited.
However, you should strongly prefer `https://` where possible, as it is
more secure.

If you don't allow `http://`, please set `false` to `AllowHttpProtocol`.
This option is `true` by default for safe autocorrection.

# Examples

```ruby
# bad
source :gemcutter
source :rubygems
source :rubyforge

# good
source 'https://rubygems.org' # strongly recommended
# good
source 'http://rubygems.org' # use only if HTTPS is unavailable
# bad
source 'http://rubygems.org'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Bundler/InsecureProtocolSource)