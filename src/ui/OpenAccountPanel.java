package ui;

import entity.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;


public class OpenAccountPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel agentIdLabel;
    JLabel accountTypeLabel;
    JComboBox <String> accountTypeComboBox;
    ArrayList<Product> products;
    JLabel interestRateLabel;
    JTextField interestRateTextField;
    JLabel amountLimitLabel;
    JTextField amountLimitTextField;
    JLabel quantityLimitLabel;
    JTextField quantityLimitTextField;
    JLabel minimumBalanceLabel;
    JTextField minimumBalanceTextField;
    JButton cancelOpenAccountButton;
    JButton openAccountButton;
    JLabel messageLabel;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    ZoneId defaultZoneId;
    Agent bankAgent;
    Customer bankCustomer;
    Account newAccount;
    Return result;
    MainFrame mainFrame;
    public OpenAccountPanel(Customer bankCustomer, MainFrame mainFrame) {
        super(); // Initializes a JPanel class instance
        this.bankCustomer = bankCustomer;
        this.mainFrame = mainFrame;
        this.bankAgent = mainFrame.bankAgent;
        defaultZoneId = ZoneId.systemDefault();
        this.setLayout(null);
        this.setBackground(LIGHT_CYAN); // Change the panel background color
        getAccountTypeLabel();
        getAccountTypeComboBox();
        getAgentIdLabel();
        getMinimumBalanceLabel();
        getMinimumBalanceTextField();
        getInterestRateLabel();
        getInterestRateTextField();
        getAmountLimitLabel();
        getAmountLimitTextField();
        getQuantityLimitLabel();
        getQuantityLimitTextField();
        getMessageLabel();
        getCancelUpdateButton();
        getOpenAccountButton();
    }

    /* Initialize the Customer Panel components */
    private void getAgentIdLabel() {
        agentIdLabel = new JLabel(bankAgent.getFullName());
        agentIdLabel.setBounds(700,0,200,30);
        agentIdLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(agentIdLabel,null);
    }

    private void getAccountTypeLabel() {
        accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setBounds(100,50,100,30);
        accountTypeLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(accountTypeLabel,null);
    }
    private void getAccountTypeComboBox() {
        products = new ArrayList<>();
        result = new Return();
        String[] accountTypes = Product.getProductsDetail(products, result);
        accountTypeComboBox = new JComboBox<>(accountTypes);
        accountTypeComboBox.setBounds(225,50,200,30);
        this.add(accountTypeComboBox,null);
        accountTypeComboBox.addActionListener(event -> {
            String selectedAccountType = accountTypeComboBox.getSelectedItem().toString();
            for (int index = 0; index < products.size(); index++) {
                if (Objects.equals(selectedAccountType, products.get(index).getProductType())){
                    setAccountType(index);
                    break;
                }
            }
        });
    }
    private void setAccountType(int id) {
        interestRateTextField.setText(
                String.valueOf(products.get(id).getInterestRate())
        );
        amountLimitTextField.setText(
                String.valueOf(products.get(id).getAmountLimit())
        );
        quantityLimitTextField.setText(
                String.valueOf(products.get(id).getQuantityLimit())
        );
        minimumBalanceTextField.setText(
                String.valueOf(products.get(id).getMinimumBalance())
        );
        revalidate();
        repaint();
    }
    private void getInterestRateLabel() {
        interestRateLabel = new JLabel("Interest Rate");
        interestRateLabel.setBounds(550,50,100,30);
        interestRateLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(interestRateLabel,null);
    }
    private void getInterestRateTextField() {
        double interestRate = products.get(accountTypeComboBox.getSelectedIndex()).getInterestRate();
        interestRateTextField = new JTextField(String.valueOf(interestRate));
        interestRateTextField.setBounds(675,50,200,30);
        this.add(interestRateTextField,null);
    }

    private void getAmountLimitLabel() {
        amountLimitLabel = new JLabel("Amount Limit");
        amountLimitLabel.setBounds(100,100,100,30);
        amountLimitLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(amountLimitLabel,null);
    }
    private void getAmountLimitTextField() {
        double amountLimit = products.get(accountTypeComboBox.getSelectedIndex()).getAmountLimit();
        amountLimitTextField = new JTextField(String.valueOf(amountLimit));
        amountLimitTextField.setBounds(225,100,200,30);
        this.add(amountLimitTextField,null);
    }

    private void getQuantityLimitLabel() {
        quantityLimitLabel = new JLabel("Quantity Limit");
        quantityLimitLabel.setBounds(550,100,100,30);
        quantityLimitLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(quantityLimitLabel,null);
    }
    private void getQuantityLimitTextField() {
        int quantityLimit = products.get(accountTypeComboBox.getSelectedIndex()).getQuantityLimit();
        quantityLimitTextField = new JTextField(String.valueOf(quantityLimit));
        quantityLimitTextField.setBounds(675,100,200,30);
        this.add(quantityLimitTextField,null);
    }

    private void getMinimumBalanceLabel() {
        minimumBalanceLabel = new JLabel("Minimum Balance");
        minimumBalanceLabel.setBounds(100,150,125,30);
        minimumBalanceLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(minimumBalanceLabel,null);
    }
    private void getMinimumBalanceTextField() {
        double minimumBalance = products.get(accountTypeComboBox.getSelectedIndex()).getMinimumBalance();
        minimumBalanceTextField = new JTextField(String.valueOf(minimumBalance));
        minimumBalanceTextField.setBounds(225,150,200,30);
        this.add(minimumBalanceTextField,null);
    }
    private void getMessageLabel() {
        messageLabel = new JLabel("");
        messageLabel.setBounds(100,300,550,30);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setForeground(Color.RED);
        this.add(messageLabel);
    }
    private void getCancelUpdateButton() {
        cancelOpenAccountButton = new JButton("Cancel");
        cancelOpenAccountButton.setBounds(100,250,200,30);
        this.add(cancelOpenAccountButton, null);
        cancelOpenAccountButton.setFocusable(false);
        // Update action for the button click event
        cancelOpenAccountButton.addActionListener(event -> {
            /* Go back to customer panel */
            mainFrame.getCustomerPanel(bankCustomer);
        });
    }
    private void getOpenAccountButton() {
        openAccountButton = new JButton("Open Account");
        openAccountButton.setBounds(675,250,200,30);
        this.add(openAccountButton, null);
        openAccountButton.setFocusable(false);
        // Update action for the button click event
        openAccountButton.addActionListener(event -> {
            /*  */
            result = new Return();
            newAccount = new Account(
                    products.get(accountTypeComboBox.getSelectedIndex()).getProductType(),
                    products.get(accountTypeComboBox.getSelectedIndex()).getProductId(),
                    0,
                    0,
                    0,
                    bankCustomer.getCustomerId(),
                    Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant())
            );
            bankAgent.openAccount(newAccount, bankAgent, result);
            if(result.getCode().equals("00")) {
                mainFrame.getAccountPanel(newAccount);
            } else {
                messageLabel.setText(result.getMessage());
            }
        });
    }
}
