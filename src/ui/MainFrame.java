package ui;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    SearchPanel searchPanel;
    CustomerPanel customerPanel;
    AccountPanel accountPanel;
    CreateCustomerPanel createCustomerPanel;
    OpenAccountPanel openAccountPanel;
    DepositPanel depositPanel;
    TransferOwnPanel transferOwnPanel;
    TransferOthersPanel transferOthersPanel;
    DeleteCustomerPanel deleteCustomerPanel;
    DeleteAccountPanel deleteAccountPanel;
    public MainFrame() {
        super("JBank"); // Initialize parent and sets title to the window
        this.setSize(960,640);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends program when exit the window
        this.setContentPane(getDeleteAccountPanel());

        this.setVisible(true);
//        LoginFrame loginFrame = new LoginFrame();
//        loginFrame.setVisible(true);

    }

    private JPanel getSearchPanel() {
        searchPanel = new SearchPanel();
        return searchPanel;
    }
    private JPanel getCustomerPanel() {
        customerPanel = new CustomerPanel();
        return customerPanel;
    }
    private JPanel getAccountPanel() {
       accountPanel = new AccountPanel();
        return accountPanel;
    }
    private JPanel getCreateCustomerPanel(){
        createCustomerPanel = new CreateCustomerPanel();
        return createCustomerPanel;
    }
    private JPanel getOpenAccountPanel(){
        openAccountPanel = new OpenAccountPanel();
        return openAccountPanel;
    }
    private JPanel getDepositPanel(){
        depositPanel = new DepositPanel();
        return depositPanel;
    }
    private JPanel getTransferOwnPanel(){
        transferOwnPanel = new TransferOwnPanel();
        return transferOwnPanel;
    }
    private JPanel getTransferOthersPanel(){
        transferOthersPanel = new TransferOthersPanel();
        return transferOthersPanel;
    }
    private JPanel getDeleteCustomer(){
        deleteCustomerPanel = new DeleteCustomerPanel();
        return deleteCustomerPanel;
    }
    private JPanel getDeleteAccountPanel(){
        deleteAccountPanel = new DeleteAccountPanel();
        return deleteAccountPanel;
    }
}
