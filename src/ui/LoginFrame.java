package ui;

import entity.*;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;


public class LoginFrame extends JFrame {
    // Login Frame Components
    private JPanel loginPanel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;
    private final Color RED_COLOR = new Color(255,0,0);
    // Class properties
    Agent bankAgent;
    MainFrame mainFrame;

    LoginFrame(MainFrame mainFrame) {
        super("JBank - Login");
        this.mainFrame = mainFrame;
        bankAgent = mainFrame.bankAgent;  // Pass the reference to the local Agent field
        this.setSize(380, 320);
        loginPanel = getLoginPanel();
        this.setResizable(false);
        this.setContentPane(loginPanel);
        this.setLocationRelativeTo(loginPanel);
    }

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

    public String getPasswordText(){
        StringBuilder passwordString = new StringBuilder();
        char[] password = passwordField.getPassword();
        for (char passwordChar : password) {
            passwordString.append(passwordChar);
        }
        return passwordString.toString();
    }
    private void setLoginAction() {
        loginButton.setFocusable(false);
        loginButton.addActionListener(event -> {
            // Login agent
            int status = bankAgent.agentLogin(userTextField.getText(),  getPasswordText(), bankAgent);
            switch (status) {
                case 0:
                    mainFrame.getSearchPanel();
                    this.dispose();
                case 1:
                case 2:
                    messageLabel.setText("Login failed: Invalid username or password");
                    break;
                case 99:
                    messageLabel.setText("Login failed: Database error");
                    break;
                default:
                    messageLabel.setText("Login failed: Unknown error");
                    break;
            }
        });
    }
}
