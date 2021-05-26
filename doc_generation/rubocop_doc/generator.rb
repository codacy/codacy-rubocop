#!/usr/bin/env ruby

# Plugins with patterns documentation should be added here
$plugins = ["rubocop-performance","rubocop-rails", "rubocop-sorbet", "rubocop-graphql"]

# frozen_string_literal: true
require 'rubocop'
require 'yaml'
require 'yard'
require 'pathname'

$plugins.map(&method(:require))

module RubocopDocs
  class CopDoc
    attr_accessor :cop, :yard_object, :name, :example, :description, :department_name, :config

    def initialize(cop, config)
      @cop    = cop
      @config = config.for_cop(cop)
      make_excludes_relative(@config, config.base_dir_for_path_parameters)
    end

    # Reverses what this method does: RuboCop::Config#make_excludes_absolute
    def make_excludes_relative(config, base_dir)
      config["Exclude"]&.map! do |exclude_elem|
        if exclude_elem.is_a?(String)
          exclude_path = Pathname.new(exclude_elem)
          base_dri = Pathname.new(base_dir)

          if base_dri.relative?() != exclude_path.relative?()
            exclude_elem
          else
            exclude_path.relative_path_from(base_dri).to_s
          end

        else
          exclude_elem
        end
      end
    end

    def name
      @name ||= @cop.cop_name
    end

    def department_name
      @department_name ||= @cop.department.to_s
    end

    def configuration
      display_keys = %w[Description Enabled StyleGuide Reference]
      config.select { |k| display_keys.include? k }
    end

    def configurable_attributes
      non_display_keys = %w[Description Enabled StyleGuide Reference VersionAdded VersionChanged]
      result           = config.reject { |k| non_display_keys.include? k }
      result.map { |key, value| [key, value.is_a?(Array) ? value : value.to_s] }.to_h
    end

    def yard_object
      return @yard_object if @yard_object
      result = nil

      YARD::Registry.all(:class).detect do |code_object|
        next unless RuboCop::Cop::Badge.for(code_object.to_s) == cop.badge
        result = code_object
      end
      @yard_object = result
    end

    def description
      return '' unless yard_object
      yard_object.docstring.to_s
    end

    def examples_description
      return '' unless yard_object
      return '' if yard_object.tags('example').empty?
      result = "```ruby\n".dup
      yard_object.tags('example').map do |x|
        result << x.text
      end
      result << "\n```\n"
      result
    end

    def as_json
      {
        name:                    name,
        department_name:         department_name,
        description:             description,
        examples_description:    examples_description,
        configuration:           configuration,
        configurable_attributes: configurable_attributes,
      }
    end
  end

  def self.rubocop_source_code_path(plugin_with_version)
    puts "Parsing cops to be available for documentation details for #{plugin_with_version}..."
    ruby_version = RbConfig::CONFIG['ruby_version']
    gem_path     = "vendor/bundle/ruby/#{ruby_version}/gems/#{plugin_with_version}"
    "#{gem_path}/lib/rubocop/cop/**/*.rb"
  end

  def self.run
    blacklist = ["Lint/RedundantCopDisableDirective", "Sorbet/SignatureCop", "GraphQL/OrderedArguments", "GraphQL/OrderedFields"]

    # Each plugin has a Version, so we retrieve that to know where to look on the gem files for the Cops documentation
    plugins_with_versions = $plugins.map do |plugin|
      version = Gem.loaded_specs[plugin].version.to_s
      "#{plugin}-#{version}"
    end

    # Add rubocop itself as a source of Cops
    plugins_with_versions << "rubocop-#{RuboCop::Version::STRING}"

    puts "Generating documentation based on Rubocop and plugins:"
    puts plugins_with_versions
    puts "^^^^ MAKE SURE THE PLUGIN YOU ADDED IS ON THE LIST ABOVE, OTHERWISE WILL NOT BE PART OF THE patterns.json"

    YARD::Rake::YardocTask.new(:yard_for_generate_documentation) do |task|
      task.files   = plugins_with_versions.map(&method(:rubocop_source_code_path))
      task.options = ['--no-output']
    end

    Rake.application['yard_for_generate_documentation'].invoke
    YARD::Registry.load!
    cops                       = RuboCop::Cop::Registry.global
    config                     = RuboCop::ConfigLoader.default_configuration
    result                     = []
    cops.each do |cop|
      next if blacklist.include? cop.cop_name
      result << RubocopDocs::CopDoc.new(cop, config)
    end
    result = result.map(&:as_json)
    File.write('rubocop-doc.yml', result.to_yaml)
  end
end

RubocopDocs.run
