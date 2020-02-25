#!/usr/bin/env ruby

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
        cops_data    = YAML.load_file(file_path)
        descriptions = cops_data.map do |cop_data|
          {
            patternId:   cop_data[:name].gsub("/", "_"),
            title:       cop_data[:configuration]['Description'],
            description: cop_data[:configuration]['Description'],
            timeToFix:   5
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
        if ["Security"].include?(cop_data[:department_name])
          "Error"
        elsif ["Lint", "Performance", "Rails"].include?(cop_data[:department_name])
          "Warning"
        elsif cop_data[:department_name].start_with?("Metrics") &&
          !cop_data[:department_name].include?("Length") &&
          !cop_data[:department_name].include?("AbcSize")
          "Warning"
        else
          "Info"
        end
      end

      def self.category(cop_data)
        if ["Lint"].include?(cop_data[:department_name])
          "ErrorProne"
        elsif cop_data[:department_name].start_with?("Metrics") &&
          !cop_data[:department_name].include?("Length") &&
          !cop_data[:department_name].include?("AbcSize")
          "ErrorProne"
        elsif ["Rails"].include?(cop_data[:department_name])
          "ErrorProne"
        elsif ["Performance"].include?(cop_data[:department_name])
          "Performance"
        elsif ["Security"].include?(cop_data[:department_name])
          "Security"
        else
          "CodeStyle"
        end
      end

      def self.subcategory(cop_data)
        if category(cop_data) == "Security"
          case cop_data[:name] 
          when "Security/JSONLoad", "Security/MarshalLoad"
            "InsecureModulesLibraries"
          when "Security/Open"
            "CommandInjection"
          when "Security/YAMLLoad", "Security/Eval"
            "InputValidation"
          else nil
          end
        end
      end

      def self.parameters(cop_data)
        cop_data[:configurable_attributes].map do |key, value|
          { name: key, default: value }
        end
      end

      def self.run(file_path = "rubocop-doc.yml")
        cops_data = YAML.load_file(file_path)
        patterns  = cops_data.map do |cop_data|
          {
            patternId:  cop_data[:name].gsub("/", "_"),
            level:      level(cop_data),
            category:   category(cop_data),
            subcategory: subcategory(cop_data),
            parameters: parameters(cop_data)
          }.delete_if { |key, value| value == nil }
        end
        data      = {
          name:     "Rubocop",
          version:  File.read(".rubocop-version").strip,
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
