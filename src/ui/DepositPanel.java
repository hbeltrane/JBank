package ui;

import entity.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;


public class DepositPanel extends JPanel {
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
    JButton cancelDepositButton;
    JButton depositButton;
    JLabel messageLabel;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    ZoneId defaultZoneId;
    Agent bankAgent;
    Account customerAccount;
    Customer bankCustomer;
    Return result;
    MainFrame mainFrame;
    public DepositPanel(Account customerAccount, Customer bankCustomer, MainFrame mainFrame) {
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
        getAmountLabel();
        getAmountTextField();
        getCancelDepositButton();
        getDepositButton();
        getMessageLabel();
    }

    /* Initialize the Customer Panel components */
    private void getPanelLabel() {
        panelLabel = new JLabel("DEPOSIT");
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
        amountLabel = new JLabel("Deposit Amount");
        amountLabel.setBounds(100,150,100,30);
        amountLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(amountLabel,null);
    }
    private void getAmountTextField() {
        amountTextField = new JTextField();
        amountTextField.setBounds(200,150,200,30);
        this.add(amountTextField,null);
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
    private void getDepositButton() {
        depositButton = new JButton("Deposit");
        depositButton.setBounds(675,200,200,30);
        this.add(depositButton, null);
        depositButton.setFocusable(false);
        // Update action for the button click event
        depositButton.addActionListener(event -> {
            /*  */
            if (isValidData()) {
                result = new Return();
                Movement deposit = new Movement(
                        "",
                        customerAccount.getAccNumber(),
                        Double.parseDouble(amountTextField.getText()),
                        0d,
                        0d,
                        Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant()),
                        "");
                customerAccount.deposit(deposit, customerAccount, bankAgent, result);
                amountTextField.setText("");
                mainFrame.getAccountPanel(customerAccount);
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
        if (amount.length() < 1) {
            messageLabel.setText("Error! Deposit Amount cannot be empty.");
            return false;
        }
        if (!isValidAmount(amount)) {
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
}
