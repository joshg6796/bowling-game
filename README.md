# Bowling Game

Bowling game simulation used to track the score of a single game of bowling. The game will process the result of each ball bowled and calculate the correct score, including spares and strikes. The game will also validate the input that the user enters.

## How to Compile and Run Bowling Game Code
1. Clone the git repository

2. After cloning the repository, open the command line and go to
    ```
    ~/git/bowling-game/src
    ```
3. Run the command
    ```
    javac *.java
    ```
    followed by the command
    ```
    java Main
    ```

## Input
After compiling and running the main class successfully, the command line should prompt for an input. Entering **valid** input will process the bowling move and update the score. Each bowling move should be entered one at a time.

## Output
After inputting a bowling move, a table will be displayed in the command line with the scoreboard. The scoreboard is in markup table format so you can directly copy and paste it into a markup editor and visualize the scoreboard as a table.

### Sample Output

Enter ball rolls here: 5
| Frame | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 
|---|---|---|---|---|---|---|---|---|---|---|
| Input | 5 | __ | __ | __ | __ | __ | __ | __ | __ | __ | 
| Score | __ | __ | __ | __ | __ | __ | __ | __ | __ | __ | 

Enter ball rolls here: spare

| Frame | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 
|---|---|---|---|---|---|---|---|---|---|---|
| Input | 5 / | __ | __ | __ | __ | __ | __ | __ | __ | __ | 
| Score | __ | __ | __ | __ | __ | __ | __ | __ | __ | __ | 

Enter ball rolls here: strike
| Frame | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 
|---|---|---|---|---|---|---|---|---|---|---|
| Input | 5 / | X | __ | __ | __ | __ | __ | __ | __ | __ | 
| Score | 20 | __ | __ | __ | __ | __ | __ | __ | __ | __ | 

Enter ball rolls here: 3
| Frame | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 
|---|---|---|---|---|---|---|---|---|---|---|
| Input | 5 / | X | 3 | __ | __ | __ | __ | __ | __ | __ | 
| Score | 20 | __ | __ | __ | __ | __ | __ | __ | __ | __ | 

Enter ball rolls here: miss
| Frame | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 
|---|---|---|---|---|---|---|---|---|---|---|
| Input | 5 / | X | 3 - | __ | __ | __ | __ | __ | __ | __ | 
| Score | 20 | 33 | 36 | __ | __ | __ | __ | __ | __ | __ | 

## Architecture
Implemented bowling game using Java MVC Architecture.
