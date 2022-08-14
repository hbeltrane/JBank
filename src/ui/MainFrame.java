package ui;

import db.*;
import entity.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MainFrame extends JFrame {
    // Graphical User Interface components
    JMenuBar menuBar;
    JMenu agentMenu;
    JMenu customerMenu;
    JMenu helpMenu;
    LoginFrame loginFrame;
    SearchPanel searchPanel;
    CustomerPanel customerPanel;
    AccountPanel accountPanel;
    CreateCustomerPanel createCustomerPanel;
    UpdateCustomerPanel updateCustomerPanel;
    OpenAccountPanel openAccountPanel;
    DepositPanel depositPanel;
    WithdrawalPanel withdrawalPanel;
    TransferOwnPanel transferOwnPanel;
    TransferOthersPanel transferOthersPanel;
    // Class properties
    Agent bankAgent;
    public MainFrame() {
        super("JBank"); // Initialize parent and sets title to the window
        setMenuBar();
        this.setSize(960,640);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends program when exit the window
        addCloseFrameEvent();
        this.setVisible(true);
        getLoginFrame();
    }
    private void addCloseFrameEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                try {
                    DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
                    databaseConnection.closeConnection();
                    event.getWindow().dispose();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    private void setMenuBar() {
        menuBar = new JMenuBar();
        getAgentMenu();
        menuBar.add(agentMenu);
        getCustomerMenu();
        menuBar.add(customerMenu);
        getHelpMenu();
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);
    }
    private void getAgentMenu() {
        agentMenu = new JMenu("Agent");
        JMenuItem loginMenuItem = new JMenuItem("Login");
        loginMenuItem.addActionListener(event -> {
            if (loginFrame == null) {
                if (bankAgent == null) getLoginFrame();
            } else {
                loginFrame.toFront();
            }
        });
        JMenuItem logoutMenuItem = new JMenuItem("Logout");
        logoutMenuItem.addActionListener(event -> {
            if (bankAgent != null) {
                bankAgent = null;
                if (loginFrame == null) {
                    this.getContentPane().removeAll();
                    this.revalidate();
                    this.repaint();
                    getLoginFrame();
                    loginFrame.toFront();
                }
            }
        });
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(event -> {
            System.exit(0);
        });
        agentMenu.add(loginMenuItem);
        agentMenu.add(logoutMenuItem);
        agentMenu.add(exitMenuItem);
    }
    private void getCustomerMenu() {
        customerMenu = new JMenu("Customer");
        JMenuItem searchMenuItem = new JMenuItem("Search");
        searchMenuItem.addActionListener(event -> {
            if (searchPanel != null) {
                if (searchPanel.getParent() == null) {
                    getSearchPanel();
                }
            }
        });
        JMenuItem newCustomerMenuItem = new JMenuItem("New Customer");
        newCustomerMenuItem.addActionListener(event -> {
            if (createCustomerPanel == null) {
                getCreateCustomerPanel();
            } else {
                if (createCustomerPanel.getParent() == null) {
                    getContentPane().removeAll();
                    add(createCustomerPanel);
                    revalidate();
                    repaint();
                }
            }
        });
        customerMenu.add(searchMenuItem);
        customerMenu.add(newCustomerMenuItem);
    }
    private void getHelpMenu() {
        helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        String aboutMessage = """
                JBank
                
                A Java Banking System

                \tDeveloped by Hugo Beltran & Juan Casanova
                \tfor CSD 3464 Programming Java SE
                \tCopyright © 2022""";
        aboutMenuItem.addActionListener(event -> {
            JOptionPane.showMessageDialog(
                    this,
                    aboutMessage,
                    "About",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        helpMenu.add(aboutMenuItem);
    }
    private void getLoginFrame() {
        bankAgent = new Agent();
        loginFrame = new LoginFrame(this);
        loginFrame.setVisible(true);
    }
    public void disposeLoginFrame(LoginFrame loginFrame) {
        if (this.loginFrame == loginFrame) {
            this.loginFrame = null;
        }
    }
    public void getSearchPanel() {
        searchPanel = new SearchPanel(this);
        searchPanel.resetTablesResult();
        getContentPane().removeAll();
        add(searchPanel);
        revalidate();
        repaint();

    }
    public void getCustomerPanel(Customer searchedCustomer) {
        customerPanel = new CustomerPanel(searchedCustomer, this);
        getContentPane().removeAll();
        add(customerPanel);
        revalidate();
        repaint();
    }
    public void getAccountPanel(Account searchedAccount) {
        accountPanel = new AccountPanel(searchedAccount, this);
        getContentPane().removeAll();
        add(accountPanel);
        revalidate();
        repaint();
    }
    public void getCreateCustomerPanel(){
        createCustomerPanel = new CreateCustomerPanel(this);
        getContentPane().removeAll();
        add(createCustomerPanel);
        revalidate();
        repaint();
    }
    public void getUpdateCustomerPanel(Customer customer){
        updateCustomerPanel = new UpdateCustomerPanel(customer,this);
        getContentPane().removeAll();
        add(updateCustomerPanel);
        revalidate();
        repaint();
    }
    public void getOpenAccountPanel(Customer bankCustomer){
        openAccountPanel = new OpenAccountPanel(bankCustomer,this);
        getContentPane().removeAll();
        add(openAccountPanel);
        revalidate();
        repaint();
    }
    public void getDepositPanel(Account customerAccount, Customer bankCustomer) {
        depositPanel = new DepositPanel(customerAccount, bankCustomer, this);
        getContentPane().removeAll();
        add(depositPanel);
        revalidate();
        repaint();
    }
    public void getWithdrawalPanel(Account customerAccount, Customer bankCustomer) {
        withdrawalPanel = new WithdrawalPanel(customerAccount, bankCustomer, this);
        getContentPane().removeAll();
        add(withdrawalPanel);
        revalidate();
        repaint();
    }
    public void getTransferOwnPanel(Account customerAccount, Customer bankCustomer){
        transferOwnPanel = new TransferOwnPanel(customerAccount, bankCustomer, this);
        getContentPane().removeAll();
        add(transferOwnPanel);
        revalidate();
        repaint();
    }
    public void getTransferOthersPanel(Account customerAccount, Customer bankCustomer){
        transferOthersPanel = new TransferOthersPanel(customerAccount, bankCustomer, this);
        getContentPane().removeAll();
        add(transferOthersPanel);
        revalidate();
        repaint();
    }
}
