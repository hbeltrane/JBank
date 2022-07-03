package ui;

import db.AgentEntity;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;


public class SearchPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel testLabel;
    JButton testButton;
    public SearchPanel() {
        super(); // Initializes a JPanel class instance
        this.setBackgroundColor(); // Change the panel background color
        testLabel = new JLabel("Click to search a random customer");
        this.add(testLabel, null);
        setRandomSearchButton();
        this.add(testButton, null);
    }

    /* Creates a new Java color and applies it to the panel background*/
    private void setBackgroundColor() {
        Color lightCyan = new Color(224, 240, 255);  // Creates a color based on an RGB code
        this.setBackground(lightCyan);
    }

    private void setRandomSearchButton() {
        testButton = new JButton("Search");
        testButton.setFocusable(false);
        testButton.addActionListener(event -> {
            /* Basic Database Connection using Connection Manager Class */

        });
    }
}
