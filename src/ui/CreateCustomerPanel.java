package ui;

import entity.*;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;
import java.util.regex.*;


/**
 * Panel to create a new bank customer
 */
public class CreateCustomerPanel extends JPanel {
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
    JButton cancelCreateCustomerButton;
    JButton createCustomerButton;
    JLabel messageLabel;
    final Color LIGHT_CYAN = new Color(224, 240, 255);  // Creates a color based on an RGB code
    ZoneId defaultZoneId;
    Customer newCustomer;
    Agent bankAgent;
    Return result;
    MainFrame mainFrame;

    /**
     * Create Customer Panel constructor
     * @param mainFrame Main Window in which it is attached
     */
    public CreateCustomerPanel(MainFrame mainFrame) {
        super(); // Initializes a JPanel class instance
        this.mainFrame = mainFrame;
        this.bankAgent = mainFrame.bankAgent;
        defaultZoneId = ZoneId.systemDefault();
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
        getCancelCreateCustomerButton();
        getCreateCustomerButton();
    }

    /**
     * Initialize the Customer Panel Label
     */
    private void getPanelLabel() {
        panelLabel = new JLabel("CREATE CUSTOMER");
        panelLabel.setBounds(100,0,200,30);
        panelLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(panelLabel,null);
    }

    /**
     * Initialize the Agent Label
     */
    private void getAgentIdLabel() {
        agentIdLabel = new JLabel(mainFrame.bankAgent.getFullName());
        agentIdLabel.setBounds(700,0,200,30);
        agentIdLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(agentIdLabel,null);
    }

