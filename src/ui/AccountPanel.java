package ui;

import javax.swing.*;
import java.awt.*;


public class AccountPanel extends JPanel {
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
    JLabel transferAmountLabel;
    JTextField transferAmountTextField;
    JLabel transferQuantityLabel;
    JTextField transferQuantityTextField;
    JButton depositButton;
    JButton withdrawalButton;
    JButton transferOwnButton;
    JButton transferOthersButton;
    JButton changeTypeButton;
    JButton deleteAccountButton;
    JTable accountTable;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    public AccountPanel() {
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
        getTransferAmountLabel();
        getTransferAmountTextField();
        getTransferQuantityLabel();
        getTransferQuantityTextField();
        getDepositButton();
        getWithdrawalButton();
        getTransferOwnButton();
        getTransferOthersButton();
        getChangeTypeButton();
        getDeleteAccountButton();

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
        customerIdLabel.setBounds(100,50,100,30);
        customerIdLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerIdLabel,null);
    }
    private void getCustomerIdTextField() {
        customerIdTextField = new JTextField();
        customerIdTextField.setBounds(225,50,150,30);
        this.add(customerIdTextField,null);
    }

    private void getCustomerFirstNameLabel() {
        customerFirstNameLabel = new JLabel("First Name");
        customerFirstNameLabel.setBounds(400,50,100,30);
        customerFirstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerFirstNameLabel,null);
    }
    private void getCustomerFirstNameTextField() {
        customerFirstNameTextField = new JTextField();
        customerFirstNameTextField.setBounds(525,50,150,30);
        this.add(customerFirstNameTextField,null);
    }

    private void getCustomerLastNameLabel() {
        customerLastNameLabel = new JLabel("Last Name");
        customerLastNameLabel.setBounds(700,50,100,30);
        customerLastNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerLastNameLabel,null);
    }
    private void getCustomerLastNameTextField() {
        customerLastNameTextField = new JTextField();
        customerLastNameTextField.setBounds(825,50,150,30);
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
        accountNumberTextField.setBounds(225,100,150,30);
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
        accountTypeTextField.setBounds(525,100,150,30);
        this.add(accountTypeTextField,null);
    }

    private void getAccountBalanceLabel() {
        accountBalanceLabel = new JLabel("Account Balance");
        accountBalanceLabel.setBounds(700,100,100,30);
        accountBalanceLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountBalanceLabel,null);
    }
    private void getAccountBalanceTextField() {
        accountBalanceTextField = new JTextField();
        accountBalanceTextField.setBounds(825,100,150,30);
        this.add(accountBalanceTextField,null);
    }

    private void getTransferAmountLabel() {
        transferAmountLabel = new JLabel("Transfer Amount");
        transferAmountLabel.setBounds(100,150,125,30);
        transferAmountLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(transferAmountLabel,null);
    }
    private void getTransferAmountTextField() {
        transferAmountTextField = new JTextField();
        transferAmountTextField.setBounds(250,150,200,30);
        this.add(transferAmountTextField,null);
    }

    private void getTransferQuantityLabel() {
        transferQuantityLabel = new JLabel("Transfer Quantity");
        transferQuantityLabel.setBounds(500,150,125,30);
        transferQuantityLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(transferQuantityLabel,null);
    }
    private void getTransferQuantityTextField() {
        transferQuantityTextField = new JTextField();
        transferQuantityTextField.setBounds(650,150,200,30);
        this.add(transferQuantityTextField,null);
    }
    private void getDepositButton() {
        depositButton = new JButton("Deposit");
        depositButton.setBounds(100,500,200,30);
        this.add(depositButton, null);
        depositButton.setFocusable(false);
        // Update action for the button click event
        depositButton.addActionListener(event -> {
            /*  */

        });
    }
    private void getWithdrawalButton() {
        withdrawalButton = new JButton("Withdrawal");
        withdrawalButton.setBounds(400,500,200,30);
        this.add(withdrawalButton, null);
        withdrawalButton.setFocusable(false);
        // Delete action for the button click event
        withdrawalButton.addActionListener(event -> {
            /*  */

        });
    }
    private void getTransferOwnButton() {
        transferOwnButton = new JButton("Transfer own");
        transferOwnButton.setBounds(700,500,200,30);
        this.add(transferOwnButton, null);
        transferOwnButton.setFocusable(false);
        // Open Account action for the button click event
        transferOwnButton.addActionListener(event -> {
            /*  */

        });
    }

    private void getTransferOthersButton() {
        transferOthersButton = new JButton("Transfer Others");
        transferOthersButton.setBounds(100,550,200,30);
        this.add(transferOthersButton, null);
        transferOthersButton.setFocusable(false);
        // Update action for the button click event
        transferOthersButton.addActionListener(event -> {
            /*  */

        });
    }
    private void getChangeTypeButton() {
        changeTypeButton = new JButton("ChangeType");
        changeTypeButton.setBounds(400,550,200,30);
        this.add(changeTypeButton, null);
        changeTypeButton.setFocusable(false);
        // Delete action for the button click event
        changeTypeButton.addActionListener(event -> {
            /*  */

        });
    }
    private void getDeleteAccountButton() {
        deleteAccountButton = new JButton("Delete Account");
        deleteAccountButton.setBounds(700,550,200,30);
        this.add(deleteAccountButton, null);
        deleteAccountButton.setFocusable(false);
        // Open Account action for the button click event
        deleteAccountButton.addActionListener(event -> {
            /*  */

        });
    }

    private void getAccountTable() {
        String [] columnNames = {
                "Movement Date", "Transaction ID", "Source Account", "Destination Account",
                "Amount", "Previous Balance", "New Balance"
        };
        Object[][] data = {
                {"2022-04-06", "Transfer", "937850261", "707745387", 4073, 19969, 16596},
                {"2022-01-06", "Withdrawal", "937850261", "NULL", 4992, 8279, 7089},
                {"2021-12-08", "Deposit", "NULL", "937850261", 1221, 11351, 10144},
                {"2022-01-10", "Transfer", "950330208", "937850261", 4670, 4370, 14442},
                {"2022-05-12", "Deposit", "NULL", "319897371", 1987, 6607, 11758}
        };
        accountTable = new JTable(data,columnNames);
        accountTable.setPreferredScrollableViewportSize(new Dimension(700,100));
        accountTable.setFillsViewportHeight(true);
    }

    private void getAccountScrollPane() {
        getAccountTable();
        JScrollPane AccountScrollPane = new JScrollPane(accountTable);
        AccountScrollPane.setBounds(50, 200, 900,200);
        this.add(AccountScrollPane, null);
    }
}
