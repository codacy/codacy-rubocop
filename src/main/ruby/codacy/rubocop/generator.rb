# frozen_string_literal: true

require 'yaml'
require 'json'

module RubocopDoc
  module Codacy
    module Markdown
      def self.generate_markdown_file(file_name, content)
        File.write("src/main/resources/docs/description/#{file_name}.md", content)
      end

      def self.file_name(cop_data)
        cop_data[:name].gsub("/", "_")
      end

      def self.content(cop_data)
        "\n#{cop_data[:description]}\n\n# Examples\n\n#{cop_data[:examples_description]}\n[Source](#{info_url(cop_data)})"
      end

      def self.info_url(cop_data)
        "http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/#{cop_data[:name]}"
      end

      def self.run(file_path = "rubocop-doc.yml")
        cops_data = YAML.load_file(file_path)
        cops_data.each do |cop_data|
          generate_markdown_file(
            file_name(cop_data),
            content(cop_data)
          )
        end
      end
    end

    module DescriptionJSON
      def self.generate_json_file(hash)
        File.write("src/main/resources/docs/description/description.json", JSON.pretty_generate(hash))
      end

      def self.run(file_path = "rubocop-doc.yml")
        cops_data = YAML.load_file(file_path)
        descriptions = cops_data.map do |cop_data|
          {
            patternId: cop_data[:name].gsub("/", "_"),
            title: cop_data[:description],
            description: cop_data[:description],
            timeToFix: 5
          }
        end
        generate_json_file(descriptions)
      end

    end

    module PattersJSON
      def self.generate_json_file(hash)
        File.write("src/main/resources/docs/patterns.json", JSON.pretty_generate(hash))
      end

      def self.level(cop_data)
        if ["Metrics", "Lint", "Performance", "Rails"].include?(cop_data[:department_name])
          "Warning"
        else
          "Info"
        end
      end

      def self.category(cop_data)
        "CodeStyle"
      end

      def self.run(file_path = "rubocop-doc.yml")
        cops_data = YAML.load_file(file_path)
        patterns = cops_data.map do |cop_data|
          {
            patternId: cop_data[:name].gsub("/", "_"),
            level: level(cop_data),
            category: category(cop_data),
            parameters: cop_data[:configurable_attributes]
          }
        end
        data = {
          name: "Rubocop",
          version: "0.51.0",
          patterns: patterns
        }
        generate_json_file(data)
      end
    end
  end
end
RubocopDoc::Codacy::Markdown.run
RubocopDoc::Codacy::PattersJSON.run
RubocopDoc::Codacy::DescriptionJSON.run
