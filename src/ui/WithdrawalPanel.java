package ui;

import entity.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;


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
    JButton cancelDepositButton;
    JButton withdrawButton;
    JLabel messageLabel;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    ZoneId defaultZoneId;
    Agent bankAgent;
    Account customerAccount;
    Customer bankCustomer;
    Return result;
    MainFrame mainFrame;
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
        getCancelDepositButton();
        getWithdrawButton();
        getMessageLabel();
    }

    /* Initialize the Customer Panel components */
    private void getPanelLabel() {
        panelLabel = new JLabel("WITHDRAW");
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
        String customerId = String.valueOf(bankCustomer.getCustomerId());
        customerIdTextField = new JTextField(customerId);
        customerIdTextField.setBounds(200,50,200,30);
        customerIdTextField.setEditable(false);
        this.add(customerIdTextField,null);
    }

    private void getAccountNumber() {
        accountNumberLabel = new JLabel("Account Number");
        accountNumberLabel.setBounds(550,50,100,30);
        accountNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountNumberLabel,null);
    }
    private void getAccountNumberTextField() {
        accountNumberTextField = new JTextField(customerAccount.getAccNumber());
        accountNumberTextField.setBounds(675,50,200,30);
        accountNumberTextField.setEditable(false);
        this.add(accountNumberTextField,null);
    }

    private void getCustomerFirstNameLabel() {
        customerFirstNameLabel = new JLabel("First Name");
        customerFirstNameLabel.setBounds(100,100,100,30);
        customerFirstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerFirstNameLabel,null);
    }
    private void getCustomerFirstNameTextField() {
        customerFirstNameTextField = new JTextField(bankCustomer.getFirstName());
        customerFirstNameTextField.setBounds(200,100,200,30);
        customerFirstNameTextField.setEditable(false);
        this.add(customerFirstNameTextField,null);
    }

    private void getCustomerLastNameLabel() {
        customerLastNameLabel = new JLabel("Last Name");
        customerLastNameLabel.setBounds(550,100,100,30);
        customerLastNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerLastNameLabel,null);
    }
    private void getCustomerLastNameTextField() {
        customerLastNameTextField = new JTextField(bankCustomer.getLastName());
        customerLastNameTextField.setBounds(675,100,200,30);
        customerLastNameTextField.setEditable(false);
        this.add(customerLastNameTextField,null);
    }

    private void getAmountLabel() {
        amountLabel = new JLabel("Withdrawal Amount");
        amountLabel.setBounds(100,150,100,30);
        amountLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(amountLabel,null);
    }
    private void getAmountTextField() {
        amountTextField = new JTextField();
        amountTextField.setBounds(200,150,200,30);
        this.add(amountTextField,null);
    }
    private void getCustomerPinLabel() {
        customerPinLabel = new JLabel("Customer PIN");
        customerPinLabel.setBounds(550,150,100,30);
        customerPinLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerPinLabel,null);
    }
    private void getCustomerPinTextField() {
        customerPinTextField = new JPasswordField();
        customerPinTextField.setBounds(675,150,200,30);
        this.add(customerPinTextField,null);
    }
    private void getCancelDepositButton() {
        cancelDepositButton = new JButton("Cancel");
        cancelDepositButton.setBounds(100,200,200,30);
        this.add(cancelDepositButton, null);
        cancelDepositButton.setFocusable(false);
        // Update action for the button click event
        cancelDepositButton.addActionListener(event -> {
            /* Go back to account panel */
            mainFrame.getAccountPanel(customerAccount);
        });
    }
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
                    Movement withdraw = new Movement(
                            "",
                            customerAccount.getAccNumber(),
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
