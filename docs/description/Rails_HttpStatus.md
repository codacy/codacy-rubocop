
Enforces use of symbolic or numeric value to define HTTP status.

# Examples

```ruby
# bad
render :foo, status: 200
render :foo, status: '200'
render json: { foo: 'bar' }, status: 200
render plain: 'foo/bar', status: 304
redirect_to root_url, status: 301
head 200

# good
render :foo, status: :ok
render json: { foo: 'bar' }, status: :ok
render plain: 'foo/bar', status: :not_modified
redirect_to root_url, status: :moved_permanently
head :ok# bad
render :foo, status: :ok
render json: { foo: 'bar' }, status: :not_found
render plain: 'foo/bar', status: :not_modified
redirect_to root_url, status: :moved_permanently
head :ok

# good
render :foo, status: 200
render json: { foo: 'bar' }, status: 404
render plain: 'foo/bar', status: 304
redirect_to root_url, status: 301
head 200
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/HttpStatus)