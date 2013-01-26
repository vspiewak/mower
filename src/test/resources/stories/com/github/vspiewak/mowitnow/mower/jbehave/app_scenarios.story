Narrative:

This is a JBehave story containing 2 scenarios.
The first scenario is the same as in the specifications.
As a reminder, it's equivalent to the input file:

5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA

And the output:
1 3 N	
5 1 E	


Scenario: Specification scenario
 
Given a lawn with a top right corner at 5 5
When a mower starting at 1 2 N
And a list of commands GAGAGAGAA
And a mower starting at 3 3 E
And a list of commands AADAADADDA
Then the program should print 
1 3 N
5 1 E


Scenario: Another scenario (using aliases)
 
Given a lawn 10 10
When a mower 3 3 N
And doing GAADDDAAAGG
And a mower 3 3 N
And doing DDAAGG
And a mower 3 3 N
And doing AADDAAADDAADDAADD
And a mower 7 2 N
And doing A
Then it should print
1 0 N
3 1 N
3 2 N
7 3 N