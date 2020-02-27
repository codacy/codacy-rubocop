
This cop checks the indentation of the here document bodies. The bodies
are indented one step.
In Ruby 2.3 or newer, squiggly heredocs (`<<~`) should be used. If you
use the older rubies, you should introduce some library to your project
(e.g. ActiveSupport, Powerpack or Unindent).
Note: When `Layout/LineLength`'s `AllowHeredoc` is false (not default),
      this cop does not add any offenses for long here documents to
      avoid `Layout/LineLength`'s offenses.

# Examples

```ruby
# bad
<<-RUBY
something
RUBY

# good
# When EnforcedStyle is squiggly, bad code is auto-corrected to the
# following code.
<<~RUBY
  something
RUBY# good
# When EnforcedStyle is active_support, bad code is auto-corrected to
# the following code.
<<-RUBY.strip_heredoc
  something
RUBY# good
# When EnforcedStyle is powerpack, bad code is auto-corrected to
# the following code.
<<-RUBY.strip_indent
  something
RUBY# good
# When EnforcedStyle is unindent, bad code is auto-corrected to
# the following code.
<<-RUBY.unindent
  something
RUBY
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/HeredocIndentation)