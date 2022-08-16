package ui;

import entity.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;

/**
 * Withdrawal Panel class
 */
public class WithdrawalPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel panelLabel;
    JLabel agentIdLabel;
    JLabel customerIdLabel;
    JTextField customerIdTextField;
    JLabel customerFirstNameLabel;
    JTextField customerFirstNameTextField;
    JLabel customerLastNameLabel;
    JTextField customerLastNameTextField;
    JLabel accountNumberLabel;
    JTextField accountNumberTextField;
    JLabel amountLabel;
    JTextField amountTextField;
    JLabel customerPinLabel;
    JPasswordField customerPinTextField;
    JButton cancelWithdrawalButton;
    JButton withdrawButton;
    JLabel messageLabel;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    ZoneId defaultZoneId;
    Agent bankAgent;
    Account customerAccount;
    Customer bankCustomer;
    Return result;
    MainFrame mainFrame;
    /**
     * Withdrawal Panel Constructor method
     * @param customerAccount Customer Account
     * @param bankCustomer Bank Customer
     * @param mainFrame Main Window
     */
    public WithdrawalPanel(Account customerAccount, Customer bankCustomer, MainFrame mainFrame) {
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
        getCustomerPinLabel();
        getCustomerPinTextField();
        getCustomerIdTextField();
        getCustomerFirstNameLabel();
        getCustomerFirstNameTextField();
        getCustomerLastNameLabel();
        getCustomerLastNameTextField();
        getAccountNumber();
        getAccountNumberTextField();
        getAmountLabel();
        getAmountTextField();
        getCancelWithdrawalButton();
        getWithdrawButton();
        getMessageLabel();
    }

    /**
     * Initialize the Customer Panel Label
     */
    private void getPanelLabel() {
        panelLabel = new JLabel("WITHDRAW");
        panelLabel.setBounds(100,0,200,30);
        panelLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(panelLabel,null);
    }
    /**
     * Initialize the Agent Label
     */
    private void getAgentIdLabel() {
        agentIdLabel = new JLabel(bankAgent.getFullName());
        agentIdLabel.setBounds(700,0,200,30);
        agentIdLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(agentIdLabel,null);
    }
    /**
     * Initialize the Customer ID Label
     */
    private void getCustomerIdLabel() {
        customerIdLabel = new JLabel("Customer ID");
        customerIdLabel.setBounds(100,50,100,30);
        customerIdLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerIdLabel,null);
    }
    /**
     * Initialize the Customer ID Text Field
     */
    private void getCustomerIdTextField() {
        String customerId = String.valueOf(bankCustomer.getCustomerId());
        customerIdTextField = new JTextField(customerId);
        customerIdTextField.setBounds(200,50,200,30);
        customerIdTextField.setEditable(false);
        this.add(customerIdTextField,null);
    }
    /**
     * Initialize the Account Number Label
     */
    private void getAccountNumber() {
        accountNumberLabel = new JLabel("Account Number");
        accountNumberLabel.setBounds(550,50,100,30);
        accountNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountNumberLabel,null);
    }
    /**
     * Initialize the Account Number Text Field
     */
    private void getAccountNumberTextField() {
        accountNumberTextField = new JTextField(customerAccount.getAccNumber());
        accountNumberTextField.setBounds(675,50,200,30);
        accountNumberTextField.setEditable(false);
        this.add(accountNumberTextField,null);
    }
    /**
     * Initialize the Customer First Name Label
     */
    private void getCustomerFirstNameLabel() {
        customerFirstNameLabel = new JLabel("First Name");
        customerFirstNameLabel.setBounds(100,100,100,30);
        customerFirstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerFirstNameLabel,null);
    }
    /**
     * Initialize the Customer First Name Text Field
     */
    private void getCustomerFirstNameTextField() {
        customerFirstNameTextField = new JTextField(bankCustomer.getFirstName());
        customerFirstNameTextField.setBounds(200,100,200,30);
        customerFirstNameTextField.setEditable(false);
        this.add(customerFirstNameTextField,null);
    }
    /**
     * Initialize the Customer Last Name Label
     */
    private void getCustomerLastNameLabel() {
        customerLastNameLabel = new JLabel("Last Name");
        customerLastNameLabel.setBounds(550,100,100,30);
        customerLastNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerLastNameLabel,null);
    }
    /**
     * Initialize the Customer Last Name Text Field
     */
    private void getCustomerLastNameTextField() {
        customerLastNameTextField = new JTextField(bankCustomer.getLastName());
        customerLastNameTextField.setBounds(675,100,200,30);
        customerLastNameTextField.setEditable(false);
        this.add(customerLastNameTextField,null);
    }
    /**
     * Initialize the Amount Label
     */
    private void getAmountLabel() {
        amountLabel = new JLabel("Amount");
        amountLabel.setBounds(100,150,100,30);
        amountLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(amountLabel,null);
    }
    /**
     * Initialize the Amount Text Field
     */
    private void getAmountTextField() {
        amountTextField = new JTextField();
        amountTextField.setBounds(200,150,200,30);
        this.add(amountTextField,null);
    }
    /**
     * Initialize the PIN Label
     */
    private void getCustomerPinLabel() {
        customerPinLabel = new JLabel("Customer PIN");
        customerPinLabel.setBounds(550,150,100,30);
        customerPinLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerPinLabel,null);
    }
    /**
     * Initialize the PIN Text Field
     */
    private void getCustomerPinTextField() {
        customerPinTextField = new JPasswordField();
        customerPinTextField.setBounds(675,150,200,30);
        this.add(customerPinTextField,null);
    }
    /**
     * Initialize the Cancel Withdrawal Button
     */
    private void getCancelWithdrawalButton() {
        cancelWithdrawalButton = new JButton("Cancel");
        cancelWithdrawalButton.setBounds(100,200,200,30);
        this.add(cancelWithdrawalButton, null);
        cancelWithdrawalButton.setFocusable(false);
        // Update action for the button click event
        cancelWithdrawalButton.addActionListener(event -> {
            /* Go back to account panel */
            mainFrame.getAccountPanel(customerAccount);
        });
    }
    /**
     * Initialize the Withdraw Button
     */
    private void getWithdrawButton() {
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(675,200,200,30);
        this.add(withdrawButton, null);
        withdrawButton.setFocusable(false);
        // Update action for the button click event
        withdrawButton.addActionListener(event -> {
            /*  */
            if (isValidData()) {
                if (getPinText().trim().equals(bankCustomer.getPin())) {
                    result = new Return();
                    Movement withdraw = new Movement(
                            customerAccount.getAccNumber(),
                            "",
                            Double.parseDouble(amountTextField.getText()),
                            0d,
                            0d,
                            Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant()),
                            "");
                    customerAccount.withdraw(withdraw, customerAccount, bankAgent, result);
                    if (result.getCode().equals("00")){
                        amountTextField.setText("");
                        mainFrame.getAccountPanel(customerAccount);
                    } else {
                        messageLabel.setText(result.getMessage());
                    }
                } else {
                    messageLabel.setText("Error! The PIN is incorrect.");
                }
            }
        });
    }
    /**
     * Initialize the Message Label
     */
    private void getMessageLabel() {
        messageLabel = new JLabel("");
        messageLabel.setBounds(100,250,800,30);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setForeground(Color.RED);
        this.add(messageLabel);
    }
    /**
     * Validate the data input from the user
     * @return True if it is valid, false otherwise
     */
    private boolean isValidData() {
        String amount = amountTextField.getText().trim();
        String pin = getPinText().trim();
        if (amount.length() < 1) {
            messageLabel.setText("Error! Withdrawal Amount cannot be empty.");
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
    /**
     * Validate if the  Amount to Withdraw is in a correct format and range
     * @param amountString Transfer Amount
     * @return True if it is valid, false otherwise
     */
    private boolean isValidAmount(String amountString) {
        boolean isValid = false;
        try {
            double amount =  Double.parseDouble(amountString);
            if (amount > 0d && amount < 100000000d) {
                isValid = true;
            } else {
                messageLabel.setText("Error! Deposit Amount is out of range");
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Error! Deposit Amount was in an incorrect format.");
        }
        return isValid;
    }
    /**
     * Extract the string representation from the customer PIN
     * @return The PIN text
     */
    public String getPinText() {
        StringBuilder pinString = new StringBuilder();
        char[] pin = customerPinTextField.getPassword();
        for (char pinChar : pin) {
            pinString.append(pinChar);
        }
        return pinString.toString();
    }
    /**
     * Check if the Customer PIN is valid
     * @param pinString pinString Customer PIN
     * @return True if it is valid, false otherwise
     */
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
