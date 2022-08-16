package ui;

import db.*;
import entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Login Window to grant access the user to application
 */
public class LoginFrame extends JFrame {
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;
    private final Color RED_COLOR = new Color(255,0,0);
    // Class properties
    Agent bankAgent;
    Return result;
    MainFrame mainFrame;

    /**
     * Login Window constructor
     * @param mainFrame Main Frame to which it belongs
     */
    LoginFrame(MainFrame mainFrame) {
        super("JBank - Login");
        this.mainFrame = mainFrame;
        bankAgent = mainFrame.bankAgent;  // Pass the reference to the local Agent field
        result = new Return();
        this.setSize(380, 320);
        // Login Frame Components
        JPanel loginPanel = getLoginPanel();
        this.setResizable(false);
        this.setContentPane(loginPanel);
        this.setLocationRelativeTo(loginPanel);
        openDatabaseConnection();
    }

    /**
     * Start the database connection for the application
     */
    private void openDatabaseConnection() {
        try {
            DatabaseConnection.getInstance();
        } catch (Exception ex) {
            messageLabel.setText(result.getMessage());
        }
    }

    /**
     * Create a Login Panel and add it to the Login Frame
     * @return A Login Panel with all its components
     */
    private JPanel getLoginPanel() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setBounds(70,20,240,30);
        loginLabel.setHorizontalAlignment(JLabel.CENTER);
        userTextField = new JTextField();
        userTextField.setBounds(70,50,240,40);
        passwordField = new JPasswordField();
        passwordField.setBounds(70,110,240,40);
        loginButton = new JButton("SIGN IN");
        loginButton.setBounds(70,170,240,40);
        setLoginAction();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                event.getWindow().dispose();
                mainFrame.disposeLoginFrame(LoginFrame.this);
            }
        });
        messageLabel = new JLabel("");
        messageLabel.setBounds(65,220,255,40);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setForeground(RED_COLOR);
        contentPane.add(loginLabel, null);
        contentPane.add(userTextField, null);
        contentPane.add(passwordField, null);
        contentPane.add(loginButton, null);
        contentPane.add(messageLabel, null);
        return contentPane;
    }

    /**
     * Get the password string entered by the user
     * @return Return a password text
     */
    public String getPasswordText(){
        StringBuilder passwordString = new StringBuilder();
        char[] password = passwordField.getPassword();
        for (char passwordChar : password) {
            passwordString.append(passwordChar);
        }
        return passwordString.toString();
    }

    /**
     * Add a click Action Listener to the Login Button
     */
    private void setLoginAction() {
        loginButton.setFocusable(false);
        loginButton.addActionListener(event -> {
            // Login agent
            bankAgent.agentLogin(userTextField.getText(),  getPasswordText(), bankAgent, result);
            switch (result.getCode()) {
                case "00":
                    mainFrame.getSearchPanel();
                    this.dispose();
                    mainFrame.disposeLoginFrame(LoginFrame.this);
                case "01":
                case "02":
                    messageLabel.setText(result.getMessage());
                    break;
                case "99":
                    messageLabel.setText(result.getMessage());
                    break;
                default:
                    messageLabel.setText("Login failed: Unknown error");
                    break;
            }
        });
    }
}
