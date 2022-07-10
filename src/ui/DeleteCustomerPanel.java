package ui;

import javax.swing.*;
import java.awt.*;

public class DeleteCustomerPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel agentIdLabel;
    JLabel customerIdLabel;
    JTextField customerIdTextField;
    JLabel customerFirstNameLabel;
    JTextField customerFirstNameTextField;
    JLabel customerLastNameLabel;
    JTextField customerLastNameTextField;
    JButton deleteCustomerButton;
    JTable accountTable;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    public DeleteCustomerPanel() {
        super(); // Initializes a JPanel class instance
        this.setLayout(null);
        this.setBackground(LIGHT_CYAN); // Change the panel background color
        getAgentIdLabel();
        getCustomerIdLabel();
        getCustomerIdTextField();
        getCustomerFirstNameLabel();
        getCustomerFirstNameTextField();
        getCustomerLastNameLabel();
        getCustomerLastNameTextField();
        getDeleteCustomerButton();

        getAccountScrollPane();  // Gets the table inside a scrollable panel
    }

    /* Initialize the Customer Panel components */
    private void getAgentIdLabel() {
        agentIdLabel = new JLabel("@AgentID");
        agentIdLabel.setBounds(700,0,200,30);
        agentIdLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(agentIdLabel,null);
    }

    private void getCustomerIdLabel() {
        customerIdLabel = new JLabel("Customer ID");
        customerIdLabel.setBounds(100,50,75,30);
        customerIdLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerIdLabel,null);
    }
    private void getCustomerIdTextField() {
        customerIdTextField = new JTextField();
        customerIdTextField.setBounds(175,50,150,30);
        this.add(customerIdTextField,null);
    }

    private void getCustomerFirstNameLabel() {
        customerFirstNameLabel = new JLabel("First Name");
        customerFirstNameLabel.setBounds(400,50,75,30);
        customerFirstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerFirstNameLabel,null);
    }
    private void getCustomerFirstNameTextField() {
        customerFirstNameTextField = new JTextField();
        customerFirstNameTextField.setBounds(475,50,150,30);
        this.add(customerFirstNameTextField,null);
    }

    private void getCustomerLastNameLabel() {
        customerLastNameLabel = new JLabel("Last Name");
        customerLastNameLabel.setBounds(675,50,75,30);
        customerLastNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerLastNameLabel,null);
    }
    private void getCustomerLastNameTextField() {
        customerLastNameTextField = new JTextField();
        customerLastNameTextField.setBounds(750,50,150,30);
        this.add(customerLastNameTextField,null);
    }

    private void getDeleteCustomerButton() {
        deleteCustomerButton = new JButton("Delete Customer");
        deleteCustomerButton.setBounds(400,350,200,30);
        this.add(deleteCustomerButton, null);
        deleteCustomerButton.setFocusable(false);
        // Delete action for the button click event
        deleteCustomerButton.addActionListener(event -> {
            /*  */

        });
    }

    private void getAccountTable() {
        String [] columnNames = {
                "Account Number", "Account Type", "Balance", "Transfer Amount", "Transfer Quantity"
        };
        Object[][] data = {
                {"843592944", 1, 7698.17, 7710.6, 3},
                {"196191617", 2, 20327.59, 2899.12, 5},
                {"955291079", 3, 16100.18, 5783.88, 4}
        };
        accountTable = new JTable(data,columnNames);
        accountTable.setPreferredScrollableViewportSize(new Dimension(500,100));
        accountTable.setFillsViewportHeight(true);
    }

    private void getAccountScrollPane() {
        getAccountTable();
        JScrollPane AccountScrollPane = new JScrollPane(accountTable);
        AccountScrollPane.setBounds(100, 150, 800,150);
        this.add(AccountScrollPane, null);
    }
}
