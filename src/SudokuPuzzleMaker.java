import java.util.*;

public class SudokuPuzzleMaker extends Sudoku{

    private int[][] board = new int[9][9];

    private ArrayList<Integer> positions = new ArrayList<>();

    @Override
    public void createGrid() {
        createGridPositions();
        createFirstRow();
        solveBoard(board);
        printBoard(board);
        System.out.println();
        createBoard();
        printBoard(board);
    }

    private void createFirstRow(){
        Random random = new Random();
        ArrayList<Integer> rowNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for (int column = 0; column < GRID_SIZE; column++) {
            int randomElement = rowNumbers.get(random.nextInt(rowNumbers.size()));
            rowNumbers.remove((Integer) randomElement);
            if(isValidPlacement(randomElement, 0, column, board)){
                board[0][column] = randomElement;
            }
        }
    }

    private void createBoard(){
        for (int i = 0; i < AMOUNTTOBEREMOVED; i++) {
            Random random = new Random();
            int randRow = random.nextInt(9);
            int randCol = random.nextInt(9);
            while(board[randRow][randCol] == 0){
                randRow = random.nextInt(9);
                randCol = random.nextInt(9);
            }
            board[randRow][randCol] = 0;
        }
    }



//    private void createBoard(){
//        int randRow;
//        int randCol;
//        int cellValue;
//        int[][] testBoard = new int[9][9];
//        Collections.shuffle(positions);
//        for (int gridPosition : positions){
//            for(int j=0; j<board.length; j++)
//                for(int k=0; k<board[j].length; k++)
//                    testBoard[j][k]=board[j][k];
//            randCol = gridPosition % 10;
//            randRow = gridPosition / 10;
//            cellValue = testBoard[randRow][randCol];
//            testBoard[randRow][randCol] = 0;
//            System.out.println();
//            printBoard(testBoard);
//            if(!solveUniqness(testBoard, randRow, randCol,cellValue)){
//                board[randRow][randCol] = 0;
//            } else{
//                System.out.println("h");
//            }
//        }
//
//    }


    public void createGridPositions(){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                positions.add(i*10+j);
            }
        }
    }




    public boolean solveUniqness(int[][] board, int randRow, int randCol, int cellValue) {
        boolean testValue = true;
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if(testValue && (numberToTry == cellValue) && (randRow == row) && (randCol == column)){
                            testValue = false;
                        } else{
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
                    }
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public int[][] getBoard() {
        return board;
    }

    @Override
    public void setBoard(int[][] board) {
        this.board = board;
    }
}
