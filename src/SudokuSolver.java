public class SudokuSolver extends Sudoku{
    private int [][] board;

    @Override
    public void createGrid() {
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
