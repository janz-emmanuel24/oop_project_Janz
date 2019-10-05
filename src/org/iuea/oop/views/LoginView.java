package org.iuea.oop.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LoginView extends JFrame {
    //setting global Instance variables
    public JButton cancel;
    public JButton login;
    public JTextField userName;
    public JPasswordField password;
   
    //Getting a particular PC's screen Resolution
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    
    public LoginView() {
        //Frame's properties
        super("Login Form: ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLookAndFeel();
        this.setResizable(true);
        this.setSize(screenWidth/2, screenHeight/2);
        this.setLocation(screenWidth/4, screenHeight/4);
        //Panel properties
        JPanel pane = new JPanel();
        pane.setBackground(Color.GRAY);
        pane.setLayout(null);
        pane.setPreferredSize(new Dimension(200, 100));
        //usernamelabel and textfield propertes
        JLabel userNameLabel = new JLabel("Username:");
        userName = new JTextField();
        userNameLabel.setBounds(200, 104, 100, 15);
        userName.setBounds(265, 95, 250, 30);
        //passwordlabel and passwordfield properties
        JLabel passwordLabel = new JLabel("Password:");
        password = new JPasswordField();
        passwordLabel.setBounds(200,137,100, 15);
        password.setBounds(265,130,250,30);
        //adding Buttons cancel and login
        cancel = new JButton("Cancel");
        login = new JButton("Login");
        cancel.setBounds(280, 180, 80, 30);
        login.setBounds(400, 180, 80, 30);
        //adding components into the panel
        pane.add(userNameLabel);
        pane.add(userName);
        pane.add(passwordLabel);
        pane.add(password);
        pane.add(cancel);
        pane.add(login);
        //adding panel into the frame and showing the frame
        this.add(pane);
        this.setVisible(true);
    }
    
    
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
