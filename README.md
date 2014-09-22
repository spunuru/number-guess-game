Introduction to number-guess-game
================================

It is a simple number guessing game. It is developed to meet following objective.

Objective:
Write a program in Java to play a number-guessing game. The game works as follows:
The user chooses a number in his mind and types “ready” to indicate to the computer that he is ready to begin playing.
The computer asks a series of questions to arrive at the number the user has in mind. The user can only respond with “higher”, “lower” or “yes”.
The game ends when the user responds with “yes” or “end”.
 
Example:
1. User chooses number 40 in his mind.
2. Computer: Is the number 30?
3. User: higher
4. Computer: Is the number 50?
5. User: lower
6. Computer: Is the number 35?
7. User: higher
8. Computer: Is the number 40?
9. User: yes

 
Please note:
1. The program should be written to arrive at the answer asking the least number of questions.
2. Assume that your program will be used in the real world, so make it robust, and make any reasonable assumptions about the other conditions of the game.
3. Provide working source code; there should be a class with a main method that we can run to play the game. If necessary, provide a build script written in Ant, Maven or Gradle.
4. Working unit tests would be a bonus.
5. You can include any explanatory notes with your program

Prerequisites
---------------
1. JDK 1.6 or higher needs to be installed
2. Maven 3 needs to be installed.

Steps to build and run
-----------------------
1. git clone https://github.com/spunuru/number-guess-game.git
2. cd number-guess-game
3. mvn clean install
4. java -jar target/number-guess-game-0.0.1-SNAPSHOT.jar          (This sets the game range from 1..100)
5. java -jar target/number-guess-game-0.0.1-SNAPSHOT.jar 1000   (This sets the game range from 1..1000)

To Do
-------
1. Unit test cases
