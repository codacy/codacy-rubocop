This is a serious security issues since if it is enabled to the user to modify it it can be used for SQL injection and other types of security flaws.

For example, if you are evaling a string submitted by the user eval can allow arbitrary code execution. Imagine what would happen if the string containes an OS call to ```rm -rf /```.

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/Eval)