package ui;

import javax.swing.*;
import java.awt.*;


public class OpenAccountPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel agentIdLabel;
    JLabel accountTypeLabel;
    JComboBox <String> accountTypeComboBox;
    JLabel interestRateLabel;
    JTextField interestRateTextField;
    JLabel amountLimitLabel;
    JTextField amountLimitTextField;
    JLabel quantityLimitLabel;
    JTextField quantityLimitTextField;
    JLabel minimumBalanceLabel;
    JTextField minimumBalanceTextField;
    JButton openAccountButton;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    public OpenAccountPanel() {
        super(); // Initializes a JPanel class instance
        this.setLayout(null);
        this.setBackground(LIGHT_CYAN); // Change the panel background color
        getAgentIdLabel();
        getMinimumBalanceLabel();
        getMinimumBalanceTextField();
        getAccountTypeLabel();
        getAccountTypeComboBox();
        getInterestRateLabel();
        getInterestRateTextField();
        getAmountLimitLabel();
        getAmountLimitTextField();
        getQuantityLimitLabel();
        getQuantityLimitTextField();
        getOpenAccountButton();
    }

    /* Initialize the Customer Panel components */
    private void getAgentIdLabel() {
        agentIdLabel = new JLabel("@AgentID");
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
        String[] accountTypes = {"Checking", "Saving", "Investing"};
        accountTypeComboBox = new JComboBox<>(accountTypes);
        accountTypeComboBox.setBounds(225,50,200,30);
        this.add(accountTypeComboBox,null);
    }

    private void getInterestRateLabel() {
        interestRateLabel = new JLabel("Interest Rate");
        interestRateLabel.setBounds(550,50,100,30);
        interestRateLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(interestRateLabel,null);
    }
    private void getInterestRateTextField() {
        interestRateTextField = new JTextField();
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
        amountLimitTextField = new JTextField();
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
        quantityLimitTextField = new JTextField();
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
        minimumBalanceTextField = new JTextField();
        minimumBalanceTextField.setBounds(225,150,200,30);
        this.add(minimumBalanceTextField,null);
    }
    
    private void getOpenAccountButton() {
        openAccountButton = new JButton("Open Account");
        openAccountButton.setBounds(675,250,200,30);
        this.add(openAccountButton, null);
        openAccountButton.setFocusable(false);
        // Update action for the button click event
        openAccountButton.addActionListener(event -> {
            /*  */

        });
    }

}
