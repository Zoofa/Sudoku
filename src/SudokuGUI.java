import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

    private ArrayList<JButton> clickedButton = new ArrayList<>();

    private HashMap<Integer, Sudoku> sudokuHashMap = new HashMap<>();

    private int[][] board;


    public SudokuGUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillNumber(1);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillNumber(2);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillNumber(3);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillNumber(4);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillNumber(5);
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillNumber(6);
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillNumber(7);
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillNumber(8);
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillNumber(9);
            }
        });
    }

    public void run() {
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setTitle("Bereken product");
        frame.pack();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sudoku sudokuPuzzle = new SudokuPuzzleMaker();
        Sudoku sudokuSolver = new SudokuSolver();
        Sudoku sudoku = new Sudoku();
        sudokuHashMap.put(1, sudokuPuzzle);
        sudokuHashMap.put(2, sudokuSolver);
        sudokuHashMap.put(3, sudoku);
        addNumbers();
        frame.setVisible(true);
    }



    private void addNumbers(){
        gridPanel.setLayout(new GridLayout(9,9));
        final Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
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
                } else{
                    b = new JButton(String.valueOf(board[row][column]));
                }
                b.setName(String.valueOf(row + "" + column));
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(Objects.equals(b.getText(), "")){
                            System.out.println("hi");
                            if(clickedButton.size() != 0){
                                clickedButton.get(0).setBackground(Color.WHITE);
                                clickedButton.remove(0);
                            }
                            clickedButton.add(b);
                            b.setBackground(Color.CYAN);
                        } else{
                            if(clickedButton.size() != 0){
                                clickedButton.get(0).setBackground(Color.WHITE);
                                clickedButton.remove(0);
                            }
                        }
                    }
                });
                b.setBackground(Color.WHITE);
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
            System.out.println(cell);
            System.out.println(row);
            System.out.println(col);
            if(sudokuHashMap.get(3).isValidPlacement(number,row, col, board)){
                board[row][col] = number;
                clickedButton.get(0).setText(String.valueOf(number));
                clickedButton.get(0).setBackground(Color.WHITE);
                clickedButton.remove(0);

            }
        }

    }




}
