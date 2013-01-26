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
    java -jar mower-0.0.1-SNAPSHOT.jar src/test/resources/commands.txt


## Integration tests

    mvn clean verify


You can view JBehave reports at:
* target/jbehave/view/index.html
* target/jbehave/view/reports.html
