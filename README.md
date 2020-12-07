# Java-Console-Snake-Game
Build a snake game with variable game speed and board size to run within the terminal!

Author: Sebastian Morgan
Date: 12/6/2020

This repository has 2 files; 

The Snake.java file implements the game on a turn by turn basis, which waits for user
input on every new turn of the snake game.

The SnakeTimed.java file implements the game on a timer, recording the last given user
input, and constantly looking for new user input while printing out the Snake game.
The time between game updates can be changed, making the game effectively run faster,
or slower.

RULES:
- Use the "wasd" keys to move, and "q" to quit (lowercase characters)
- Compile both files before running
- If you direct the snake into its own body, you lose
- If you direct the snake into the game border, you lose
- Direct the snake into empty space, and eat the "O"s that appear to get bigger!

HOW TO CHANGE SOME ASPECTS OF THE GAME

Game Speed: Go into the SnakeTimed.java file, and go to where the variable "snek" is
instantiated in the main() method, then in the last field of that constructor is the
wait time of the game. This wait time can be set as low as 0 (unplayable), and records
the number of milliseconds that each turn explicitly has between updates.

Board Size: Go into the SnakeTimed.java file, and go to where the "snek" variable is
instantiated again, but this time, the first 2 inputs in the SnakeTimed class
constructor represent the dimensions of the board. The first value is the height,
and the second value is the width of the board.

CREDITS:
- Shout out to "theawesometrey" on stackoverflow for helping me get past a bottleneck
in the implimentation of the SnakeTimed.java file!
