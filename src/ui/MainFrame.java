package ui;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    JPanel searchPanel;
    public MainFrame() {
        super("JBank"); // Initialize parent and sets title to the window
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends program when exit the window
    }

    private JPanel getSearchPanel() {
        return null;
    }
}
