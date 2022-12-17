import java.util.*;

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

    ArrayList<String> cells = new ArrayList<>();

    private void createCellList(){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                cells.add(String.valueOf(i) + String.valueOf(j));
            }
        }


    }


    @Override
    public void createGrid() {
        createFirstRow();
        printBoard(board);
        System.out.println();
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
        for (int i = 0; i < 40; i++) {
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








}
