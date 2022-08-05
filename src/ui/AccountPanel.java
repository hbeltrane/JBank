package ui;

import entity.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;


public class AccountPanel extends JPanel {
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
    JTable movementsTable;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    Agent bankAgent;
    Account customerAccount;
    Customer bankCustomer;
    Return result;
    ArrayList<Movement> accountMovements;
    MainFrame mainFrame;
    public AccountPanel(Account customerAccount, MainFrame mainFrame) {
        super(); // Initializes a JPanel class instance
        this.customerAccount = customerAccount;
        this.mainFrame = mainFrame;
        this.bankAgent = mainFrame.bankAgent;
        getAccountData();
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
    private void getPanelLabel() {
        panelLabel = new JLabel("ACCOUNT");
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
        customerIdTextField.setBounds(225,50,150,30);
        customerIdTextField.setEnabled(false);
        this.add(customerIdTextField,null);
    }

    private void getCustomerFirstNameLabel() {
        customerFirstNameLabel = new JLabel("First Name");
        customerFirstNameLabel.setBounds(400,50,100,30);
        customerFirstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerFirstNameLabel,null);
    }
    private void getCustomerFirstNameTextField() {
        String firstName = bankCustomer.getFirstName();
        customerFirstNameTextField = new JTextField(firstName);
        customerFirstNameTextField.setBounds(525,50,150,30);
        customerFirstNameTextField.setEnabled(false);
        this.add(customerFirstNameTextField,null);
    }

    private void getCustomerLastNameLabel() {
        customerLastNameLabel = new JLabel("Last Name");
        customerLastNameLabel.setBounds(700,50,100,30);
        customerLastNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerLastNameLabel,null);
    }
    private void getCustomerLastNameTextField() {
        String lastName = bankCustomer.getLastName();
        customerLastNameTextField = new JTextField(lastName);
        customerLastNameTextField.setBounds(825,50,150,30);
        customerLastNameTextField.setEnabled(false);
        this.add(customerLastNameTextField,null);
    }

    private void getAccountNumberLabel() {
        accountNumberLabel = new JLabel("Account Number");
        accountNumberLabel.setBounds(100,100,100,30);
        accountNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountNumberLabel,null);
    }
    private void getAccountNumberTextField() {
        String accountNumber = customerAccount.getAccNumber();
        accountNumberTextField = new JTextField(accountNumber);
        accountNumberTextField.setBounds(225,100,150,30);
        accountNumberTextField.setEnabled(false);
        this.add(accountNumberTextField,null);
    }

    private void getAccountTypeLabel() {
        accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setBounds(400,100,100,30);
        accountTypeLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountTypeLabel,null);
    }
    private void getAccountTypeTextField() {
        String accountType = customerAccount.getAccType();
        accountTypeTextField = new JTextField(accountType);
        accountTypeTextField.setBounds(525,100,150,30);
        accountTypeTextField.setEnabled(false);
        this.add(accountTypeTextField,null);
    }

    private void getAccountBalanceLabel() {
        accountBalanceLabel = new JLabel("Account Balance");
        accountBalanceLabel.setBounds(700,100,100,30);
        accountBalanceLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountBalanceLabel,null);
    }
    private void getAccountBalanceTextField() {
        String accountBalance = String.valueOf(customerAccount.getBalance());
        accountBalanceTextField = new JTextField(accountBalance);
        accountBalanceTextField.setBounds(825,100,150,30);
        accountBalanceTextField.setEnabled(false);
        this.add(accountBalanceTextField,null);
    }

    private void getTransferAmountLabel() {
        transferAmountLabel = new JLabel("Transfer Amount");
        transferAmountLabel.setBounds(100,150,125,30);
        transferAmountLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(transferAmountLabel,null);
    }
    private void getTransferAmountTextField() {
        String transferAmount = String.valueOf(customerAccount.getTransferAmount());
        transferAmountTextField = new JTextField(transferAmount);
        transferAmountTextField.setBounds(250,150,200,30);
        transferAmountTextField.setEnabled(false);
        this.add(transferAmountTextField,null);
    }

    private void getTransferQuantityLabel() {
        transferQuantityLabel = new JLabel("Transfer Quantity");
        transferQuantityLabel.setBounds(500,150,125,30);
        transferQuantityLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(transferQuantityLabel,null);
    }
    private void getTransferQuantityTextField() {
        String transferQuantity = String.valueOf(customerAccount.getTransferQuantity());
        transferQuantityTextField = new JTextField(transferQuantity);
        transferQuantityTextField.setBounds(650,150,200,30);
        transferQuantityTextField.setEnabled(false);
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

    private void getAccountData() {
        accountMovements = new ArrayList<>();
        bankCustomer = new Customer();
        result = new Return();
        customerAccount.viewAccount(bankCustomer, customerAccount, accountMovements,result);
    }

    private void getMovementsTable() {
        String [] columnNames = {
                "Movement Date", "Transaction Type", "Source Account", "Destination Account",
                "Amount", "Previous Balance", "New Balance"
        };
        String[][] data = new String[accountMovements.size()][columnNames.length];

        for (int i = 0; i < data.length ; i++) {
            data[i][0] = String.valueOf(accountMovements.get(i).getMovementDate());
            data[i][1] = accountMovements.get(i).getDescription();
            data[i][2] = accountMovements.get(i).getSourceAccount();
            data[i][3] = accountMovements.get(i).getDestinationAccount();
            data[i][4] = String.valueOf(accountMovements.get(i).getAmount());
            data[i][5] = String.valueOf(accountMovements.get(i).getPreviousBalance());
            data[i][6] = String.valueOf(accountMovements.get(i).getNewBalance());
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        movementsTable = new JTable(tableModel) {
            public boolean isCellEditable(int data, int columnNames) {
                return false;
            }
        };
        movementsTable.setRowHeight(25);
        movementsTable.setPreferredScrollableViewportSize(new Dimension(700,100));
        movementsTable.setFillsViewportHeight(true);
    }

    private void getAccountScrollPane() {
        getMovementsTable();
        JScrollPane AccountScrollPane = new JScrollPane(movementsTable);
        AccountScrollPane.setBounds(50, 200, 900,200);
        this.add(AccountScrollPane, null);
    }
}
