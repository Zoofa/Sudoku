import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SudokuPuzzleMaker extends Sudoku{

    private int[][] board = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private  final int GRID_SIZE = 9;


    @Override
    public void createGrid() {
        createFirstRow();
        printBoard();
        System.out.println();
        solveBoard();
        printBoard();
    }

    private void createFirstRow(){
        Random random = new Random();
        ArrayList<Integer> rowNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for (int column = 0; column < GRID_SIZE; column++) {
            int randomElement = rowNumbers.get(random.nextInt(rowNumbers.size()));
            System.out.println(randomElement);
            rowNumbers.remove((Integer) randomElement);
            if(isValidPlacement(randomElement, 0, column)){
                board[0][column] = randomElement;
            }
        }
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
