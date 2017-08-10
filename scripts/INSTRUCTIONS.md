# Scripts


## Update patterns and description files

1. Merge "enable", "disable" and "default" yml files in one unique file. (Files can be found at [Rubocop](http://batsov.com/rubocop/) repository in config folder)

2. Change "Path-of-the-merged-file" string [here](patterns-description-generator.scala) to the path of previously merged file.

3. Copy the content of [this file](patterns-description-generator.scala) and run it on sbt console.

4. Still in sbt console call: ```updatePatternsAndDescription```. 

5. Indent the output and paste it in [patterns](../src/main/resources/docs/patterns.json) and [description](../src/main/resources/docs/description/description.json) files.