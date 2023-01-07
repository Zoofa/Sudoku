import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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
    private JButton switchUserButton;
    private JButton deleteHighscoreButton;
    private ArrayList<JButton> clickedButton = new ArrayList<>();

    private ArrayList<JButton> clickedButtonSolver = new ArrayList<>();

    private HashMap<Integer, Sudoku> sudokuHashMap = new HashMap<>();

    private int[][] board;
    private int[][] emptyBoard = new int[9][9];

    private boolean newGame = false;

    private String name = "";

    private boolean solved = false;

    private Instant start;
    private Instant end;

    boolean switchUser = false;

    private ArrayList<Difficulty> difficulty = new ArrayList<>();

    private final Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
    private final Border emptyBoarder = BorderFactory.createLineBorder(Color.GRAY, 1);
    private int emptyCells;

    private int points;

    private int removePoints;

    private PlayersCSV players;

    private ArrayList<JButton> levelButton = new ArrayList<>();

    private ArrayList<Integer> pencil = new ArrayList<>();

    private ArrayList<Integer> usedNumbers = new ArrayList<>();

    private ArrayList<JButton> buttons = new ArrayList<>();

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
                newGame = true;
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
                sudokuHashMap.get(1).AMOUNTTOBEREMOVED = difficulty.get(0).getRemoving();
                sudokuHashMap.get(1).points = difficulty.get(0).getPoints();
                sudokuHashMap.get(1).removePoints = difficulty.get(0).getRemovePoints();
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
                sudokuHashMap.get(1).AMOUNTTOBEREMOVED = difficulty.get(1).getRemoving();
                sudokuHashMap.get(1).points = difficulty.get(1).getPoints();
                sudokuHashMap.get(1).removePoints = difficulty.get(1).getRemovePoints();
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
                sudokuHashMap.get(1).AMOUNTTOBEREMOVED = difficulty.get(2).getRemoving();
                sudokuHashMap.get(1).points = difficulty.get(2).getPoints();
                sudokuHashMap.get(1).removePoints = difficulty.get(2).getRemovePoints();
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
                sudokuHashMap.get(1).AMOUNTTOBEREMOVED = difficulty.get(3).getRemoving();
                sudokuHashMap.get(1).points = difficulty.get(3).getPoints();
                sudokuHashMap.get(1).removePoints = difficulty.get(3).getRemovePoints();
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
        switchUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reply = JOptionPane.showConfirmDialog(null, "Choosing a new user will reset the grid without saving. Are you sure?", "change user", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    switchUser = true;
                    endGameState();
                }
            }
        });
        deleteHighscoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players.putIntoHashmap();
                players.deletePlayer(name);
            }
        });
    }




    public void run() {

        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setTitle("Sudoku");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sudoku sudokuPuzzle = new SudokuPuzzleMaker();
        Sudoku sudokuSolver = new SudokuSolver();
        Sudoku sudoku = new Sudoku();
        Difficulty beginner = new Beginner();
        Difficulty amateur = new Amateur();
        Difficulty Intermdiate = new Intermediate();
        Difficulty Expert = new Expert();
        players = new PlayersCSV();
        difficulty.add(beginner);
        difficulty.add(amateur);
        difficulty.add(Intermdiate);
        difficulty.add(Expert);
        sudokuHashMap.put(1, sudokuPuzzle);
        sudokuHashMap.put(2, sudokuSolver);
        sudokuHashMap.put(3, sudoku);
        sudokuHashMap.get(1).AMOUNTTOBEREMOVED = difficulty.get(1).getRemoving();
        sudokuHashMap.get(1).points = difficulty.get(1).getPoints();
        sudokuHashMap.get(1).removePoints = difficulty.get(1).getRemovePoints();
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
        while(name == null || name.equals("")){
            try{
                name = JOptionPane.showInputDialog("Wat is uw naam?");
            } catch (NullPointerException ignored) {
            }
        }
        name = name.toLowerCase();
        createButtonList();
        fillUsedNumbers();
        System.out.println(usedNumbers);
        addNumbers();
        removeUsedNumber();
        numberComplete();
        System.out.println(usedNumbers);
        System.out.println(usedNumbers.size());
        createEmptyGrid();
        gridPanel.setBorder(fieldBorder);
        sudokuEmptyGrid.setBorder(fieldBorder);
        frame.setVisible(true);
    }

    private void addNumbers(){
        emptyCells = sudokuHashMap.get(1).AMOUNTTOBEREMOVED;
        points = sudokuHashMap.get(1).points;
        removePoints = sudokuHashMap.get(1).removePoints;
        System.out.println(emptyCells);
        System.out.println(points);
        System.out.println(removePoints);
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
        start = Instant.now();
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
                removeNumberList(number);
                numberComplete();
                System.out.println();
                sudokuHashMap.get(1).printBoard(board);
                emptyCells--;
                clickedButton.get(0).setText(String.valueOf(number));
                clickedButton.get(0).setBackground(Color.WHITE);
                clickedButton.get(0).setFont(new Font("Arial", Font.BOLD, 16));
                clickedButton.remove(0);
            }else{
                points -= removePoints;
                System.out.println(points);
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
        System.out.println(newGame);
        if(!switchUser && !newGame){
            System.out.println("zel");
            end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            timeElapsed = Duration.between(start, end);
            points = (int) (points - timeElapsed.getSeconds());
            System.out.println(points);
            players.putIntoHashmap();
            players.searchPlayer(name, String.valueOf(points));
            players.writeToFile();
            JOptionPane.showMessageDialog(null,"Your high score is: " + players.oldScore(name) + "\nThis game score is: " + points);
            newGame = false;
        } else if(switchUser){
            name = "";
            while(name == null || name.equals("")){
                try{
                    name = JOptionPane.showInputDialog("Wat is uw naam?");
                } catch (NullPointerException ignored) {
                }
            }
            name = name.toLowerCase();
            switchUser = false;
        }
        gridPanel.removeAll();
        sudokuHashMap.get(1).setBoard(new int[9][9]);
        setButtonsTrue();
        fillUsedNumbers();
        addNumbers();
        removeUsedNumber();
        numberComplete();
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



    public void fillUsedNumbers(){
        usedNumbers.clear();
        for (int i = 1; i < 82; i++) {
            if (i < 10){
                usedNumbers.add(1);
            } else if (i < 19) {
                usedNumbers.add(2);
            } else if (i < 28) {
                usedNumbers.add(3);
            } else if (i< 37) {
                usedNumbers.add(4);
            } else if (i<46) {
                usedNumbers.add(5);
            } else if (i<55) {
                usedNumbers.add(6);
            } else if (i<64) {
                usedNumbers.add(7);
            } else if (i<73) {
                usedNumbers.add(8);
            } else {
                usedNumbers.add(9);
            }
        }
    }

    public void removeUsedNumber(){
        Iterator it;
        boolean found;
        for (int i = 0; i < sudokuHashMap.get(1).GRID_SIZE; i++) {
            for (int j = 0; j < sudokuHashMap.get(1).GRID_SIZE; j++) {
                int number = board[i][j];
                it = usedNumbers.iterator();
                found = false;
                while (it.hasNext() && !found){
                    int usedNumber = (int) it.next();
                    if(number == usedNumber){
                        it.remove();
                        found = true;
                    }
                }
            }
        }
    }

    public void removeNumberList(int number){
        Iterator it = usedNumbers.iterator();
        boolean found = false;
        while (it.hasNext() && !found){
            int usedNumber = (int) it.next();
            if(number == usedNumber){
                it.remove();
                found = true;
            }
        }
    }

    public void createButtonList(){
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
    }

    public void setButtonsTrue(){
        for (JButton b : buttons){
            b.setEnabled(true);
        }
    }

    public void numberComplete(){
        for (JButton b : buttons){
            b.setEnabled(false);
        }
        List<Integer> newList = usedNumbers.stream().distinct().toList();
        for (int number : newList){
            buttons.get(number - 1).setEnabled(true);
        }
    }






}
