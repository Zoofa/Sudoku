package GUI;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class MainWithTextFields {
    private static void createAndShowGUI() {
        final Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK);

        final JPanel grid = new JPanel(new GridLayout(9, 0));
        for (int i = 0; i < 81; ++i) {
            final JTextField field = new JTextField(2);
            field.setHorizontalAlignment(JTextField.CENTER); //Center text horizontally in the text field.
            if(i % 3 == 0){
                field.setBorder(fieldBorder);
            }
            grid.add(field);
        }

        final JPanel centeredGrid = new JPanel(new GridBagLayout());
        centeredGrid.add(grid);

        final JFrame frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(centeredGrid);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(MainWithTextFields::createAndShowGUI);
    }
}
