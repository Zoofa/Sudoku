import java.util.Arrays;

public class SudokuSolver extends Sudoku{
    private int [][] board = new int[9][9];

    @Override
    public void createGrid() {
        System.out.println(Arrays.deepToString(board));
        System.out.println(solveBoard(board));
        printBoard(board);

    }

    @Override
    public int[][] getBoard() {
        return this.board;
    }

    @Override
    public void setBoard(int[][] board) {
        this.board = board;
    }
}
