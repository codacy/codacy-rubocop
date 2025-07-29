
Check that code does not call `mixes_in_class_methods` from Sorbet `T::Helpers`.

Good:

```
module M
  extend ActiveSupport::Concern

  class_methods do
    ...
  end
end
```

Bad:

```
module M
  extend T::Helpers

  module ClassMethods
    ...
  end

  mixes_in_class_methods(ClassMethods)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidMixesInClassMethods)