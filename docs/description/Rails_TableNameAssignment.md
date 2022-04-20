
This cop enforces the absence of explicit table name assignment.

`self.table_name=` should only be used for very good reasons,
such as not having control over the database, or working
on a legacy project.

If you need to change how your model's name is translated to
a table name, you may want to look at Inflections:
https://api.rubyonrails.org/classes/ActiveSupport/Inflector/Inflections.html

If you wish to add a prefix in front of your model, or wish to change
the default prefix, `self.table_name_prefix` might better suit your needs:
https://api.rubyonrails.org/classes/ActiveRecord/ModelSchema.html#method-c-table_name_prefix-3D

STI base classes named `Base` are ignored by this cop.
For more information: https://api.rubyonrails.org/classes/ActiveRecord/Inheritance.html

# Examples

```ruby
# bad
self.table_name = 'some_table_name'
self.table_name = :some_other_name
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/TableNameAssignment)