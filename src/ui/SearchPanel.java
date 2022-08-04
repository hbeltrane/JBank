package ui;

import entity.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SearchPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel agentIdLabel;
    JLabel searchLabel;
    JTextField searchTextField;
    JButton searchButton;
    JTable customerTable;
    JTable accountTable;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    Agent bankAgent;
    Return result;
    ArrayList<Customer> resultCustomers;
    ArrayList<Account> resultAccounts;
    MainFrame mainFrame;
    public SearchPanel(MainFrame mainFrame) {
        super(); // Initializes a JPanel class instance
        this.mainFrame = mainFrame;
        this.bankAgent = mainFrame.bankAgent;
        result = new Return();
        resultCustomers = new ArrayList<>();
        resultAccounts = new ArrayList<>();
        this.setLayout(null);
        this.setBackground(LIGHT_CYAN); // Change the panel background color
        getAgentIdLabel();
        getSearchLabel();
        getSearchTextField();
        getSearchButton();
        getCustomerScrollPane();  // Gets the table inside a scrollable panel
        getAccountScrollPane();
    }

    /* Initialize the Search Panel components */
    private void getAgentIdLabel() {
        agentIdLabel = new JLabel(bankAgent.getFullName());
        agentIdLabel.setBounds(700,0,200,30);
        agentIdLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(agentIdLabel,null);
    }

    private void getSearchLabel() {
        searchLabel = new JLabel("Search");
        searchLabel.setBounds(300,50,50,30);
        searchLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(searchLabel,null);
    }

    private void getSearchTextField() {
        searchTextField = new JTextField();
        searchTextField.setBounds(375,50,250,30);
        this.add(searchTextField,null);
    }

    private void getSearchButton() {
        searchButton = new JButton("Find");
        searchButton.setBounds(700,50,200,30);
        this.add(searchButton, null);
        searchButton.setFocusable(false);
        // Search action for the button click event
        searchButton.addActionListener(event -> {
            /* Search customers or accounts */
            System.out.println("\n\n***** SEARCH TEST *****");
            bankAgent.agentSearchCustomers(searchTextField.getText(), resultCustomers, result);
            if (Objects.equals(result.getCode(), "00")) {
                updateCustomerTable();
            }
            else {
                System.out.println(result.getCode() + " - " + result.getMessage());
            }
            result = new Return();
            bankAgent.agentSearchAccounts(searchTextField.getText(), resultAccounts, result);
            if (Objects.equals(result.getCode(), "00")) {
                updateAccountTable();
            }
            else {
                System.out.println(result.getCode() + " - " + result.getMessage());
            }
        });
    }

    private void getCustomerTable() {
        String [] columnNames = {
                "Customer ID", "First Name", "Last Name", "Address", "Phone Number", "Email", "Creation Date"
        };
        String[][] data = new String[0][];
        TableModel tableModel = new DefaultTableModel(data, columnNames);
        customerTable = new JTable(tableModel) {
            public boolean isCellEditable(int data, int columnNames) {
                return false;
            }
        };
        customerTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                JTable table = (JTable)event.getSource();
                if (event.getClickCount() == 2) {
                    int row = table.rowAtPoint(event.getPoint());
                    Customer searchedCustomer = resultCustomers.get(row);
                    mainFrame.getCustomerPanel(searchedCustomer);
                }
            }
        });
        customerTable.setRowHeight(25);
        customerTable.setPreferredScrollableViewportSize(new Dimension(500,100));
        customerTable.setFillsViewportHeight(true);
    }

    private void getCustomerScrollPane() {
        getCustomerTable();
        JScrollPane customerScrollPane = new JScrollPane(customerTable);
        customerScrollPane.setBounds(100, 100, 800,200);
        this.add(customerScrollPane, null);
    }

    private void updateCustomerTable() {
        DefaultTableModel tableModel = (DefaultTableModel) customerTable.getModel();
        tableModel.setRowCount(0);
        for (Customer customer : resultCustomers) {
            String[] data = new String[tableModel.getColumnCount()];
            data[0] = String.valueOf(customer.getCustomerId());
            data[1] = customer.getFirstName();
            data[2] = customer.getLastName();
            data[3] = customer.getAddress();
            data[4] = customer.getPhoneNumber();
            data[5] = customer.getEmail();
            data[6] = String.valueOf(customer.getCreationDate());
            tableModel.addRow(data);
        }
        customerTable.setModel(tableModel);
        customerTable.repaint();
    }

    private void getAccountTable() {
        String [] columnNames = {
                "Account Number", "Account Type", "Balance", "Transfer Amount",
                "Transfer Quantity", "Customer ID", "Open Date"
        };
        Object[][] data = new String[0][];
        TableModel tableModel = new DefaultTableModel(data, columnNames);

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
                    Account searchedAccount = resultAccounts.get(row);
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
        AccountScrollPane.setBounds(100, 350, 800,200);
        this.add(AccountScrollPane, null);
    }

    private void updateAccountTable() {
        DefaultTableModel tableModel = (DefaultTableModel) accountTable.getModel();
        tableModel.setRowCount(0);
        for (Account account : resultAccounts) {
            String[] data = new String[tableModel.getColumnCount()];
            data[0] = account.getAccNumber();
            data[1] = account.getAccType();
            data[2] = String.valueOf(account.getBalance());
            data[3] = String.valueOf(account.getTransferAmount());
            data[4] = String.valueOf(account.getTransferQuantity());
            data[5] = String.valueOf(account.getCustomerId());
            data[6] = String.valueOf(account.getOpenDate());
            tableModel.addRow(data);
        }
        accountTable.setModel(tableModel);
        accountTable.repaint();
    }
}
