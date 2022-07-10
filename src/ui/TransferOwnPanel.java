package ui;

import javax.swing.*;
import java.awt.*;


public class TransferOwnPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel agentIdLabel;
    JLabel customerIdLabel;
    JTextField customerIdTextField;
    JLabel accountNumberLabel;
    JTextField accountNumberTextField;
    JLabel customerFirstNameLabel;
    JTextField customerFirstNameTextField;
    JLabel customerLastNameLabel;
    JTextField customerLastNameTextField;
    JLabel destinationAccountLabel;
    JComboBox<String> destinationAccountComboBox;
    JLabel amountLabel;
    JTextField amountTextField;
    JButton transferButton;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    public TransferOwnPanel() {
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
        getAccountNumber();
        getAccountNumberTextField();
        getDestinationAccountLabel();
        getDestinationAccountComboBox();
        getAmountLabel();
        getAmountTextField();
        getTransferButton();
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
        customerIdLabel.setBounds(100,50,100,30);
        customerIdLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerIdLabel,null);
    }
    private void getCustomerIdTextField() {
        customerIdTextField = new JTextField();
        customerIdTextField.setBounds(225,50,200,30);
        this.add(customerIdTextField,null);
    }

    private void getAccountNumber() {
        accountNumberLabel = new JLabel("Account Number");
        accountNumberLabel.setBounds(550,50,100,30);
        accountNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountNumberLabel,null);
    }
    private void getAccountNumberTextField() {
        accountNumberTextField = new JTextField();
        accountNumberTextField.setBounds(675,50,200,30);
        this.add(accountNumberTextField,null);
    }

    private void getCustomerFirstNameLabel() {
        customerFirstNameLabel = new JLabel("First Name");
        customerFirstNameLabel.setBounds(100,100,100,30);
        customerFirstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerFirstNameLabel,null);
    }
    private void getCustomerFirstNameTextField() {
        customerFirstNameTextField = new JTextField();
        customerFirstNameTextField.setBounds(225,100,200,30);
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

    private void getDestinationAccountLabel() {
        destinationAccountLabel = new JLabel("Destination Account");
        destinationAccountLabel.setBounds(100,150,125,30);
        destinationAccountLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(destinationAccountLabel,null);
    }
    private void getDestinationAccountComboBox() {
        String[] accountTypes = {"843592944", "196191617", "955291079"};
        destinationAccountComboBox = new JComboBox<>(accountTypes);
        destinationAccountComboBox.setBounds(225,150,200,30);
        this.add(destinationAccountComboBox,null);
    }

    private void getAmountLabel() {
        amountLabel = new JLabel("Transfer Amount");
        amountLabel.setBounds(550,150,100,30);
        amountLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(amountLabel,null);
    }
    private void getAmountTextField() {
        amountTextField = new JTextField();
        amountTextField.setBounds(675,150,200,30);
        this.add(amountTextField,null);
    }

    private void getTransferButton() {
        transferButton = new JButton("Transfer");
        transferButton.setBounds(675,200,200,30);
        this.add(transferButton, null);
        transferButton.setFocusable(false);
        // Update action for the button click event
        transferButton.addActionListener(event -> {
            /*  */

        });
    }
}
