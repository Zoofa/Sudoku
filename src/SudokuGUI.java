import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.border.Border;
import java.util.Objects;


public class SudokuGUI {
    private JPanel panel1;
    private JPanel gridPanel;
    private JButton button1;
    private JButton button4;
    private JButton button7;
    private JButton button2;
    private JButton button3;
    private JButton button5;
    private JButton button6;
    private JButton button8;
    private JButton button9;
    private JButton newGameButton;
    private JButton beginnerButton;
    private JButton amateurButton;
    private JButton noviceButton;
    private JButton expertButton;
    private JButton normalButton;
    private JButton pencilButton;

    private ArrayList<JButton> clickedButton = new ArrayList<>();

    private HashMap<Integer, Sudoku> sudokuHashMap = new HashMap<>();

    private int[][] board;

    private final Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
    private int emptyCells;

    private ArrayList<JButton> levelButton = new ArrayList<>();

    private ArrayList<Integer> pencil = new ArrayList<>();


    public SudokuGUI() {

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
        noviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(levelButton.size() != 0){
                    levelButton.get(0).setBackground(Color.GRAY);
                    levelButton.remove(0);
                } else{
                    amateurButton.setBackground(Color.GRAY);
                }
                sudokuHashMap.get(1).AMOUNTTOBEREMOVED = 40;
                noviceButton.setBackground(Color.RED);
                levelButton.add(noviceButton);

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
    }

    public void run() {
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setTitle("Bereken product");
        frame.pack();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sudoku sudokuPuzzle = new SudokuPuzzleMaker();
        Sudoku sudokuSolver = new SudokuSolver();
        Sudoku sudoku = new Sudoku();
        sudokuHashMap.put(1, sudokuPuzzle);
        sudokuHashMap.put(2, sudokuSolver);
        sudokuHashMap.put(3, sudoku);
        beginnerButton.setBackground(Color.GRAY);
        amateurButton.setBackground(Color.RED);
        noviceButton.setBackground(Color.GRAY);
        expertButton.setBackground(Color.GRAY);
        normalButton.setBackground(Color.RED);
        addNumbers();
        gridPanel.setBorder(fieldBorder);
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
                }
                b.setName(row + "" + column);
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
                }
                gridPanel.add(b);
            }
        }
    }


    public void fillNumber(int number){
        if(clickedButton.size() != 0){
            String cell = clickedButton.get(0).getName();
            int row = Character.getNumericValue(cell.charAt(0));
            int col = Character.getNumericValue(cell.charAt(1));
            Sudoku test = new Sudoku();
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
                clickedButton.remove(0);
            }
            if(emptyCells == 0){
                endGameState();
            }
        }

    }

    public void endGameState(){
        gridPanel.removeAll();
        sudokuHashMap.get(1).setBoard(new int[9][9]);
        addNumbers();
        gridPanel.validate();
        gridPanel.repaint();
    }

    public void buttonClick(int Bnumber){
        if(pencil.size() == 0){
            fillNumber(Bnumber);
        } else {
            if (clickedButton.size() != 0) {
                String buttonText = clickedButton.get(0).getText();
                if (buttonText.equals("")) {
                    clickedButton.get(0).setText(Bnumber + " ");
                } else {
                    String[] numbers = buttonText.split(" ");
                    numbers = numbers[0].split("");
                    boolean alreadyPlaced = false;
                    for (String number : numbers) {
                        if (Objects.equals(number, Integer.toString(Bnumber))) {
                            alreadyPlaced = true;
                            StringBuilder sb = new StringBuilder(buttonText);
                            sb.deleteCharAt(buttonText.length() - 1);
                            buttonText = sb.toString();
                            if (numbers.length == 1) {
                                clickedButton.get(0).setText("");
                            }
                        }
                    }
                    if (!alreadyPlaced) {
                        StringBuilder sb = new StringBuilder(buttonText);
                        sb.deleteCharAt(buttonText.length() - 1);
                        buttonText = sb.toString();
                        clickedButton.get(0).setText(buttonText + Bnumber + " ");
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
