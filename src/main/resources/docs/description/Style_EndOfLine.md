Line feed and carriage return are two different ways of how your computer sees the Enter key.

While for example the character M is interpreted the same way in Windows and in UNIX, the ENTER key is interpreted differently. This causes problems when transferring files and data from one platform to another one.

When transferring files from one platform to another, you can experience that ENTERs are not translated in a way thay you would expect.

Please consider removing all carriage return from your project.

[SOURCE](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EndOfLine)