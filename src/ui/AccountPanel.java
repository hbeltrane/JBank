package ui;

import entity.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;


/**
 * Account Panel class
 */
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
    JLabel messageLabel;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    Agent bankAgent;
    Account customerAccount;
    Customer bankCustomer;
    Return result;
    ArrayList<Movement> accountMovements;
    MainFrame mainFrame;

    /**
     * Account Panel Constructor
     * @param customerAccount Customer Account
     * @param mainFrame Main Frame
     */
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
        getMessageLabel();
        getAccountScrollPane();  // Gets the table inside a scrollable panel
    }

    /**
     * Initialize the Account Panel Label
     */
    private void getPanelLabel() {
        panelLabel = new JLabel("ACCOUNT");
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
        customerIdTextField.setBounds(225,50,150,30);
        customerIdTextField.setEditable(false);
        this.add(customerIdTextField,null);
    }

    /**
     * Initialize the Customer First Name Label
     */
    private void getCustomerFirstNameLabel() {
        customerFirstNameLabel = new JLabel("First Name");
        customerFirstNameLabel.setBounds(400,50,100,30);
        customerFirstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerFirstNameLabel,null);
    }

    /**
     * Initialize the Customer First Name Text Field
     */
    private void getCustomerFirstNameTextField() {
        String firstName = bankCustomer.getFirstName();
        customerFirstNameTextField = new JTextField(firstName);
        customerFirstNameTextField.setBounds(525,50,150,30);
        customerFirstNameTextField.setEditable(false);
        this.add(customerFirstNameTextField,null);
    }

    /**
     * Initialize the Customer Last Name Label
     */
    private void getCustomerLastNameLabel() {
        customerLastNameLabel = new JLabel("Last Name");
        customerLastNameLabel.setBounds(700,50,100,30);
        customerLastNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerLastNameLabel,null);
    }

    /**
     * Initialize the Customer Last Name Text Field
     */
    private void getCustomerLastNameTextField() {
        String lastName = bankCustomer.getLastName();
        customerLastNameTextField = new JTextField(lastName);
        customerLastNameTextField.setBounds(825,50,150,30);
        customerLastNameTextField.setEditable(false);
        this.add(customerLastNameTextField,null);
    }

    /**
     * Initialize the Account Label
     */
    private void getAccountNumberLabel() {
        accountNumberLabel = new JLabel("Account Number");
        accountNumberLabel.setBounds(100,100,100,30);
        accountNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountNumberLabel,null);
    }

    /**
     * Initialize the Customer Address Text Field
     */
    private void getAccountNumberTextField() {
        String accountNumber = customerAccount.getAccNumber();
        accountNumberTextField = new JTextField(accountNumber);
        accountNumberTextField.setBounds(225,100,150,30);
        accountNumberTextField.setEditable(false);
        this.add(accountNumberTextField,null);
    }

    /**
     * Initialize the Account Type Label
     */
    private void getAccountTypeLabel() {
        accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setBounds(400,100,100,30);
        accountTypeLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountTypeLabel,null);
    }

    /**
     * Initialize the Account Type Text Field
     */
    private void getAccountTypeTextField() {
        String accountType = customerAccount.getAccType();
        accountTypeTextField = new JTextField(accountType);
        accountTypeTextField.setBounds(525,100,150,30);
        accountTypeTextField.setEditable(false);
        this.add(accountTypeTextField,null);
    }

    /**
     * Initialize the Account Balance Label
     */
    private void getAccountBalanceLabel() {
        accountBalanceLabel = new JLabel("Account Balance");
        accountBalanceLabel.setBounds(700,100,100,30);
        accountBalanceLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountBalanceLabel,null);
    }

    /**
     * Initialize the Account Balance Text Field
     */
    private void getAccountBalanceTextField() {
        String accountBalance = String.valueOf(customerAccount.getBalance());
        accountBalanceTextField = new JTextField(accountBalance);
        accountBalanceTextField.setBounds(825,100,150,30);
        accountBalanceTextField.setEditable(false);
        this.add(accountBalanceTextField,null);
    }

    /**
     * Initialize the Transfer Amount Label
     */
    private void getTransferAmountLabel() {
        transferAmountLabel = new JLabel("Transfer Amount");
        transferAmountLabel.setBounds(100,150,125,30);
        transferAmountLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(transferAmountLabel,null);
    }

    /**
     * Initialize the Transfer Amount Text Field
     */
    private void getTransferAmountTextField() {
        String transferAmount = String.valueOf(customerAccount.getTransferAmount());
        transferAmountTextField = new JTextField(transferAmount);
        transferAmountTextField.setBounds(250,150,200,30);
        transferAmountTextField.setEditable(false);
        this.add(transferAmountTextField,null);
    }

    /**
     * Initialize the Transfer Quantity Label
     */
    private void getTransferQuantityLabel() {
        transferQuantityLabel = new JLabel("Transfer Quantity");
        transferQuantityLabel.setBounds(500,150,125,30);
        transferQuantityLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(transferQuantityLabel,null);
    }

    /**
     * Initialize the Transfer Quantity
     */
    private void getTransferQuantityTextField() {
        String transferQuantity = String.valueOf(customerAccount.getTransferQuantity());
        transferQuantityTextField = new JTextField(transferQuantity);
        transferQuantityTextField.setBounds(650,150,200,30);
        transferQuantityTextField.setEditable(false);
        this.add(transferQuantityTextField,null);
    }

    /**
     * Initialize the Window Message Label
     */
    private void getMessageLabel() {
        messageLabel = new JLabel("");
        messageLabel.setBounds(100,400,900,30);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setForeground(Color.RED);
        this.add(messageLabel);
    }

    /**
     * Initialize the Deposit Button and add it an Event Listener
     */
    private void getDepositButton() {
        depositButton = new JButton("Deposit");
        depositButton.setBounds(100,450,200,30);
        this.add(depositButton, null);
        depositButton.setFocusable(false);
        // Update action for the button click event
        depositButton.addActionListener(event -> {
            /*  */
            mainFrame.getDepositPanel(customerAccount, bankCustomer);
        });
    }

    /**
     * Initialize the Withdraw Button and add it an Event Listener
     */
    private void getWithdrawalButton() {
        withdrawalButton = new JButton("Withdrawal");
        withdrawalButton.setBounds(400,450,200,30);
        this.add(withdrawalButton, null);
        withdrawalButton.setFocusable(false);
        // Delete action for the button click event
        withdrawalButton.addActionListener(event -> {
            /*  */
            mainFrame.getWithdrawalPanel(customerAccount, bankCustomer);
        });
    }

    /**
     * Initialize the Transfer Own Button and add it an Event Listener
     */
    private void getTransferOwnButton() {
        transferOwnButton = new JButton("Transfer own");
        transferOwnButton.setBounds(700,450,200,30);
        this.add(transferOwnButton, null);
        transferOwnButton.setFocusable(false);
        // Open Account action for the button click event
        transferOwnButton.addActionListener(event -> {
            /*  */
            mainFrame.getTransferOwnPanel(customerAccount, bankCustomer);
        });
    }

    /**
     * Initialize the Transfer Other Button and add it an Event Listener
     */
    private void getTransferOthersButton() {
        transferOthersButton = new JButton("Transfer Others");
        transferOthersButton.setBounds(100,500,200,30);
        this.add(transferOthersButton, null);
        transferOthersButton.setFocusable(false);
        // Update action for the button click event
        transferOthersButton.addActionListener(event -> {
            /*  */
            mainFrame.getTransferOthersPanel(customerAccount, bankCustomer);
        });
    }

    /**
     * Initialize the Change Account Type Button and add it an Event Listener
     */
    private void getChangeTypeButton() {
        changeTypeButton = new JButton("ChangeType");
        changeTypeButton.setBounds(400,500,200,30);
        this.add(changeTypeButton, null);
        changeTypeButton.setFocusable(false);
        // Delete action for the button click event
        changeTypeButton.addActionListener(event -> {
            /*  */
            //TODO
        });
    }

    /**
     * Initialize Delete Account Button and add it an Event Listener
     */
    private void getDeleteAccountButton() {
        deleteAccountButton = new JButton("Delete Account");
        deleteAccountButton.setBounds(700,500,200,30);
        this.add(deleteAccountButton, null);
        deleteAccountButton.setFocusable(false);
        // Open Account action for the button click event
        deleteAccountButton.addActionListener(event -> {
            /*  */
            if (JOptionPane.showConfirmDialog(
                    mainFrame,
                    "Click YES to confirm deleting this account",
                    "Delete Customer",
                    JOptionPane.YES_NO_OPTION) == 0
            ) {
                customerAccount.deleteAccount(customerAccount, bankAgent, result);
                if (result.getCode().equals("00")){
                    mainFrame.getSearchPanel();
                } else {
                    messageLabel.setText(result.getMessage());
                }
            }
        });
    }

    /**
     * Retrieve a list of movement from a Bank Account
     */
    private void getAccountData() {
        accountMovements = new ArrayList<>();
        bankCustomer = new Customer();
        result = new Return();
        customerAccount.viewAccount(bankCustomer, customerAccount, accountMovements,result);
    }

    /**
     * Initialize and populate the Movement table
     */
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

    /**
     * Create a Scrollable Pane for the Movement Table
     */
    private void getAccountScrollPane() {
        getMovementsTable();
        JScrollPane AccountScrollPane = new JScrollPane(movementsTable);
        AccountScrollPane.setBounds(50, 200, 900,200);
        this.add(AccountScrollPane, null);
    }
}
