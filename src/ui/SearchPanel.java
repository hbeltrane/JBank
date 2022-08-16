package ui;

import entity.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Search Panel class
 */
public class SearchPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel agentIdLabel;
    JLabel searchLabel;
    JTextField searchTextField;
    JButton searchButton;
    JLabel messageLabel;
    JTable customerTable;
    JTable accountTable;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    final Color ERROR_COLOR = Color.RED;
    final Color INFO_COLOR = Color.GRAY;
    int customerTableHintCounter = 0;
    int accountTableHintCounter = 0;
    Agent bankAgent;
    Return result;
    ArrayList<Customer> resultCustomers;
    ArrayList<Account> resultAccounts;
    MainFrame mainFrame;

    /**
     * Search Panel constructor
     * @param mainFrame Main Window
     */
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
        getMessageLabel();
        getCustomerScrollPane();  // Gets the table inside a scrollable panel
        getAccountScrollPane();
    }

    /**
     * Initialize the Agent ID Label
     */
    private void getAgentIdLabel() {
        agentIdLabel = new JLabel(bankAgent.getFullName());
        agentIdLabel.setBounds(700,0,200,30);
        agentIdLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(agentIdLabel,null);
    }

    /**
     * Initialize the Search Label
     */
    private void getSearchLabel() {
        searchLabel = new JLabel("Search");
        searchLabel.setBounds(300,50,50,30);
        searchLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(searchLabel,null);
    }

    /**
     * Initialize the Search Text Field
     */
    private void getSearchTextField() {
        searchTextField = new JTextField();
        searchTextField.setBounds(375,50,250,30);
        this.add(searchTextField,null);
    }

    /**
     * Initialize the Search Panel Message Label
     */
    private void getMessageLabel() {
        messageLabel = new JLabel("");
        messageLabel.setBounds(100,300,800,30);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        //messageLabel.setForeground(Color.RED);
        this.add(messageLabel);
    }

    /**
     * Initialize the Search Button and add it an Event Lestener
     */
    private void getSearchButton() {
        searchButton = new JButton("Find");
        searchButton.setBounds(700,50,200,30);
        this.add(searchButton, null);
        searchButton.setFocusable(false);
        // Search action for the button click event
        searchButton.addActionListener(event -> {
            /* Search customers or accounts */
            bankAgent.agentSearchCustomers(searchTextField.getText().trim(), resultCustomers, result);
            if (Objects.equals(result.getCode(), "00")) {
                updateCustomerTable();
            }
            else {
                System.out.println(result.getCode() + " - " + result.getMessage());
            }
            result = new Return();
            bankAgent.agentSearchAccounts(searchTextField.getText().trim(), resultAccounts, result);
            if (Objects.equals(result.getCode(), "00")) {
                updateAccountTable();
            }
            else {
                System.out.println(result.getCode() + " - " + result.getMessage());
            }
        });
    }

    /**
     * Initialize the Customer Table
     */
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
                    try {
                        JTable table = (JTable)event.getSource();
                        if (event.getClickCount() == 1) {
                            if (customerTableHintCounter > 1 && customerTableHintCounter < 4) {
                                messageLabel.setText("Double click over a customer to view more details.");
                                messageLabel.setForeground(INFO_COLOR);
                                customerTableHintCounter++;
                            } else {
                                customerTableHintCounter++;
                                messageLabel.setText("");
                            }
                        }
                        if (event.getClickCount() == 2) {
                            int row = table.rowAtPoint(event.getPoint());
                            Customer searchedCustomer = resultCustomers.get(row);
                            mainFrame.getCustomerPanel(searchedCustomer);
                            messageLabel.setText("");
                            customerTableHintCounter = 99;
                        }
                    } catch (IndexOutOfBoundsException ie) {
                        System.out.println(ie.getMessage());
                        messageLabel.setForeground(ERROR_COLOR);
                        messageLabel.setText("Invalid selection.");
                    }
                }

        });
        customerTable.setRowHeight(25);
        customerTable.setPreferredScrollableViewportSize(new Dimension(500,100));
        customerTable.setFillsViewportHeight(true);
    }

    /**
     * Initialize the Customer Table Scrollable Pane
     */
    private void getCustomerScrollPane() {
        getCustomerTable();
        JScrollPane customerScrollPane = new JScrollPane(customerTable);
        customerScrollPane.setBounds(100, 100, 800,200);
        this.add(customerScrollPane, null);
    }

    /**
     * Update the Customer Table following Search
     */
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

    /**
     * Initialize the Account Table
     */
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
                try {
                    JTable table = (JTable)event.getSource();
                    if (event.getClickCount() == 1) {
                        if (accountTableHintCounter > 1 && accountTableHintCounter < 4) {
                            messageLabel.setText("Double click over an account to view more details.");
                            messageLabel.setForeground(INFO_COLOR);
                            accountTableHintCounter++;
                        } else {
                            accountTableHintCounter++;
                            messageLabel.setText("");
                        }
                    }
                    if (event.getClickCount() == 2) {
                        int row = table.rowAtPoint(event.getPoint());
                        Account searchedAccount = resultAccounts.get(row);
                        mainFrame.getAccountPanel(searchedAccount);
                        messageLabel.setText("");
                        accountTableHintCounter = 99;
                    }
                } catch (IndexOutOfBoundsException ie) {
                    System.out.println(ie.getMessage());
                    messageLabel.setText("Invalid selection.");
                    messageLabel.setForeground(ERROR_COLOR);
                }
            }
        });
        accountTable.setRowHeight(25);
        accountTable.setPreferredScrollableViewportSize(new Dimension(500,100));
        accountTable.setFillsViewportHeight(true);
    }

    /**
     * Initialize the Account Scrollable Pane
     */
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

    /**
     * Reset Customer and Account Table
     */
    public void resetTablesResult() {
        DefaultTableModel customerTableModel = (DefaultTableModel) customerTable.getModel();
        customerTableModel.getDataVector().removeAllElements();
        customerTableModel.fireTableDataChanged();
        customerTable.setModel(customerTableModel);
        customerTable.repaint();
        DefaultTableModel accountTableModel = (DefaultTableModel) accountTable.getModel();
        accountTableModel.setRowCount(0);
        accountTable.setModel(accountTableModel);
        accountTable.repaint();
    }
}
