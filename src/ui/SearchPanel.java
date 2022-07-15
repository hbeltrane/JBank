package ui;

import entity.*;

import javax.swing.*;
import java.awt.*;


public class SearchPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel agentIdLabel;
    JLabel searchLabel;
    JTextField searchTextField;
    JButton searchButton;
    JTable customerTable;
    JTable accountTable;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    Agent bankAgent;
    MainFrame mainFrame;
    public SearchPanel(MainFrame mainFrame) {
        super(); // Initializes a JPanel class instance
        this.mainFrame = mainFrame;
        this.bankAgent = mainFrame.bankAgent;
        this.setLayout(null);
        this.setBackground(LIGHT_CYAN); // Change the panel background color
        getAgentIdLabel();
        getSearchLabel();
        getSearchTextField();
        getSearchButton();
        getCustomerScrollPane();  // Gets the table inside a scrollable panel
        getAccountScrollPane();
    }

    /* Initialize the Search Panel components */
    private void getAgentIdLabel() {
        agentIdLabel = new JLabel(bankAgent.getFullName());
        agentIdLabel.setBounds(700,0,200,30);
        agentIdLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(agentIdLabel,null);
    }

    private void getSearchLabel() {
        searchLabel = new JLabel("Search");
        searchLabel.setBounds(300,50,50,30);
        searchLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(searchLabel,null);
    }

    private void getSearchTextField() {
        searchTextField = new JTextField();
        searchTextField.setBounds(400,50,250,30);
        this.add(searchTextField,null);
    }

    private void getSearchButton() {
        searchButton = new JButton("Find");
        searchButton.setBounds(700,50,200,30);
        this.add(searchButton, null);
        searchButton.setFocusable(false);
        // Search action for the button click event
        searchButton.addActionListener(event -> {
            /* Search customers or accounts */

        });
    }

    private void getCustomerTable() {
        String [] columnNames = {
                "Customer ID", "First Name", "Last Name", "Address", "Phone Number", "Email"
        };
        String[][] data = {
                {"1", "Nancy", "Sallings", "4291 Derek Road", "394-391-7522", "nsallings0@prnewswire.com"},
                {"2", "Lebbie", "Gimbrett", "315 Bunker Hill Alley", "647-399-3239", "lgimbrett1@huffingtonpost.com"},
                {"3", "Jake", "Fitzmaurice", "108 Artisan Alley", "417-371-5483", "jfitzmaurice2@virginia.edu"},
                {"4", "Lil", "Weld", "45 Basil Crossing", "954-551-8848", "lweld3@buzzfeed.com"},
                {"5", "Anita", "Phittiplace", "8 Dapin Street", "540-128-2637", "aphittiplace4@latimes.com"}
        };
        customerTable = new JTable(data,columnNames);
        customerTable.setPreferredScrollableViewportSize(new Dimension(500,100));
        customerTable.setFillsViewportHeight(true);
    }

    private void getCustomerScrollPane() {
        getCustomerTable();
        JScrollPane customerScrollPane = new JScrollPane(customerTable);
        customerScrollPane.setBounds(100, 100, 800,200);
        this.add(customerScrollPane, null);
    }

    private void getAccountTable() {
        String [] columnNames = {
                "Account Number", "Account Type", "Balance", "Customer ID"
        };
        Object[][] data = {
                {"843592944", 1, 7698.17, 1},
                {"196191617", 2, 20327.59, 2},
                {"955291079", 3, 16100.18, 3},
                {"150300551", 1, 24524.79, 4},
                {"929240322", 2, 40429.33, 5},
                {"348821130", 3, 65067.92, 6}
        };
        accountTable = new JTable(data,columnNames);
        accountTable.setPreferredScrollableViewportSize(new Dimension(500,100));
        accountTable.setFillsViewportHeight(true);
    }

    private void getAccountScrollPane() {
        getAccountTable();
        JScrollPane AccountScrollPane = new JScrollPane(accountTable);
        AccountScrollPane.setBounds(100, 350, 800,200);
        this.add(AccountScrollPane, null);
    }
}
