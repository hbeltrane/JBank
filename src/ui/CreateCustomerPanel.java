package ui;

import javax.swing.*;
import java.awt.*;


public class CreateCustomerPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel agentIdLabel;
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
    JLabel customerPinLabel;
    JTextField customerPinTextField;
    JButton createCustomerButton;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    public CreateCustomerPanel() {
        super(); // Initializes a JPanel class instance
        this.setLayout(null);
        this.setBackground(LIGHT_CYAN); // Change the panel background color
        getAgentIdLabel();
        getCustomerPinLabel();
        getCustomerPinTextField();
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
        getCreateCustomerButton();
    }

    /* Initialize the Customer Panel components */
    private void getAgentIdLabel() {
        agentIdLabel = new JLabel("@AgentID");
        agentIdLabel.setBounds(700,0,200,30);
        agentIdLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(agentIdLabel,null);
    }

    private void getCustomerFirstNameLabel() {
        customerFirstNameLabel = new JLabel("First Name");
        customerFirstNameLabel.setBounds(100,50,75,30);
        customerFirstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerFirstNameLabel,null);
    }
    private void getCustomerFirstNameTextField() {
        customerFirstNameTextField = new JTextField();
        customerFirstNameTextField.setBounds(200,50,200,30);
        this.add(customerFirstNameTextField,null);
    }

    private void getCustomerLastNameLabel() {
        customerLastNameLabel = new JLabel("Last Name");
        customerLastNameLabel.setBounds(550,50,100,30);
        customerLastNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerLastNameLabel,null);
    }
    private void getCustomerLastNameTextField() {
        customerLastNameTextField = new JTextField();
        customerLastNameTextField.setBounds(675,50,200,30);
        this.add(customerLastNameTextField,null);
    }

    private void getCustomerAddressLabel() {
        customerAddressLabel = new JLabel("Address");
        customerAddressLabel.setBounds(100,100,75,30);
        customerAddressLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerAddressLabel,null);
    }
    private void getCustomerAddressTextField() {
        customerAddressTextField = new JTextField();
        customerAddressTextField.setBounds(200,100,200,30);
        this.add(customerAddressTextField,null);
    }

    private void getCustomerPhoneNumberLabel() {
        customerPhoneNumberLabel = new JLabel("Phone Number");
        customerPhoneNumberLabel.setBounds(550,100,100,30);
        customerPhoneNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerPhoneNumberLabel,null);
    }
    private void getCustomerPhoneNumberTextField() {
        customerPhoneNumberTextField = new JTextField();
        customerPhoneNumberTextField.setBounds(675,100,200,30);
        this.add(customerPhoneNumberTextField,null);
    }

    private void getCustomerEmailLabel() {
        customerEmailLabel = new JLabel("Email Address");
        customerEmailLabel.setBounds(100,150,100,30);
        customerEmailLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerEmailLabel,null);
    }
    private void getCustomerEmailTextField() {
        customerEmailTextField = new JTextField();
        customerEmailTextField.setBounds(200,150,200,30);
        this.add(customerEmailTextField,null);
    }

    private void getCustomerPinLabel() {
        customerPinLabel = new JLabel("Customer Pin");
        customerPinLabel.setBounds(550,150,100,30);
        customerPinLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerPinLabel,null);
    }
    private void getCustomerPinTextField() {
        customerPinTextField = new JTextField();
        customerPinTextField.setBounds(675,150,200,30);
        this.add(customerPinTextField,null);
    }

    private void getCreateCustomerButton() {
        createCustomerButton = new JButton("Create Customer");
        createCustomerButton.setBounds(675,250,200,30);
        this.add(createCustomerButton, null);
        createCustomerButton.setFocusable(false);
        // Update action for the button click event
        createCustomerButton.addActionListener(event -> {
            /*  */

        });
    }

}
