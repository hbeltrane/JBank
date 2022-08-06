package ui;

import entity.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class UpdateCustomerPanel extends JPanel {
    /* Screen Resolution 1280x720
    * Screen Width: 1280 pixels
    * Screen Height: 720 pixels */
    JLabel panelLabel;
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
    JPasswordField customerPinTextField;
    JButton cancelUpdateButton;
    JButton updateCustomerButton;
    JLabel messageLabel;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    Customer bankCustomer;
    Return result;
    MainFrame mainFrame;
    public UpdateCustomerPanel(Customer bankCustomer, MainFrame mainFrame) {
        super(); // Initializes a JPanel class instance
        this.bankCustomer = bankCustomer;
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.setBackground(LIGHT_CYAN); // Change the panel background color
        getPanelLabel();
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
        getMessageLabel();
        getCancelUpdateButton();
        getUpdateCustomerButton();
    }

    /* Initialize the Customer Panel components */
    private void getPanelLabel() {
        panelLabel = new JLabel("UPDATE CUSTOMER");
        panelLabel.setBounds(100,0,200,30);
        panelLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(panelLabel,null);
    }
    private void getAgentIdLabel() {
        agentIdLabel = new JLabel(mainFrame.bankAgent.getFullName());
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
        String firstName = bankCustomer.getFirstName();
        customerFirstNameTextField = new JTextField(firstName);
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
        String lastName = bankCustomer.getLastName();
        customerLastNameTextField = new JTextField(lastName);
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
        String address = bankCustomer.getAddress();
        customerAddressTextField = new JTextField(address);
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
        String phoneNumber = bankCustomer.getPhoneNumber();
        customerPhoneNumberTextField = new JTextField(phoneNumber);
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
        String email = bankCustomer.getEmail();
        customerEmailTextField = new JTextField(email);
        customerEmailTextField.setEditable(false);
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
        String pin = bankCustomer.getPin();
        customerPinTextField = new JPasswordField(pin);
        customerPinTextField.setBounds(675,150,200,30);
        this.add(customerPinTextField,null);
    }
    private void getMessageLabel() {
        messageLabel = new JLabel("");
        messageLabel.setBounds(100,200,600,30);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setForeground(Color.RED);
        this.add(messageLabel);
    }
    private void getCancelUpdateButton() {
        cancelUpdateButton = new JButton("Cancel");
        cancelUpdateButton.setBounds(100,250,200,30);
        this.add(cancelUpdateButton, null);
        cancelUpdateButton.setFocusable(false);
        // Update action for the button click event
        cancelUpdateButton.addActionListener(event -> {
            /* Go back to customer panel */
            mainFrame.getCustomerPanel(bankCustomer);

        });
    }
    private void getUpdateCustomerButton() {
        updateCustomerButton = new JButton("Update Customer");
        updateCustomerButton.setBounds(675,250,200,30);
        this.add(updateCustomerButton, null);
        updateCustomerButton.setFocusable(false);
        // Update action for the button click event
        updateCustomerButton.addActionListener(event -> {
            if (isValidData()) {
                result = new Return();
                Customer updatedCustomer = new Customer(
                        bankCustomer.getCustomerId(),
                        getPinText().trim(),
                        customerFirstNameTextField.getText().trim(),
                        customerLastNameTextField.getText().trim(),
                        customerAddressTextField.getText().trim(),
                        customerPhoneNumberTextField.getText().trim(),
                        customerEmailTextField.getText().trim(),
                        new Date()
                );
                updatedCustomer.updateCustomer(updatedCustomer, result);

                if(result.getCode().equals("00")) {
                    JOptionPane.showMessageDialog(
                            mainFrame,
                            "Customer data has been successfully edited and saved",
                            "Update Customer",
                            JOptionPane.INFORMATION_MESSAGE);
                    customerFirstNameTextField.setText("");
                    customerLastNameTextField.setText("");
                    customerAddressTextField.setText("");
                    customerPhoneNumberTextField.setText("");
                    customerPhoneNumberTextField.setText("");
                    customerEmailTextField.setText("");
                    customerPinTextField.setText("");
                    mainFrame.getCustomerPanel(updatedCustomer);
                } else {
                    messageLabel.setText(result.getMessage());
                }
            }
        });
    }

    private boolean isValidData() {
        String firstName = customerFirstNameTextField.getText().trim();
        String lastName = customerLastNameTextField.getText().trim();
        String address = customerAddressTextField.getText().trim();
        String phoneNumber = customerPhoneNumberTextField.getText().trim();
        String pin = getPinText().trim();
        if (firstName.length() < 2) {
            messageLabel.setText("Error! First Name cannot be less than 2 characters.");
            return false;
        }
        if (lastName.length() < 2) {
            messageLabel.setText("Error! Last Name cannot be less than 2 characters.");
            return false;
        }
        if (address.length() < 1) {
            messageLabel.setText("Error! Address field cannot be empty.");
            return false;
        }
        if (phoneNumber.length() < 1) {
            messageLabel.setText("Error! Phone Number field cannot be empty.");
            return false;
        }
        if (!isValidPhoneNumber(phoneNumber)) {
            return false;
        }
        if (pin.length() < 1) {
            messageLabel.setText("Error! Pin number field cannot be empty.");
            return false;
        }
        if (!isValidPin(pin)) {
            return false;
        }
        messageLabel.setText("");
        return true;
    }
    private boolean isValidPhoneNumber(String phoneNumberString) {
        boolean isValid = false;
        try {
            long phoneNumber =  Long.parseLong(phoneNumberString);
            if (phoneNumber > 999999999L && phoneNumber <= 9999999999L) {
                isValid = true;
            } else {
                messageLabel.setText("Error! Phone number must be 10 characters");
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Error! Phone number was in an incorrect format.");
        }
        return isValid;
    }
    public String getPinText() {
        StringBuilder pinString = new StringBuilder();
        char[] pin = customerPinTextField.getPassword();
        for (char pinChar : pin) {
            pinString.append(pinChar);
        }
        return pinString.toString();
    }
    private boolean isValidPin(String pinString) {
        boolean isValid = false;
        try {
            int pin =  Integer.parseInt(pinString);
            if (pin > 999 && pin < 10000){
                isValid = true;
            } else {
                messageLabel.setText("Error! Pin number must be 4 characters");
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Error! Pin number was in an incorrect format.");
        }
        return isValid;
    }
}