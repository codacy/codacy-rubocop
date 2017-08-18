# Scripts


## Update patterns and description files

1. Merge "enable.yml", "disable.yml" and "default.yml" files in one unique file in rubocop-config-base-files. The name should match the version that we are using.
  * Files can be found at [Rubocop](http://batsov.com/rubocop/) repository in config folder.
  Don't copy from master, copy from the tag that matches the version we are using.
    * Ex: For version 0.49.0 the files should be retrieved from https://github.com/bbatsov/rubocop/tree/v0.49.0/config
  
  * Ex: For version 0.49.0 the merged file should be located at rubocop-config-base-files/0.49.0.yml

2. Run ```sbt console``` on this project root (not inside any folder!) and copy the content of [this file](patterns-description-generator.scala).

3. Still in sbt console call (with the Rubocop version number): ```updatePatternsAndDescription("0.49.0")```. 

4. Indent the output and paste it in [patterns](../src/main/resources/docs/patterns.json) and [description](../src/main/resources/docs/description/description.json) files.