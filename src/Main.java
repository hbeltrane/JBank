import ui.MainFrame;
import ui.SearchPanel;

public class Main {

    public static void main(String[] args) {
        /* This code creates a Java Frame */
        MainFrame mainFrame = new MainFrame();  // Instantiate a MainFrame (JFrame) object
        SearchPanel searchPanel = new SearchPanel();
        mainFrame.add(searchPanel);
        mainFrame.setVisible(true);
    }
}