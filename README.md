Mower
=====

[![Build Status](https://api.travis-ci.org/vspiewak/mower.png?branch=master)](http://travis-ci.org/vspiewak/mover)

Summary
-------
This is a my mower implementation (I hope it will not scratch too much your eyes :).   
I chose an Engine-based architecture after considering Subject(Mower) / Observer(Lawn) pattern.

Assuming two mowers can't be at the same position (ambiguous requirement),
the mower don't move if a collision with another mower is detected.


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

Note: the `package` lifecycle build a shaded (i.e standalone) jar with all dependencies.


Integration tests
-----------------

    mvn clean verify

You can view JBehave reports at:
* target/jbehave/view/index.html
* target/jbehave/view/reports.html

Feel free to write your own scenarios in the file [app_scenarios.story](https://github.com/vspiewak/mower/blob/master/src/test/resources/stories/com/github/vspiewak/mowitnow/mower/jbehave/app_scenarios.story)


Javadoc & Sources JAR
---------------------
A `mower-<version>-sources.jar` and `mower-<version>-javadoc.jar` are generated at `package` lifecycle.    
You can use them with your favorite IDE. 


Continuous Integration
----------------------
Continuous integration provided by [Travis CI](https://travis-ci.org)


Latest Sonar Statistics
-----------------------
* 675 lines
* 99,1 rules compliances (2 violations)
* 84,3 units tests coverages
* 0% duplications / pti
* 100% tests success
