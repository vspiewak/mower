# Mower 

This is a mower implementation, conform to the specifications provided. 
I chose an engine-based architecture instead of events/exceptions.
It support collision detection.


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


Sonar Statistics
-----------------
* 1238 lines 
* 97,9 rules compliances
* 80,2 units tests coverages
* 100% tests success