package ui;

import db.*;
import entity.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/**
 * Main Window Class which manges the other components
 */
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

    /**
     * Main Frame constructor method
     */
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

    /**
     * Override close main window event
     */
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

    /**
     * Creates the window menu bar
     */
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

    /**
     * Create the Agent Menu for the Menu bar and add the menu items
     */
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

    /**
     * Create the Customer Menu for the Menu bar and add the menu items
     */
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

    /**
     * Create the Agent Menu for the Menu bar and add a menu item
     */
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

    /**
     * Create and launch the Login Frame
     */
    private void getLoginFrame() {
        bankAgent = new Agent();
        loginFrame = new LoginFrame(this);
        loginFrame.setVisible(true);
    }

    /**
     * Dispose the Login Frame object
     * @param loginFrame Login Frame
     */
    public void disposeLoginFrame(LoginFrame loginFrame) {
        if (this.loginFrame == loginFrame) {
            this.loginFrame = null;
        }
    }

    /**
     * Create a Search Panel and add it to the Main Frame
     */
    public void getSearchPanel() {
        searchPanel = new SearchPanel(this);
        searchPanel.resetTablesResult();
        getContentPane().removeAll();
        add(searchPanel);
        revalidate();
        repaint();

    }

    /**
     * Create a Customer Panel and add it to the Main Frame to display the customer details
     * @param searchedCustomer Customer selected from the search panel
     */
    public void getCustomerPanel(Customer searchedCustomer) {
        customerPanel = new CustomerPanel(searchedCustomer, this);
        getContentPane().removeAll();
        add(customerPanel);
        revalidate();
        repaint();
    }

    /**
     * Create an Account Panel and add it to the Main Frame to display the account details
     * @param searchedAccount Account selected from the search panel
     */
    public void getAccountPanel(Account searchedAccount) {
        accountPanel = new AccountPanel(searchedAccount, this);
        getContentPane().removeAll();
        add(accountPanel);
        revalidate();
        repaint();
    }

    /**
     * Create a Create Customer Panel and add it to the Main Frame
     */
    public void getCreateCustomerPanel(){
        createCustomerPanel = new CreateCustomerPanel(this);
        getContentPane().removeAll();
        add(createCustomerPanel);
        revalidate();
        repaint();
    }

    /**
     * Create an Update Customer Panel and add it to the Main Frame
     * @param customer Customer to Update
     */
    public void getUpdateCustomerPanel(Customer customer){
        updateCustomerPanel = new UpdateCustomerPanel(customer,this);
        getContentPane().removeAll();
        add(updateCustomerPanel);
        revalidate();
        repaint();
    }

    /**
     * Create an Open Account Panel and add it to the Main Frame
     * @param bankCustomer Customer to open an account
     */
    public void getOpenAccountPanel(Customer bankCustomer){
        openAccountPanel = new OpenAccountPanel(bankCustomer,this);
        getContentPane().removeAll();
        add(openAccountPanel);
        revalidate();
        repaint();
    }

    /**
     * Create a Deposit Panel and add it to the Main Frame
     * @param customerAccount Account to deposit
     * @param bankCustomer Customer who owns the account
     */
    public void getDepositPanel(Account customerAccount, Customer bankCustomer) {
        depositPanel = new DepositPanel(customerAccount, bankCustomer, this);
        getContentPane().removeAll();
        add(depositPanel);
        revalidate();
        repaint();
    }

    /**
     * Create a Withdrawal Panel and add it to the Main Frame
     * @param customerAccount Account to withdraw
     * @param bankCustomer Customer who owns the account
     */
    public void getWithdrawalPanel(Account customerAccount, Customer bankCustomer) {
        withdrawalPanel = new WithdrawalPanel(customerAccount, bankCustomer, this);
        getContentPane().removeAll();
        add(withdrawalPanel);
        revalidate();
        repaint();
    }

    /**
     * Create a Transfer Own Panel and add it to the Main Frame
     * @param customerAccount Account to transfer from
     * @param bankCustomer Customer who owns the account
     */
    public void getTransferOwnPanel(Account customerAccount, Customer bankCustomer){
        transferOwnPanel = new TransferOwnPanel(customerAccount, bankCustomer, this);
        getContentPane().removeAll();
        add(transferOwnPanel);
        revalidate();
        repaint();
    }

    /**
     * Create a Transfer Other Panel and add it to the Main Frame
     * @param customerAccount Account to transfer from
     * @param bankCustomer Customer who owns the account
     */
    public void getTransferOthersPanel(Account customerAccount, Customer bankCustomer){
        transferOthersPanel = new TransferOthersPanel(customerAccount, bankCustomer, this);
        getContentPane().removeAll();
        add(transferOthersPanel);
        revalidate();
        repaint();
    }
}