    /**
     * Initialize the Customer First Name Label
     */
    private void getCustomerFirstNameLabel() {
        customerFirstNameLabel = new JLabel("First Name");
        customerFirstNameLabel.setBounds(100,50,75,30);
        customerFirstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerFirstNameLabel,null);
    }

    /**
     * Initialize the Customer First Name Text Field
     */
    private void getCustomerFirstNameTextField() {
        customerFirstNameTextField = new JTextField();
        customerFirstNameTextField.setBounds(200,50,200,30);
        this.add(customerFirstNameTextField,null);
    }

    /**
     * Initialize the Customer Last Name Label
     */
    private void getCustomerLastNameLabel() {
        customerLastNameLabel = new JLabel("Last Name");
        customerLastNameLabel.setBounds(550,50,100,30);
        customerLastNameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerLastNameLabel,null);
    }

    /**
     * Initialize the Customer Last Name Text Field
     */
    private void getCustomerLastNameTextField() {
        customerLastNameTextField = new JTextField();
        customerLastNameTextField.setBounds(675,50,200,30);
        this.add(customerLastNameTextField,null);
    }

    /**
     * Initialize the Customer Address Label
     */
    private void getCustomerAddressLabel() {
        customerAddressLabel = new JLabel("Address");
        customerAddressLabel.setBounds(100,100,75,30);
        customerAddressLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerAddressLabel,null);
    }

    /**
     * Initialize the Customer Address Text Field
     */
    private void getCustomerAddressTextField() {
        customerAddressTextField = new JTextField();
        customerAddressTextField.setBounds(200,100,200,30);
        this.add(customerAddressTextField,null);
    }

    /**
     * Initialize the Customer Phone Number Label
     */
    private void getCustomerPhoneNumberLabel() {
        customerPhoneNumberLabel = new JLabel("Phone Number");
        customerPhoneNumberLabel.setBounds(550,100,100,30);
        customerPhoneNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerPhoneNumberLabel,null);
    }

    /**
     * Initialize the Customer Phone Number Text Field
     */
    private void getCustomerPhoneNumberTextField() {
        customerPhoneNumberTextField = new JTextField();
        customerPhoneNumberTextField.setBounds(675,100,200,30);
        this.add(customerPhoneNumberTextField,null);
    }

    /**
     * Initialize the Customer Email Label
     */
    private void getCustomerEmailLabel() {
        customerEmailLabel = new JLabel("Email Address");
        customerEmailLabel.setBounds(100,150,100,30);
        customerEmailLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerEmailLabel,null);
    }

    /**
     * Initialize the Customer Email Text Field
     */
    private void getCustomerEmailTextField() {
        customerEmailTextField = new JTextField();
        customerEmailTextField.setBounds(200,150,200,30);
        this.add(customerEmailTextField,null);
    }

    /**
     * Initialize the Customer PIN Label
     */
    private void getCustomerPinLabel() {
        customerPinLabel = new JLabel("Customer PIN");
        customerPinLabel.setBounds(550,150,100,30);
        customerPinLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(customerPinLabel,null);
    }

    /**
     * Initialize the Customer PIN Text Field
     */
    private void getCustomerPinTextField() {
        customerPinTextField = new JPasswordField();
        customerPinTextField.setBounds(675,150,200,30);
        this.add(customerPinTextField,null);
    }

    /**
     * Initialize the Window Message Label
     */
    private void getMessageLabel() {
        messageLabel = new JLabel("");
        messageLabel.setBounds(100,250,550,30);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setForeground(Color.RED);
        this.add(messageLabel);
    }
    /**
     * Initialize Cancel Create Customer Button and add it an Event Listener
     */
    private void getCancelCreateCustomerButton() {
        cancelCreateCustomerButton = new JButton("Cancel");
        cancelCreateCustomerButton.setBounds(100,250,200,30);
        this.add(cancelCreateCustomerButton, null);
        cancelCreateCustomerButton.setFocusable(false);
        // Update action for the button click event
        cancelCreateCustomerButton.addActionListener(event -> {
            /* Go back to customer panel */
            mainFrame.getSearchPanel();
        });
    }
    /**
     * Initialize the Create Customer Button and add it an Event Listener
     */
    private void getCreateCustomerButton() {
        createCustomerButton = new JButton("Create Customer");
        createCustomerButton.setBounds(675,250,200,30);
        this.add(createCustomerButton, null);
        createCustomerButton.setFocusable(false);
        // Update action for the button click event
        createCustomerButton.addActionListener(event -> {
            if (isValidData()) {
                result = new Return();
                newCustomer = new Customer(
                        getPinText().trim(),
                        customerFirstNameTextField.getText().trim(),
                        customerLastNameTextField.getText().trim(),
                        customerAddressTextField.getText().trim(),
                        customerPhoneNumberTextField.getText().trim(),
                        customerEmailTextField.getText().trim(),
                        Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant())
                );
                bankAgent.agentCreateCustomer(newCustomer, bankAgent, result);

                if(result.getCode().equals("00")) {
                    customerFirstNameTextField.setText("");
                    customerLastNameTextField.setText("");
                    customerAddressTextField.setText("");
                    customerPhoneNumberTextField.setText("");
                    customerPhoneNumberTextField.setText("");
                    customerEmailTextField.setText("");
                    customerPinTextField.setText("");
                    mainFrame.getCustomerPanel(newCustomer);
                } else {
                    messageLabel.setText(result.getMessage());
                }
            }
        });
    }

    /**
     * Validate the data input from the user
     * @return True if it is valid, false otherwise
     */
    private boolean isValidData() {
        String firstName = customerFirstNameTextField.getText().trim();
        String lastName = customerLastNameTextField.getText().trim();
        String address = customerAddressTextField.getText().trim();
        String phoneNumber = customerPhoneNumberTextField.getText().trim();
        String email = customerEmailTextField.getText().trim();
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
        if (email.length() < 1) {
            messageLabel.setText("Error! Email field cannot be empty.");
            return false;
        }
        if (!isValidEmail(email)) {
            messageLabel.setText("Error! Email field was in an incorrect format.");
            return false;
        }
        if (pin.length() < 1) {
            messageLabel.setText("Error! PIN field cannot be empty.");
            return false;
        }
        if (!isValidPin(pin)) {
            return false;
        }
        messageLabel.setText("");
        return true;
    }

    /**
     * Validate if the Customer Phone Number is in a correct format
     * @param phoneNumberString Customer Phone Number
     * @return True if it is valid, false otherwise
     */
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

    /**
     * Validate if the Customer Email is in a correct format
     * @param email Customer Email
     * @return True if it is valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(
                "[a-zA-Z\\d._-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,4}?$",
                Pattern.CASE_INSENSITIVE
        );
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    /**
     * Extract the string representation from the customer PIN
     * @return The PIN text
     */
    public String getPinText() {
        StringBuilder pinString = new StringBuilder();
        char[] pin = customerPinTextField.getPassword();
        for (char pinChar : pin) {
            pinString.append(pinChar);
        }
        return pinString.toString();
    }

    /**
     * Check if the Customer PIN is valid
     * @param pinString Customer PIN
     * @return True if it is valid, false otherwise
     */
    private boolean isValidPin(String pinString) {
        boolean isValid = false;
        try {
            int pin =  Integer.parseInt(pinString);
            if (pin > 999 && pin < 10000){
                isValid = true;
            } else {
                messageLabel.setText("Error! PIN must be 4 characters");
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Error! PIN was in an incorrect format.");
        }
        return isValid;
    }

}
