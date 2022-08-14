package ui;

import entity.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;


public class TransferOwnPanel extends JPanel {
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
    JComboBox<String> destinationAccountComboBox;
    JLabel amountLabel;
    JTextField amountTextField;
    JLabel customerPinLabel;
    JPasswordField customerPinTextField;
    JButton transferButton;
    JLabel messageLabel;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    ZoneId defaultZoneId;
    Agent bankAgent;
    Account customerAccount;
    Customer bankCustomer;
    Return result;
    ArrayList<Account> customerAccounts;
    MainFrame mainFrame;
    public TransferOwnPanel(Account customerAccount, Customer bankCustomer, MainFrame mainFrame) {
        super(); // Initializes a JPanel class instance
        this.customerAccount = customerAccount;
        this.bankCustomer = bankCustomer;
        this.mainFrame = mainFrame;
        this.bankAgent = mainFrame.bankAgent;
        defaultZoneId = ZoneId.systemDefault();
        getCustomerData();
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
        getDestinationAccountComboBox();
        getAmountLabel();
        getAmountTextField();
        getMessageLabel();
        getCustomerPinLabel();
        getCustomerPinTextField();
        getTransferButton();
    }

    /* Initialize the Customer Panel components */
    private void getPanelLabel() {
        panelLabel = new JLabel("TRANSFER OWN");
        panelLabel.setBounds(100,0,200,30);
        panelLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(panelLabel,null);
    }
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
        String[] ownAccounts = new String[customerAccounts.size()];

        for (int i = 0; i < customerAccounts.size(); i++) {
            ownAccounts[i] = customerAccounts.get(i).getAccNumber();
        }

        destinationAccountComboBox = new JComboBox<>(ownAccounts);
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
    private void getCustomerPinLabel() {
        customerPinLabel = new JLabel("Customer PIN");
        customerPinLabel.setBounds(100,200,100,30);
        customerPinLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerPinLabel,null);
    }
    private void getCustomerPinTextField() {
        customerPinTextField = new JPasswordField();
        customerPinTextField.setBounds(175,200,200,30);
        this.add(customerPinTextField,null);
    }
    private void getCustomerData() {
        customerAccounts = new ArrayList<>();
        ArrayList<Account> allCustomerAccounts = new ArrayList<>();
        result = new Return();
        bankCustomer.viewCustomer(bankCustomer, allCustomerAccounts, result);
        for (Account account : allCustomerAccounts) {
            if (account.getAccNumber().equals(customerAccount.getAccNumber())) {
                customerAccounts.add(account);
            }
        }
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
    private void getMessageLabel() {
        messageLabel = new JLabel("");
        messageLabel.setBounds(100,250,800,30);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setForeground(Color.RED);
        this.add(messageLabel);
    }
    private boolean isValidData() {
        String amount = amountTextField.getText().trim();
        String pin = getPinText().trim();
        if (amount.length() < 1) {
            messageLabel.setText("Error! Deposit Amount cannot be empty.");
            return false;
        }
        if (!isValidAmount(amount)) {
            return false;
        }
        if (pin.length() < 1) {
            messageLabel.setText("Error! PIN field cannot be empty.");
            return false;
        }
        if (!isValidPin(pin)) {
            return false;
        }
        messageLabel.setText("");
        return true;
    }
    private boolean isValidAmount(String amountString) {
        boolean isValid = false;
        try {
            double amount =  Double.parseDouble(amountString);
            if (amount > 0d && amount < 100000000d) {
                isValid = true;
            } else {
                messageLabel.setText("Error! The Deposit Amount is out of range");
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Error! Deposit Amount was in an incorrect format.");
        }
        return isValid;
    }
    public String getPinText() {
        StringBuilder pinString = new StringBuilder();
        char[] pin = customerPinTextField.getPassword();
        for (char pinChar : pin) {
            pinString.append(pinChar);
        }
        return pinString.toString();
    }
    private boolean isValidPin(String pinString) {
        boolean isValid = false;
        try {
            int pin =  Integer.parseInt(pinString);
            if (pin > 999 && pin < 10000){
                isValid = true;
            } else {
                messageLabel.setText("Error! PIN must be 4 characters");
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Error! PIN number was in an incorrect format.");
        }
        return isValid;
    }
}
