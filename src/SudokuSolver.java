public class SudokuSolver extends Sudoku{
    private final int GRID_SIZE = 9;
    private int [][] board = {
            {0, 0, 3, 5, 6, 7, 8, 0, 0},
            {0, 2, 0, 8, 0, 0, 0, 9, 0},
            {5, 0, 0, 3, 0, 0, 0, 7, 0},
            {0, 4, 0, 0, 2, 0, 3, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 6, 0},
            {0, 1, 0, 0, 0, 8, 2, 0, 0},
            {2, 0, 4, 0, 0, 1, 0, 0, 9},
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 4, 7, 0, 0, 0, 0}
    };

    @Override
    public void createGrid() {
        solveBoard(board);
        printBoard(board);

    }

}
