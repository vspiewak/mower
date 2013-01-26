# Mower 

TODO: write documentation

## Dependencies
* SLF4J + LogBack
* JUnit
* TestNG
* FestAsserts
* JBehave

## Compile & Run

    mvn clean package
    cd target
    java -jar mower-<version>.jar src/test/resources/commands.txt


## Integration tests

    mvn clean verify


You can view JBehave reports at:
* target/jbehave/view/index.html
* target/jbehave/view/reports.html


## Javadocs & Sources
A mower-<version>-sources.jar and mower-<version>-javadoc.jar are generated at package lifecycle.
You can use them with your favorite IDE. 
