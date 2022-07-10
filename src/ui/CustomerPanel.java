package ui;

import javax.swing.*;
import java.awt.*;


public class CustomerPanel extends JPanel {
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
    JLabel customerAddressLabel;
    JTextField customerAddressTextField;
    JLabel customerPhoneNumberLabel;
    JTextField customerPhoneNumberTextField;
    JLabel customerEmailLabel;
    JTextField customerEmailTextField;
    JButton updateCustomerButton;
    JButton deleteCustomerButton;
    JButton openAccountButton;
    JTable accountTable;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    public CustomerPanel() {
        super(); // Initializes a JPanel class instance
        this.setLayout(null);
        this.setBackground(LIGHT_CYAN); // Change the panel background color
        getAgentIdLabel();
        getCustomerIdLabel();
        getCustomerIdTextField();
        getCustomerEmailLabel();
        getCustomerEmailTextField();
        getCustomerFirstNameLabel();
        getCustomerFirstNameTextField();
        getCustomerLastNameLabel();
        getCustomerLastNameTextField();
        getCustomerAddressLabel();
        getCustomerAddressTextField();
        getCustomerPhoneNumberLabel();
        getCustomerPhoneNumberTextField();
        getUpdateCustomerButton();
        getDeleteCustomerButton();
        getOpenAccountButton();

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
        customerIdTextField.setBounds(200,50,200,30);
        this.add(customerIdTextField,null);
    }

    private void getCustomerFirstNameLabel() {
        customerFirstNameLabel = new JLabel("First Name");
        customerFirstNameLabel.setBounds(100,100,75,30);
        customerFirstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerFirstNameLabel,null);
    }
    private void getCustomerFirstNameTextField() {
        customerFirstNameTextField = new JTextField();
        customerFirstNameTextField.setBounds(200,100,200,30);
        this.add(customerFirstNameTextField,null);
    }

    private void getCustomerLastNameLabel() {
        customerLastNameLabel = new JLabel("Last Name");
        customerLastNameLabel.setBounds(550,100,100,30);
        customerLastNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerLastNameLabel,null);
    }
    private void getCustomerLastNameTextField() {
        customerLastNameTextField = new JTextField();
        customerLastNameTextField.setBounds(675,100,200,30);
        this.add(customerLastNameTextField,null);
    }

    private void getCustomerAddressLabel() {
        customerAddressLabel = new JLabel("Address");
        customerAddressLabel.setBounds(100,150,75,30);
        customerAddressLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerAddressLabel,null);
    }
    private void getCustomerAddressTextField() {
        customerAddressTextField = new JTextField();
        customerAddressTextField.setBounds(200,150,200,30);
        this.add(customerAddressTextField,null);
    }

    private void getCustomerPhoneNumberLabel() {
        customerPhoneNumberLabel = new JLabel("Phone Number");
        customerPhoneNumberLabel.setBounds(550,150,100,30);
        customerPhoneNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerPhoneNumberLabel,null);
    }
    private void getCustomerPhoneNumberTextField() {
        customerPhoneNumberTextField = new JTextField();
        customerPhoneNumberTextField.setBounds(675,150,200,30);
        this.add(customerPhoneNumberTextField,null);
    }

    private void getCustomerEmailLabel() {
        customerEmailLabel = new JLabel("Email Address");
        customerEmailLabel.setBounds(550,50,100,30);
        customerEmailLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerEmailLabel,null);
    }
    private void getCustomerEmailTextField() {
        customerEmailTextField = new JTextField();
        customerEmailTextField.setBounds(675,50,200,30);
        this.add(customerEmailTextField,null);
    }

    private void getUpdateCustomerButton() {
        updateCustomerButton = new JButton("Update Customer");
        updateCustomerButton.setBounds(100,500,200,30);
        this.add(updateCustomerButton, null);
        updateCustomerButton.setFocusable(false);
        // Update action for the button click event
        updateCustomerButton.addActionListener(event -> {
            /*  */

        });
    }
    private void getDeleteCustomerButton() {
        deleteCustomerButton = new JButton("Delete Customer");
        deleteCustomerButton.setBounds(400,500,200,30);
        this.add(deleteCustomerButton, null);
        deleteCustomerButton.setFocusable(false);
        // Delete action for the button click event
        deleteCustomerButton.addActionListener(event -> {
            /*  */

        });
    }
    private void getOpenAccountButton() {
        openAccountButton = new JButton("Open Account");
        openAccountButton.setBounds(700,500,200,30);
        this.add(openAccountButton, null);
        openAccountButton.setFocusable(false);
        // Open Account action for the button click event
        openAccountButton.addActionListener(event -> {
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
        AccountScrollPane.setBounds(100, 250, 800,200);
        this.add(AccountScrollPane, null);
    }
}
