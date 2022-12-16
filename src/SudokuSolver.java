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
        solveBoard();
        printBoard();

    }

    private void printBoard() {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }


    private boolean isNumberInRow(int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }
        return true;
    }


    private boolean isNumberInColumn(int number, int column) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][column] == number) {
                return false;
            }
        }
        return true;
    }



    private boolean isNumberInBox(int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidPlacement(int number, int row, int column) {
        return isNumberInRow(number, row) &&
                isNumberInColumn(number, column) &&
                isNumberInBox(number, row, column);
    }



    private boolean solveBoard() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(numberToTry, row, column)) {
                            board[row][column] = numberToTry;

                            if (solveBoard()) {
                                return true;
                            }
                            else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }









}
