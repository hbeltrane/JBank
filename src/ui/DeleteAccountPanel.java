package ui;

import javax.swing.*;
import java.awt.*;

public class DeleteAccountPanel extends JPanel {
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
    JLabel accountNumberLabel;
    JTextField accountNumberTextField;
    JLabel accountTypeLabel;
    JTextField accountTypeTextField;
    JLabel accountBalanceLabel;
    JTextField accountBalanceTextField;
    JButton deleteCustomerButton;

    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    public DeleteAccountPanel() {
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
        getAccountNumberLabel();
        getAccountNumberTextField();
        getAccountTypeLabel();
        getAccountTypeTextField();
        getAccountBalanceLabel();
        getAccountBalanceTextField();
        getDeleteAccountButton();

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
        customerIdTextField.setBounds(200,50,150,30);
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
        customerFirstNameTextField.setBounds(500,50,150,30);
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
        customerLastNameTextField.setBounds(775,50,150,30);
        this.add(customerLastNameTextField,null);
    }

    private void getAccountNumberLabel() {
        accountNumberLabel = new JLabel("Account Number");
        accountNumberLabel.setBounds(100,100,100,30);
        accountNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountNumberLabel,null);
    }
    private void getAccountNumberTextField() {
        accountNumberTextField = new JTextField();
        accountNumberTextField.setBounds(200,100,150,30);
        this.add(accountNumberTextField,null);
    }

    private void getAccountTypeLabel() {
        accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setBounds(400,100,100,30);
        accountTypeLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountTypeLabel,null);
    }
    private void getAccountTypeTextField() {
        accountTypeTextField = new JTextField();
        accountTypeTextField.setBounds(500,100,150,30);
        this.add(accountTypeTextField,null);
    }

    private void getAccountBalanceLabel() {
        accountBalanceLabel = new JLabel("Account Balance");
        accountBalanceLabel.setBounds(675,100,100,30);
        accountBalanceLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountBalanceLabel,null);
    }
    private void getAccountBalanceTextField() {
        accountBalanceTextField = new JTextField();
        accountBalanceTextField.setBounds(775,100,150,30);
        this.add(accountBalanceTextField,null);
    }

    private void getDeleteAccountButton() {
        deleteCustomerButton = new JButton("Delete Account");
        deleteCustomerButton.setBounds(425,350,200,30);
        this.add(deleteCustomerButton, null);
        deleteCustomerButton.setFocusable(false);
        // Delete action for the button click event
        deleteCustomerButton.addActionListener(event -> {
            /*  */

        });
    }
}
