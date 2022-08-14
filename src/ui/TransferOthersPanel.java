package ui;

import entity.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;


public class TransferOthersPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel panelLabel;
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
    JTextField destinationAccountJTextField;
    JLabel amountLabel;
    JTextField amountTextField;
    JButton transferButton;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    ZoneId defaultZoneId;
    Agent bankAgent;
    Account customerAccount;
    Customer bankCustomer;
    Return result;
    MainFrame mainFrame;
    public TransferOthersPanel(Account customerAccount, Customer bankCustomer, MainFrame mainFrame) {
        super(); // Initializes a JPanel class instance
        this.customerAccount = customerAccount;
        this.bankCustomer = bankCustomer;
        this.mainFrame = mainFrame;
        this.bankAgent = mainFrame.bankAgent;
        defaultZoneId = ZoneId.systemDefault();
        this.setLayout(null);
        this.setBackground(LIGHT_CYAN); // Change the panel background color
        getPanelLabel();
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
        getDestinationAccountJTextField();
        getAmountLabel();
        getAmountTextField();
        getTransferButton();
    }

    /* Initialize the Customer Panel components */
    private void getPanelLabel() {
        panelLabel = new JLabel("TRANSFER OTHERS");
        panelLabel.setBounds(100,0,200,30);
        panelLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(panelLabel,null);
    }
    private void getAgentIdLabel() {
        agentIdLabel = new JLabel(bankAgent.getFullName());
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
    private void getDestinationAccountJTextField() {
        destinationAccountJTextField = new JTextField();
        destinationAccountJTextField.setBounds(225,150,200,30);
        this.add(destinationAccountJTextField,null);
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
//    private boolean isValidData() {
//        String accountNumber = accountNumberTextField.getText().trim();
//        String amount = amountTextField.getText().trim();
//        if (accountNumber.length() < 9) {
//            messageLabel.setText("Error! Account Number must be 9 characters length.");
//            return false;
//        }
//        if (amount.length() < 1) {
//            messageLabel.setText("Error! Deposit Amount cannot be empty.");
//            return false;
//        }
//        if (!isValidAccountNumber(accountNumber)) {
//            return false;
//        }
//        if (!isValidAmount(amount)) {
//            return false;
//        }
//        messageLabel.setText("");
//        return true;
//    }
//    private boolean isValidAccountNumber(String accountNumberString) {
//        boolean isValid = false;
//        try {
//            long accountNumber =  Long.parseLong(accountNumberString);
//            if (accountNumber > 999999999L && accountNumber <= 9999999999L) {
//                isValid = true;
//            } else {
//                messageLabel.setText("Error! Phone number must be 10 characters");
//            }
//        } catch (NumberFormatException ex) {
//            messageLabel.setText("Error! Phone number was in an incorrect format.");
//        }
//        return isValid;
//    }
//    private boolean isValidAmount(String amountString) {
//        boolean isValid = false;
//        try {
//            double amount =  Double.parseDouble(amountString);
//            if (amount >= 0d && amount < 100000000d) {
//                isValid = true;
//            } else {
//                messageLabel.setText("Error! The Deposit Amount is out of range");
//            }
//        } catch (NumberFormatException ex) {
//            messageLabel.setText("Error! Deposit Amount was in an incorrect format.");
//        }
//        return isValid;
//    }
}
