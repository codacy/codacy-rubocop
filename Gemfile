source 'https://rubygems.org'

git_source(:github) do |repo_name|
  repo_name = "#{repo_name}/#{repo_name}" unless repo_name.include?("/")
  "https://github.com/#{repo_name}.git"
end

gem "yard"
gem "rake"
gem "activesupport"
gem "parser", "2.6.3.0"
gem "pry"
gem "safe_yaml"
gem "dark_finger"
gem "rubocop-migrations", "0.1.2"
gem "rubocop-github", "0.13.0"
gem "rubocop-rspec", "1.33.0"
gem "rubocop", File.read('.rubocop-version').strip
#Rubocop official modules
gem "rubocop-performance", "1.3.0"
