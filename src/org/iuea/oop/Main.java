package org.iuea.oop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.iuea.oop.modal.Students;
import org.iuea.oop.views.LoginView;

public class Main {
    public static void main(String[] args) {
            //Students s = new Students();
        LoginView lv = new LoginView();
        Students s;
        lv.login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = lv.userName.getText();
                String password = lv.password.getText();
                
                if(username.trim().equals("admin") && password.trim().equals("admin")) {
                    JOptionPane.showMessageDialog(null, "User logged in successfully");
                    lv.userName.setText("");
                    lv.password.setText("");
                    Students s = new Students();
                    lv.dispose();
                    s.item5.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        lv.setVisible(true);
                        s.setVisible(false);
                    }
        
        
                    });
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Username and password do not match");
                    lv.userName.setText("");
                    lv.password.setText("");
                }
            }  
        });
        
    }
}
