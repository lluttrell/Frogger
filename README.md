# Frogger
To compile game: 
javac -cp . frogger/Main.java

To run:
java frogger/Main

Game instructions:
WASD for moving.
X to restart.
Try to get to the opposite side of the screen.
Avoid asteroids.
Traverse the void of space by jumping on ships.

For Tests: have junit and hamcrest jars in working directory.
To Compile: 
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar test/*.java

To run:
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore test.[TESTNAME]

if on Linux replace semi-colons with colons.