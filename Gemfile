source 'https://rubygems.org'

git_source(:github) do |repo_name|
  repo_name = "#{repo_name}/#{repo_name}" unless repo_name.include?("/")
  "https://github.com/#{repo_name}.git"
end

gem "yard"
gem "rake"
gem "rdoc"
gem "activesupport"
gem "parser"
gem "pry"
gem "safe_yaml"
gem "dark_finger"
gem "rubocop-migrations"
gem "rubocop", "1.29.1"
#Needed to be referenced on some user configs
gem "graphql"
#Rubocop official modules
gem "rubocop-performance"
gem "rubocop-rails"
gem "rubocop-rake"
gem "rubocop-rspec"
gem "rubocop-sorbet"
gem "rubocop-shopify"
gem "rubocop-graphql"
gem 'rubocop-thread_safety', require: false
