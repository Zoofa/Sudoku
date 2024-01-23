# Sudoku Solver and Game
Prerequisites:
---------------
* Oracle OpenJDK version 19.0.1
* IntelliJ Community (Not tested on other IDEs or text editors)

Running the Application
---------------
1. Open IntelliJ, navigate to the src directory, and run Main.java.

How the Application Works
---------------
Playing Sudoku:

1. Choose the difficulty level: Beginner, Amateur, Intermediate, or Expert.
2. Click on the desired difficulty level, then click "New Game."
3. The selected difficulty will be highlighted in red.
4. Yellow squares indicate positions to be filled.
5. Click on a square to make it active (turns blue).
6. Fill in a number using the buttons on the right. Use the pencil to add notes.
7. Correctly filled squares turn white and become uneditable.
8. Incorrect numbers result in point deduction but no other changes.
9. You can switch users at any time, but the grid will not be saved.
10. Highscores are saved to a CSV file in the "files" folder.
11. Delete your highscore whenever desired.

Sudoku Solver:

1. Fill in known values in the sudoku grid.
2. Click "Solve" to let the solver complete the puzzle.
3. The solver checks for basic sudoku rules violations.
4. If a rule is violated, the solver prevents the placement of numbers.

#### Feel free to explore and enjoy solving and playing Sudoku with this application!
