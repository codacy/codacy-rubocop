bundle install --path vendor/bundle
bundle exec src/main/ruby/rubocop_doc/generator.rb
bundle exec src/main/ruby/codacy/rubocop/generator.rb
rm -f rubocop-doc.yml
