
Checks that every method definition and attribute accessor has a Sorbet signature.

It also suggest an autocorrect with placeholders so the following code:

```
def foo(a, b, c); end
```

Will be corrected as:

```
sig { params(a: T.untyped, b: T.untyped, c: T.untyped).returns(T.untyped)
def foo(a, b, c); end
```

You can configure the placeholders used by changing the following options:

* `ParameterTypePlaceholder`: placeholders used for parameter types (default: 'T.untyped')
* `ReturnTypePlaceholder`: placeholders used for return types (default: 'T.untyped')
* `Style`: signature style to enforce - 'sig' for sig blocks, 'rbs' for RBS comments, 'both' to allow either (default: 'sig')

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/EnforceSignatures)