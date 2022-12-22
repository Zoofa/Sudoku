import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class SudokuGUITest {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton button1;
    private JButton button4;
    private JButton button7;
    private JButton button2;
    private JButton button5;
    private JButton button8;
    private JButton button3;
    private JButton button6;
    private JButton button9;
    private JButton newGameButton;
    private JButton beginnerButton;
    private JButton amateurButton;
    private JButton intermediateButton;
    private JButton expertButton;
    private JButton normalButton;
    private JButton pencilButton;
    private JPanel gridPanel;
    private JPanel sudokuGame;
    private JPanel sudokuSolver;
    private JButton a1Button;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton resetButton;
    private JPanel sudokuEmptyGrid;
    private JButton solveButton;
    private ArrayList<JButton> clickedButton = new ArrayList<>();

    private ArrayList<JButton> clickedButtonSolver = new ArrayList<>();

    private HashMap<Integer, Sudoku> sudokuHashMap = new HashMap<>();

    private int[][] board;
    private int[][] emptyBoard = new int[9][9];

    private boolean solved = false;

    private final Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
    private final Border emptyBoarder = BorderFactory.createLineBorder(Color.GRAY, 1);
    private int emptyCells;

    private ArrayList<JButton> levelButton = new ArrayList<>();

    private ArrayList<Integer> pencil = new ArrayList<>();

    public SudokuGUITest() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClick(1);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClick(2);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClick(3);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClick(4);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClick(5);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClick(6);
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClick(7);
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClick(8);
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClick(9);
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGameState();
            }
        });
        beginnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(levelButton.size() != 0){
                    levelButton.get(0).setBackground(Color.GRAY);
                    levelButton.remove(0);
                } else{
                    amateurButton.setBackground(Color.GRAY);
                }
                sudokuHashMap.get(1).AMOUNTTOBEREMOVED = 20;
                beginnerButton.setBackground(Color.RED);
                levelButton.add(beginnerButton);

            }
        });
        amateurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(levelButton.size() != 0){
                    levelButton.get(0).setBackground(Color.GRAY);
                    levelButton.remove(0);
                }
                sudokuHashMap.get(1).AMOUNTTOBEREMOVED = 30;
                amateurButton.setBackground(Color.RED);
                levelButton.add(amateurButton);


            }
        });
        intermediateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(levelButton.size() != 0){
                    levelButton.get(0).setBackground(Color.GRAY);
                    levelButton.remove(0);
                } else{
                    amateurButton.setBackground(Color.GRAY);
                }
                sudokuHashMap.get(1).AMOUNTTOBEREMOVED = 40;
                intermediateButton.setBackground(Color.RED);
                levelButton.add(intermediateButton);

            }
        });
        expertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(levelButton.size() != 0){
                    levelButton.get(0).setBackground(Color.GRAY);
                    levelButton.remove(0);
                } else{
                    amateurButton.setBackground(Color.GRAY);
                }
                sudokuHashMap.get(1).AMOUNTTOBEREMOVED = 50;
                expertButton.setBackground(Color.RED);
                levelButton.add(expertButton);

            }
        });
        normalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pencil.size() != 0){
                    pencil.remove(0);
                    pencilButton.setBackground(Color.GRAY);
                    normalButton.setBackground(Color.RED);
                }
            }
        });
        pencilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pencil.add(1);
                pencilButton.setBackground(Color.RED);
                normalButton.setBackground(Color.GRAY);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGrid();
            }
        });
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveBoard();
            }
        });

        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                emptyBoardClick(1);
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyBoardClick(2);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyBoardClick(3);
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyBoardClick(4);
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyBoardClick(5);
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyBoardClick(6);
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyBoardClick(7);
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyBoardClick(8);
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyBoardClick(9);
            }
        });
    }




    public void run() {
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setTitle("Bereken product");
        frame.pack();
        //frame.setSize(1200, 1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sudoku sudokuPuzzle = new SudokuPuzzleMaker();
        Sudoku sudokuSolver = new SudokuSolver();
        Sudoku sudoku = new Sudoku();
        sudokuHashMap.put(1, sudokuPuzzle);
        sudokuHashMap.put(2, sudokuSolver);
        sudokuHashMap.put(3, sudoku);
        beginnerButton.setBackground(Color.GRAY);
        amateurButton.setBackground(Color.RED);
        intermediateButton.setBackground(Color.GRAY);
        expertButton.setBackground(Color.GRAY);
        normalButton.setBackground(Color.RED);
        pencilButton.setBackground(Color.GRAY);
        button1.setBackground(Color.GRAY);
        button2.setBackground(Color.GRAY);
        button3.setBackground(Color.GRAY);
        button4.setBackground(Color.GRAY);
        button5.setBackground(Color.GRAY);
        button6.setBackground(Color.GRAY);
        button7.setBackground(Color.GRAY);
        button8.setBackground(Color.GRAY);
        button9.setBackground(Color.GRAY);
        resetButton.setBackground(Color.GRAY);
        newGameButton.setBackground(Color.GRAY);
        solveButton.setBackground(Color.GRAY);
        a1Button.setBackground(Color.GRAY);
        a2Button.setBackground(Color.GRAY);
        a3Button.setBackground(Color.GRAY);
        a4Button.setBackground(Color.GRAY);
        a5Button.setBackground(Color.GRAY);
        a6Button.setBackground(Color.GRAY);
        a6Button.setBackground(Color.GRAY);
        a7Button.setBackground(Color.GRAY);
        a8Button.setBackground(Color.GRAY);
        a9Button.setBackground(Color.GRAY);
        addNumbers();
        createEmptyGrid();
        gridPanel.setBorder(fieldBorder);
        sudokuEmptyGrid.setBorder(fieldBorder);
        frame.setVisible(true);
    }

    private void addNumbers(){
        System.out.println(sudokuHashMap.get(1).AMOUNTTOBEREMOVED);
        emptyCells = sudokuHashMap.get(1).AMOUNTTOBEREMOVED;
        gridPanel.setLayout(new GridLayout(9,9));
        int localBoxRow;
        int localBoxColumn;
        sudokuHashMap.get(1).createGrid();
        board = sudokuHashMap.get(1).getBoard();
        for (int row = 0; row < sudokuHashMap.get(1).GRID_SIZE; row++) {
            for (int column = 0; column < sudokuHashMap.get(1).GRID_SIZE; column++) {
                localBoxRow = row - row % 3;
                localBoxColumn = column - column % 3;
                JButton b;
                if(String.valueOf(board[row][column]).equals("0")){
                    b = new JButton("");
                    b.setBackground(Color.YELLOW);
                } else{
                    b = new JButton(String.valueOf(board[row][column]));
                    b.setBackground(Color.WHITE);
                    b.setFont(new Font("Arial", Font.BOLD, 16));
                }
                b.setName(row + "" + column);
                //b.setSize(new Dimension(20, 20));
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String last = "";
                        if(!Objects.equals(b.getText(), "")){
                            last = String.valueOf(b.getText().charAt(b.getText().length() - 1));
                        }
                        if(Objects.equals(b.getText(), "") || last.equals(" ") ){
                            if(clickedButton.size() != 0){
                                clickedButton.get(0).setBackground(Color.YELLOW);
                                clickedButton.remove(0);
                            }
                            clickedButton.add(b);
                            b.setBackground(Color.CYAN);
                        }
                    }
                });
                if(localBoxRow == 0 && localBoxColumn == 0){
                    b.setBorder(fieldBorder);
                } else if (localBoxRow == 0 && localBoxColumn == 6) {
                    b.setBorder(fieldBorder);
                } else if (localBoxRow == 3 && localBoxColumn == 3) {
                    b.setBorder(fieldBorder);
                } else if (localBoxRow == 6 && localBoxColumn == 0) {
                    b.setBorder(fieldBorder);
                } else if (localBoxRow == 6 && localBoxColumn == 6) {
                    b.setBorder(fieldBorder);
                } else{
                    b.setBorder(emptyBoarder);
                }
                gridPanel.add(b);
            }
        }
    }


    public void createEmptyGrid(){
        sudokuEmptyGrid.setLayout(new GridLayout(9,9));
        int localBoxRow;
        int localBoxColumn;
        for (int row = 0; row < sudokuHashMap.get(1).GRID_SIZE; row++) {
            for (int column = 0; column < sudokuHashMap.get(1).GRID_SIZE; column++) {
                localBoxRow = row - row % 3;
                localBoxColumn = column - column % 3;
                JButton b;
                if(!solved){
                    b = new JButton("");
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(clickedButtonSolver.size() != 0){
                                clickedButtonSolver.get(0).setBackground(Color.WHITE);
                                clickedButtonSolver.remove(0);
                            }
                            clickedButtonSolver.add(b);
                            b.setBackground(Color.CYAN);
                        }
                    });
                } else{
                    System.out.println(emptyBoard[row][column]);
                    b = new JButton(String.valueOf(emptyBoard[row][column]));
                }
                b.setBackground(Color.WHITE);
                b.setFont(new Font("Arial", Font.BOLD, 16));
                b.setName(row + "" + column);
                if(localBoxRow == 0 && localBoxColumn == 0){
                    b.setBorder(fieldBorder);
                } else if (localBoxRow == 0 && localBoxColumn == 6) {
                    b.setBorder(fieldBorder);
                } else if (localBoxRow == 3 && localBoxColumn == 3) {
                    b.setBorder(fieldBorder);
                } else if (localBoxRow == 6 && localBoxColumn == 0) {
                    b.setBorder(fieldBorder);
                } else if (localBoxRow == 6 && localBoxColumn == 6) {
                    b.setBorder(fieldBorder);
                }
                sudokuEmptyGrid.add(b);
            }
        }
        System.out.println(Arrays.deepToString(emptyBoard));
    }



    public void fillNumber(int number){
        if(clickedButton.size() != 0){
            String cell = clickedButton.get(0).getName();
            int row = Character.getNumericValue(cell.charAt(0));
            int col = Character.getNumericValue(cell.charAt(1));
            int[][] testBoard = new int[9][9];
            for(int i=0; i<board.length; i++)
                for(int j=0; j<board[i].length; j++)
                    testBoard[i][j]=board[i][j];
            testBoard[row][col] = number;
            if(sudokuHashMap.get(3).isValidPlacement(number,row, col, board) && sudokuHashMap.get(3).solveBoard(testBoard)){
                board[row][col] = number;
                System.out.println();
                sudokuHashMap.get(1).printBoard(board);
                emptyCells--;
                clickedButton.get(0).setText(String.valueOf(number));
                clickedButton.get(0).setBackground(Color.WHITE);
                clickedButton.get(0).setFont(new Font("Arial", Font.BOLD, 16));
                clickedButton.remove(0);
            }
            if(emptyCells == 0){
                endGameState();
            }
        }

    }

    public void solveBoard(){
        sudokuHashMap.get(2).setBoard(emptyBoard);
        sudokuHashMap.get(2).createGrid();
        System.out.println(Arrays.deepToString(emptyBoard));
        solved = true;
        sudokuEmptyGrid.removeAll();
        createEmptyGrid();
        sudokuEmptyGrid.validate();
        sudokuEmptyGrid.repaint();
    }

    public void endGameState(){
        gridPanel.removeAll();
        sudokuHashMap.get(1).setBoard(new int[9][9]);
        addNumbers();
        gridPanel.validate();
        gridPanel.repaint();
    }

    public void resetGrid(){
        sudokuEmptyGrid.removeAll();
        emptyBoard = new int[9][9];
        solved = false;
        createEmptyGrid();
        sudokuEmptyGrid.validate();
        sudokuEmptyGrid.repaint();
    }

    public void emptyBoardClick(int number){
        //clickedButtonSolver.get(0).setText(number);
        String cell = clickedButtonSolver.get(0).getName();
        int row = Character.getNumericValue(cell.charAt(0));
        int col = Character.getNumericValue(cell.charAt(1));
        if(sudokuHashMap.get(2).isValidPlacement(number, row, col, emptyBoard)){
            emptyBoard[row][col] = number;
            clickedButtonSolver.get(0).setText(String.valueOf(number));
        }
    }


    public void buttonClick(int Bnumber){
        if(pencil.size() == 0){
            fillNumber(Bnumber);
        } else {
            if (clickedButton.size() != 0) {
                String buttonText = clickedButton.get(0).getText();
                if (buttonText.equals("")) {
                    clickedButton.get(0).setText(Bnumber + " ");
                    clickedButton.get(0).setFont(new Font("Arial", Font.BOLD, 10));
                } else {
                    String[] numbers = buttonText.split(" ");
                    numbers = numbers[0].split("");
                    boolean alreadyPlaced = false;
                    for (String number : numbers) {
                        if (Objects.equals(number, Integer.toString(Bnumber))) {
                            alreadyPlaced = true;
                            if (numbers.length == 1) {
                                clickedButton.get(0).setText("");
                            }
                        }
                    }
                    if (!alreadyPlaced) {
/*                        StringBuilder sb = new StringBuilder(buttonText);
                        sb.deleteCharAt(buttonText.length() - 1);
                        buttonText = sb.toString();*/
                        numbers = Arrays.copyOf(numbers, numbers.length + 1);
                        numbers[numbers.length - 1] = String.valueOf(Bnumber);
                        String text = "";
                        Arrays.sort(numbers);
                        for (String number : numbers) {
                            text += number;
                        }
                        clickedButton.get(0).setText(text + " ");
                    } else {
                        if (!Objects.equals(clickedButton.get(0).getText(), "")) {
                            String text = "";
                            for (String number : numbers) {
                                if (!Objects.equals(number, Integer.toString(Bnumber))) {
                                    text += number;
                                }
                            }
                            clickedButton.get(0).setText(text + " ");
                        }
                    }
                }
            }
        }


    }




}
