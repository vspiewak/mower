# Mower 

[![Build Status](https://api.travis-ci.org/vspiewak/mower.png?branch=master)](http://travis-ci.org/vspiewak/mover)

This is a mower implementation conform to the specifications provided. 
It support collision detection (ambiguous requirement).
I chose an engine-based architecture instead of Subject(Mower)/Observer(Lawn) pattern.


Dependencies
------------
* JDK 1.6
* Maven 3
* SLF4J + LogBack
* TestNG
* FestAsserts
* JBehave


Compile & Run
-------------

    mvn clean package
    cd target
    java -jar mower-<version>.jar src/test/resources/commands.txt

Note: the package lifecycle build a shaded jar with all dependencies.


Integration tests
-----------------

    mvn clean verify

You can view JBehave reports at:
* target/jbehave/view/index.html
* target/jbehave/view/reports.html

Feel free to add you own scenarios in the file [app_scenarios.story](src/test/resources/stories/com/github/vspiewak/mowitnow/mower/jbehave/app_scenarios.story)


Javadoc & Sources
------------------
A mower-<version>-sources.jar and mower-<version>-javadoc.jar are generated at package lifecycle.
You can use them with your favorite IDE. 


Continuous Integration
----------------------
Continuous integration provided by [Travis-CI.org](https://travis-ci.org)


Sonar Statistics
----------------
* 1242 lines 
* 98,7 rules compliances (3 violations)
* 80,2 units tests coverages
* 100% tests success
