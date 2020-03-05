#!/usr/bin/env ruby

# frozen_string_literal: true

require 'yaml'
require 'json'

module RubocopDoc
  module Codacy
    module Markdown
      @baseDir
      def self.generate_markdown_file(file_name, content)
        markdownFilePath = File.join(@baseDir,"/docs/description/#{file_name}.md")
        File.write(markdownFilePath , content)
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

      def self.run(baseDir = "src/main/resources", file_path = "rubocop-doc.yml")
        @baseDir = baseDir
        cops_data = YAML.load_file(file_path)
        cops_data.each do |cop_data|
          generate_markdown_file(
            file_name(cop_data),
            content(cop_data)
          )
        end
      end
    end

    module GenerationCommons
      def self.withoutNilValues(obj)
        obj.delete_if { |_, value| value.nil? }
      end

      def self.parametersFieldValue(parameters)
        if parameters.length() > 0
          parameters
        end
      end
    end

    module DescriptionJSON
      @baseDir
      def self.generate_json_file(hash)
        descriptionFilePath = File.join(@baseDir,"/docs/description/description.json")
        File.write(descriptionFilePath, JSON.pretty_generate(hash))
      end

      def self.get_title(description)
        while description.length() > 254 && description.split(".").length() > 0 do
          description = description.split(".")[0..-2].join(".") + "."
        end
        description
      end

      def self.parameters(cop_data)
        cop_data[:configurable_attributes].map do |key, _|
          { name: key, description: key }
        end
      end

      def self.run(baseDir = "src/main/resources", file_path = "rubocop-doc.yml")
        @baseDir = baseDir
        cops_data    = YAML.load_file(file_path)
        descriptions = cops_data.map do |cop_data|
          GenerationCommons.withoutNilValues({
            patternId:   cop_data[:name].gsub("/", "_"),
            title:       get_title(cop_data[:configuration]['Description']),
            description: cop_data[:configuration]['Description'],
            timeToFix:   5,
            parameters:  GenerationCommons.parametersFieldValue(parameters(cop_data))
          })
        end
        generate_json_file(descriptions)
      end

    end

    module PattersJSON
      @baseDir
      def self.generate_json_file(hash)
        patternsFilePath = File.join(@baseDir,"/docs/patterns.json")
        File.write(patternsFilePath, JSON.pretty_generate(hash))
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
          when "Security/JSONLoad", "Security/MarshalLoad", "Security/YAMLLoad"
            "InsecureModulesLibraries"
          when "Security/Open"
            "CommandInjection"
          when "Security/Eval"
            "InputValidation"
          end
        end
      end

      def self.parameters(cop_data)
        cop_data[:configurable_attributes].map do |key, value|
          { name: key, default: value }
        end
      end

      def self.run(baseDir = "src/main/resources", file_path = "rubocop-doc.yml")
        @baseDir=baseDir
        cops_data = YAML.load_file(file_path)
        patterns  = cops_data.map do |cop_data|
          GenerationCommons.withoutNilValues({
            patternId:  cop_data[:name].gsub("/", "_"),
            level:      level(cop_data),
            category:   category(cop_data),
            subcategory: subcategory(cop_data),
            parameters: GenerationCommons.parametersFieldValue(parameters(cop_data))
          })
        end
        data      = {
          name:     "Rubocop",
          version:  Gem.loaded_specs["rubocop"].version,
          patterns: patterns
        }
        generate_json_file(data)
      end
    end
  end
end

baseDir="src/main/resources"
if ARGV.length == 1 
  baseDir=ARGV[0]
end

RubocopDoc::Codacy::Markdown.run(baseDir)
RubocopDoc::Codacy::PattersJSON.run(baseDir)
RubocopDoc::Codacy::DescriptionJSON.run(baseDir)
