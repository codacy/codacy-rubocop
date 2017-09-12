# Scripts


## Update patterns and description files

1. Copy "enable.yml", "disable.yml" and "default.yml" to rubocop-config-base-files folder.
  * Files can be found at [Rubocop](http://batsov.com/rubocop/) repository in config folder.
  Don't copy from master, copy from the tag that matches the version we are using.
    * Ex: For version 0.49.0 the files should be retrieved from https://github.com/bbatsov/rubocop/tree/v0.49.0/config
  
2. Run ```sbt console``` on this project root (not inside any folder!) and copy the content of [this file](patterns-description-generator.scala).

3. Still in sbt console call (with the Rubocop version number): ```updatePatternsAndDescription("0.49.0")```. 

4. Indent the output and paste it in [patterns](../src/main/resources/docs/patterns.json) and [description](../src/main/resources/docs/description/description.json) files.