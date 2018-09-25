source 'https://rubygems.org'

git_source(:github) do |repo_name|
  repo_name = "#{repo_name}/#{repo_name}" unless repo_name.include?("/")
  "https://github.com/#{repo_name}.git"
end

gem "yard"
gem "rake"
gem "activesupport"
gem "parser", "2.5.1.2"
gem "pry"
gem "rubocop", File.read('.rubocop-version')
gem "rubocop-migrations", "0.1.2"
gem "rubocop-rspec", "1.29.1"
gem "rubocop-github", "0.10.0"
gem "safe_yaml"