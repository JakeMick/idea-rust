idea-rust [![Build Status](https://travis-ci.org/Vektah/idea-rust.svg)](https://travis-ci.org/Vektah/idea-rust)
=========

Language support for the Rust Language

PLEASE NOTE: This does not yet do any auto completion.
It is JUST the lexer and highlighting for .rs files.

The rest is coming soon!

Plugin page
===========
http://plugins.jetbrains.com/plugin/7438

Development
========

### Prerequisites
If you want to live on the bleeding edge (or help out!) you will need:

 - Intellij 13.1.5
 - Gradle

### Building
 * Add a gradle.properties file to the root directory of the project, with the following properties
    * libraries_intellij : the root directory of your intelliJ installation
    * rust_source : the root directory of the rust project (required to run tests)
    
    For example
    ```
    libraries_intellij=C:\\dev\\bin\\intellij-13.1.5\\
    rust_source=C:\\dev\\projects\\rust\\src\\
    ```
 * Run ```gradle grammar``` to generate the grammar and lexer. **NOTE**: If you are using Intellij 14.1, use the 
 latest release of GrammarKit located [here](https://github.com/JetBrains/Grammar-Kit/releases).
 * Run ```gradle runIdea``` or ```gradle debugIdea``` to start the plugin.
   Please note that ```$JAVA_HOME``` has to be set and point to a valid jdk otherwise idea will be unable to find tools.jar.
 
### Contributing
We use the following IntelliJ plugins to develop this plugin:
 - Plugin Devkit
 - Grammar-Kit
 - JFlex Support
 - Gradle plugin
 
