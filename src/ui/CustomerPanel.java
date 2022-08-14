package ui;

import entity.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class CustomerPanel extends JPanel {
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
    JLabel customerAddressLabel;
    JTextField customerAddressTextField;
    JLabel customerPhoneNumberLabel;
    JTextField customerPhoneNumberTextField;
    JLabel customerEmailLabel;
    JTextField customerEmailTextField;
    JButton updateCustomerButton;
    JButton deleteCustomerButton;
    JButton openAccountButton;
    JTable accountTable;
    JLabel messageLabel;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    Agent bankAgent;
    Customer bankCustomer;
    ArrayList<Account> customerAccounts;
    Return result;
    MainFrame mainFrame;
    public CustomerPanel(Customer bankCustomer, MainFrame mainFrame) {
        super(); // Initializes a JPanel class instance
        this.bankCustomer = bankCustomer;
        this.mainFrame = mainFrame;
        this.bankAgent = mainFrame.bankAgent;
        getCustomerData();
        this.setLayout(null);
        this.setBackground(LIGHT_CYAN); // Change the panel background color
        getPanelLabel();
        getAgentIdLabel();
        getCustomerIdLabel();
        getCustomerIdTextField();
        getCustomerEmailLabel();
        getCustomerEmailTextField();
        getCustomerFirstNameLabel();
        getCustomerFirstNameTextField();
        getCustomerLastNameLabel();
        getCustomerLastNameTextField();
        getCustomerAddressLabel();
        getCustomerAddressTextField();
        getCustomerPhoneNumberLabel();
        getCustomerPhoneNumberTextField();
        getUpdateCustomerButton();
        getDeleteCustomerButton();
        getOpenAccountButton();
        getMessageLabel();
        getAccountScrollPane();  // Gets the table inside a scrollable panel
    }

    /* Initialize the Customer Panel components */
    private void getPanelLabel() {
        panelLabel = new JLabel("CUSTOMER");
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
        customerIdLabel.setBounds(100,50,75,30);
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

    private void getCustomerFirstNameLabel() {
        customerFirstNameLabel = new JLabel("First Name");
        customerFirstNameLabel.setBounds(100,100,75,30);
        customerFirstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerFirstNameLabel,null);
    }
    private void getCustomerFirstNameTextField() {
        String firstName = bankCustomer.getFirstName();
        customerFirstNameTextField = new JTextField(firstName);
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
        String lastName = bankCustomer.getLastName();
        customerLastNameTextField = new JTextField(lastName);
        customerLastNameTextField.setBounds(675,100,200,30);
        customerLastNameTextField.setEditable(false);
        this.add(customerLastNameTextField,null);
    }

    private void getCustomerAddressLabel() {
        customerAddressLabel = new JLabel("Address");
        customerAddressLabel.setBounds(100,150,75,30);
        customerAddressLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerAddressLabel,null);
    }
    private void getCustomerAddressTextField() {
        String address = bankCustomer.getAddress();
        customerAddressTextField = new JTextField(address);
        customerAddressTextField.setBounds(200,150,200,30);
        customerAddressTextField.setEditable(false);
        this.add(customerAddressTextField,null);
    }

    private void getCustomerPhoneNumberLabel() {
        customerPhoneNumberLabel = new JLabel("Phone Number");
        customerPhoneNumberLabel.setBounds(550,150,100,30);
        customerPhoneNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerPhoneNumberLabel,null);
    }
    private void getCustomerPhoneNumberTextField() {
        String phoneNumber = bankCustomer.getPhoneNumber();
        customerPhoneNumberTextField = new JTextField(phoneNumber);
        customerPhoneNumberTextField.setBounds(675,150,200,30);
        customerPhoneNumberTextField.setEditable(false);
        this.add(customerPhoneNumberTextField,null);
    }

    private void getCustomerEmailLabel() {
        customerEmailLabel = new JLabel("Email Address");
        customerEmailLabel.setBounds(550,50,100,30);
        customerEmailLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerEmailLabel,null);
    }
    private void getCustomerEmailTextField() {
        String email = bankCustomer.getEmail();
        customerEmailTextField = new JTextField(email);
        customerEmailTextField.setBounds(675,50,200,30);
        customerEmailTextField.setEditable(false);
        this.add(customerEmailTextField,null);
    }

    private void getUpdateCustomerButton() {
        updateCustomerButton = new JButton("Update Customer");
        updateCustomerButton.setBounds(100,500,200,30);
        this.add(updateCustomerButton, null);
        updateCustomerButton.setFocusable(false);
        // Update action for the button click event
        updateCustomerButton.addActionListener(event -> {
            mainFrame.getUpdateCustomerPanel(bankCustomer);
        });
    }
    private void getDeleteCustomerButton() {
        deleteCustomerButton = new JButton("Delete Customer");
        deleteCustomerButton.setBounds(400,500,200,30);
        this.add(deleteCustomerButton, null);
        deleteCustomerButton.setFocusable(false);
        // Delete action for the button click event
        deleteCustomerButton.addActionListener(event -> {
            if (JOptionPane.showConfirmDialog(
                    mainFrame,
                    "Click YES to confirm deleting this customer",
                    "Delete Customer",
                    JOptionPane.YES_NO_OPTION) == 0
            ) {
                bankCustomer.deleteCustomer(bankCustomer, bankAgent, result);
                if (result.getCode().equals("00")){
                    mainFrame.getSearchPanel();
                } else {
                    messageLabel.setText(result.getMessage());
                }
            }
        });
    }
    private void getOpenAccountButton() {
        openAccountButton = new JButton("Open Account");
        openAccountButton.setBounds(700,500,200,30);
        this.add(openAccountButton, null);
        openAccountButton.setFocusable(false);
        // Open Account action for the button click event
        openAccountButton.addActionListener(event -> {
            /*  */
            mainFrame.getOpenAccountPanel(bankCustomer);
        });
    }
    private void getMessageLabel() {
        messageLabel = new JLabel("");
        messageLabel.setBounds(100,450,800,30);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setForeground(Color.RED);
        this.add(messageLabel);
    }
    private void getCustomerData() {
        customerAccounts = new ArrayList<>();
        result = new Return();
        bankCustomer.viewCustomer(bankCustomer, customerAccounts, result);
    }
    private void getAccountTable() {
        String [] columnNames = {
                "Account Number", "Account Type", "Balance", "Transfer Amount",
                "Transfer Quantity", "Customer ID", "Open Date"
        };
        String[][] data = new String[customerAccounts.size()][columnNames.length];

        for (int i = 0; i < data.length ; i++) {
            data[i][0] = String.valueOf(customerAccounts.get(i).getAccNumber());
            data[i][1] = customerAccounts.get(i).getAccType();
            data[i][2] = String.valueOf(customerAccounts.get(i).getBalance());
            data[i][3] = String.valueOf(customerAccounts.get(i).getTransferAmount());
            data[i][4] = String.valueOf(customerAccounts.get(i).getTransferQuantity());
            data[i][5] = String.valueOf(customerAccounts.get(i).getCustomerId());
            data[i][6] = String.valueOf(customerAccounts.get(i).getOpenDate());
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        accountTable = new JTable(tableModel) {
            public boolean isCellEditable(int data, int columnNames) {
                return false;
            }
        };
        accountTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                JTable table = (JTable)event.getSource();
                if (event.getClickCount() == 2) {
                    int row = table.rowAtPoint(event.getPoint());
                    Account searchedAccount = customerAccounts.get(row);
                    mainFrame.getAccountPanel(searchedAccount);
                }
            }
        });
        accountTable.setRowHeight(25);
        accountTable.setPreferredScrollableViewportSize(new Dimension(500,100));
        accountTable.setFillsViewportHeight(true);
    }

    private void getAccountScrollPane() {
        getAccountTable();
        JScrollPane AccountScrollPane = new JScrollPane(accountTable);
        AccountScrollPane.setBounds(100, 250, 800,200);
        this.add(AccountScrollPane, null);
    }
}
