
basename = File.expand_path("/tmp/myproj")
  filename = File.expand_path(File.join(basename, @file.public_filename))
  raise if basename != filename
  send_file filename, disposition: 'inline'

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GitlabSecurity/SendFileParams)