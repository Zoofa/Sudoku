public class Sudoku {

    public final int GRID_SIZE = 9;

    public final int AMOUNTTOBEREMOVED = 70;

    public void createGrid(){}

    public void printBoard(int[][] board) {
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

    private boolean isNumberInRow(int number, int row, int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }
        return true;
    }



    private boolean isNumberInColumn(int number, int column, int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][column] == number) {
                return false;
            }
        }
        return true;
    }


    private boolean isNumberInBox(int number, int row, int column, int[][] board) {
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


    public boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(numberToTry, row, column, board)) {
                            board[row][column] = numberToTry;

                            if (solveBoard(board)) {
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

    public boolean isValidPlacement(int number, int row, int column, int[][] board) {
        return isNumberInRow(number, row, board) &&
                isNumberInColumn(number, column, board) &&
                isNumberInBox(number, row, column, board);
    }






}
