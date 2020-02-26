source 'https://rubygems.org'

git_source(:github) do |repo_name|
  repo_name = "#{repo_name}/#{repo_name}" unless repo_name.include?("/")
  "https://github.com/#{repo_name}.git"
end

gem "yard"
gem "rake"
gem "activesupport"
gem "parser", "2.7.0.2"
gem "pry"
gem "safe_yaml"
gem "dark_finger"
gem "rubocop-migrations", "0.1.2"
gem "rubocop-github", "0.14.0"
gem "rubocop", File.read('.rubocop-version').strip
#Rubocop official modules
gem "rubocop-performance", "1.5.2"
gem "rubocop-rails", "2.4.2"
gem "rubocop-rspec", "1.38.1"
