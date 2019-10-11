package org.iuea.oop.modal;

import com.sun.glass.events.KeyEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.iuea.oop.Main;
import org.iuea.oop.views.LoginView;

public class Students extends JFrame {
   //Creating instance variables
   JPanel studentsPanel;
   JButton add;
   JButton edit;
   JButton delete;
   public JMenuItem item5;
   JPanel tablePanel;
   JTable table;
   DefaultTableModel model;
   Object rowData[];
   JPanel studentsDetails;
   JButton submit2;
   JButton submit;
   JButton cancel;
   SimpleDateFormat sdf;
   String dateString;
   //variable getters and setters
    
    //setting Screen size Relative to the window
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
   //Working with the Default constructor
    public Students() {
        //Frame Properties
        super("Students Records");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize((screenWidth + 330) /2, (screenHeight + 350) /2 );
        this.setLocation(screenWidth / 4, screenHeight / 5);
        this.setLayout(new BorderLayout());
        this.setLookAndFeel();
        //creating menu items for action menu
        
        JMenuItem item1 = new JMenuItem("login As:");
        item1.setMnemonic(KeyEvent.VK_A);
        JMenuItem item2 = new JMenuItem("Open Records");
        item2.setMnemonic(KeyEvent.VK_O);
        JMenuItem item3 = new JMenuItem("Save Records");
        item3.setMnemonic(KeyEvent.VK_S);
        JMenuItem item4 = new JMenuItem("Print Records");
        item4.setMnemonic(KeyEvent.VK_P);
        item5 = new JMenuItem("Logout");
        item5.setMnemonic(KeyEvent.VK_L);
        
        
        //creating menu items for Help
        JMenuItem jitem1 = new JMenuItem("Shortcut Keys");
        JMenuItem jitem2 = new JMenuItem("Records");
        //adding items into the Menu
        JMenu action = new JMenu("Action");
        JMenu help = new JMenu("Help");
        //adding items into action
        action.add(item1);
        action.addSeparator();
        action.add(item2);
        action.add(item3);
        action.add(item4);
        action.addSeparator();
        action.add(item5);
        //adding items into help
        help.add(jitem1);
        help.add(jitem2);
        //adding menu into the menu bar
        JMenuBar menus = new JMenuBar();
        menus.add(action);
        menus.add(help);
        //Creating a nav bar 
        JTabbedPane tabs = new JTabbedPane(JTabbedPane.LEFT);
        studentsPanel = new JPanel();
        studentsPanel.setBackground(Color.white);
            //adding items onto the students Panel
            studentsPanel.setLayout(null);
            add = new JButton("Add");
            add.setToolTipText("Click To Enter a Record");
            add.setBackground(Color.green);
            add.setForeground(Color.white);
            add.setBounds(80, 30, 100, 30);
            edit = new JButton("Edit");
            edit.setToolTipText("Click To Edit a Record");
            edit.setBackground(Color.orange);
            edit.setForeground(Color.white);
            edit.setBounds(230, 30, 100, 30);
            delete = new JButton("Delete");
            delete.setToolTipText("Click To Delete a Record");
            delete.setBackground(Color.red);
            delete.setForeground(Color.white);
            delete.setBounds(380, 30, 100, 30);
            
            //creating the form to fill in the students details
            studentsDetails = new JPanel();
            studentsDetails.setLayout(null);
            //creating firstname
            JLabel fNameLabel = new JLabel("First Name");
            fNameLabel.setBounds(50, 15, 100, 40);
            JTextField fName = new JTextField();
            fName.setBounds(120,20,200,30);
            //creating last name
            JLabel lNameLabel = new JLabel("Last Name");
            lNameLabel.setBounds(50, 50, 100, 40);
            JTextField lName = new JTextField();
            lName.setBounds(120,55,200,30);
            //creating gender
            JLabel sexLabel = new JLabel("Sex:");
            sexLabel.setBounds(90, 85, 100, 40);
            String[] options = {"MALE", "FEMALE"};
            JComboBox sex = new JComboBox(options);
            sex.setBounds(120,90,200,30);
            //creating course
            JLabel courseLabel = new JLabel("Course:");
            courseLabel.setBounds(70, 120, 100, 40);
            JTextField course = new JTextField();
            course.setBounds(120,125,200,30);
            //creating dob
            JLabel dobLabel = new JLabel("Date of birth:");
            dobLabel.setBounds(45, 155, 100, 40);
            JDateChooser dob = new JDateChooser();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dob.setBounds(120,160,200,30);
            try {
                dateString = sdf.format(dob.getDate());
            } catch(Exception e) {
                //dateString = sdf.format(dob.getDate());
                System.out.println(e.getMessage());
            }
            //String dateString = sdf.format(dob.getDate());
            //Creating buttons
            submit = new JButton("Submit");
            submit.setBounds(100, 210, 100, 30);
            submit.setBackground(Color.green);
            submit.setForeground(Color.white);
            cancel = new JButton("Cancel");
            cancel.setBounds(260, 210, 100, 30);
            cancel.setBackground(Color.red);
            cancel.setForeground(Color.white);
            //adding components into studentsDetails panel
            studentsDetails.add(fNameLabel);
            studentsDetails.add(fName);
            studentsDetails.add(lNameLabel);
            studentsDetails.add(lName);
            studentsDetails.add(sexLabel);
            studentsDetails.add(sex);
            studentsDetails.add(courseLabel);
            studentsDetails.add(course);
            studentsDetails.add(dobLabel);
            studentsDetails.add(dob);
            //studentsDetails.add(submit);
            studentsDetails.add(cancel);
            studentsDetails.setBounds(70, 100, 550, 300);
            studentsDetails.setBackground(Color.white);
            //panel for the table
            tablePanel = new JPanel();
            tablePanel.setBounds(70,80, 550,300);
            tablePanel.setBackground(Color.white);
            //Creating the table
            table = new JTable();
            Object[] columns = {"First Name", "Last Name", "Sex","Course","Date of birth"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);
            table.setModel(model);
            rowData = new Object[5];
            //scrollPane to hold the table
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(70, 60, 300, 45);
            scrollPane.getViewport().add(table);
            //table.setBackground(Color.white);
            
            //adding components into the students panel
            studentsPanel.add(add);
            studentsPanel.add(edit);
            studentsPanel.add(delete);
            tablePanel.add(scrollPane);
            studentsPanel.add(tablePanel);
            //Event to add components to the table
            add.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    tablePanel.setVisible(false);
                    add.setVisible(false);
                    edit.setVisible(false);
                    delete.setVisible(false);
                    try {
                        studentsDetails.remove(submit2);
                        studentsDetails.add(submit);
                        
                        
                    } catch(Exception ex) {
                        studentsDetails.add(submit);
                        System.out.println("submit2 was not yet added");
                    }
                    
                    fName.setText("First Name");
                    fName.setForeground(Color.lightGray);
                    lName.setText("Last Name");
                    lName.setForeground(Color.lightGray);
                    course.setText("Add course");
                    course.setForeground(Color.lightGray);
                    fName.addFocusListener(new FocusAdapter(){
                        @Override
                        public void focusGained(FocusEvent fe) {
                            fName.setForeground(Color.black);
                            if(fName.getText().equals("First Name")) {
                                fName.setText("");
                            }
                        }
                        
                        @Override
                        public void focusLost(FocusEvent fe) {
                            fName.setForeground(Color.lightGray);
                            if(fName.getText().equals("")) {
                                fName.setText("First Name");
                                //fName.setForeground(Color.lightGray);
                            }
                        }
                    });
                    
                    lName.addFocusListener(new FocusAdapter(){
                        
                        @Override
                        public void focusGained(FocusEvent le) {
                            lName.setForeground(Color.black);
                            if(lName.getText().equals("Last Name")) {
                                lName.setText("");
                            }
                        }
                        
                        @Override
                        public void focusLost(FocusEvent le) {
                            lName.setForeground(Color.lightGray);
                            if(lName.getText().equals("")) {
                                lName.setText("Last Name");
                            }
                        }
                    });
                    
                    course.addFocusListener(new FocusAdapter(){
                    
                        @Override
                        public void focusGained(FocusEvent ce) {
                            course.setForeground(Color.black);
                            if(course.getText().equals("Add course")) {
                                course.setText("");
                            }
                        }
                        
                        @Override
                        public void focusLost(FocusEvent ce) {
                            course.setForeground(Color.lightGray);
                            if(course.getText().equals("")) {
                                course.setText("Add course");
                            }
                        }
                    });
                    
                    studentsDetails.setVisible(true);
                    studentsPanel.add(studentsDetails);
                }
            });
            //adding action listener to the submit button
            submit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(fName.getText().equals("First Name") && lName.getText().equals("Last Name") || sex.getSelectedItem().equals("MALE") && course.getText().equals("Add course")) {
                        JOptionPane.showMessageDialog(null, "Can not add default values, Please fill in the form!");
                        tablePanel.setVisible(false);
                        studentsDetails.setVisible(true);
                        
                    } else {
                        add.setVisible(true);
                        edit.setVisible(true);
                        delete.setVisible(true);
                        rowData[0] = fName.getText();
                        rowData[1] = lName.getText();
                        rowData[2] = sex.getSelectedItem();
                        rowData[3] = course.getText();
                        rowData[4] = dob.getDate();
                        model.addRow(rowData);
                        tablePanel.setVisible(true);
                        studentsDetails.setVisible(false);
                    }  
                }
            });
            
            //adding action listener to the cancel button
            cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(true);
                studentsDetails.setVisible(false);
                add.setVisible(true);
                edit.setVisible(true);
                delete.setVisible(true);
            }
            
            });
            //adding action listener to the edit button
            edit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                    try {
                        add.setVisible(false);
                        edit.setVisible(false);
                        delete.setVisible(false);
                        submit2 = new JButton("Submit");
                        int i = table.getSelectedRow();
                        fName.setText(model.getValueAt(i, 0).toString());
                        lName.setText(model.getValueAt(i, 1).toString());
                        sex.setSelectedItem(model.getValueAt(i, 2).toString());
                        course.setText(model.getValueAt(i, 3).toString());
                        dob.setDate((Date) model.getValueAt(i, 4));
                        
                        tablePanel.setVisible(false);
                        studentsDetails.remove(submit);
                        submit2.setBounds(100, 210, 100, 30);
                        submit2.setBackground(Color.green);
                        studentsDetails.add(submit2);
                        studentsDetails.setVisible(true);
                        studentsPanel.add(studentsDetails);
                    } catch(Exception exd) {
                        System.out.println("No Record selected");
                        JOptionPane.showMessageDialog(null, "Please Select a Record to Edit.");
                        add.setVisible(true);
                        edit.setVisible(true);
                        delete.setVisible(true);
                    }
                    
                    submit2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int i = table.getSelectedRow();
                            if (i >= 0) {
                                add.setVisible(true);
                                edit.setVisible(true);
                                delete.setVisible(true);
                                model.setValueAt(fName.getText(), i, 0);
                                model.setValueAt(lName.getText(), i, 1);
                                model.setValueAt(sex.getSelectedItem(), i, 2);
                                model.setValueAt(course.getText(), i, 3);
                                model.setValueAt(dob.getDate(), i, 4);
                               
                                tablePanel.setVisible(true);
                                studentsDetails.setVisible(false);
                            } else {
                                System.out.println("Can not edit an empty row");
                            } 
                        }
                        
                    });
                }
            });
            //adding actionListener to the delete button
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    tablePanel.setVisible(true);
                    studentsDetails.setVisible(false);
                    if(i >= 0) {
                        model.removeRow(i);
                    } else {
                        System.out.println("Deletion Error");
                        JOptionPane.showMessageDialog(null, "Please Select a Record to Delete.");
                    }
                }   
            });
        //panels to be added to the tabPanel  
        JPanel coursePanel = new JPanel();
        JPanel courseUnitsPanel = new JPanel();
        JPanel lecturersPanel = new JPanel();
        //adding Panels to the tabPanel
        tabs.addTab("Students", studentsPanel);
        tabs.addTab("Course", coursePanel);
        tabs.addTab("Course Units", courseUnitsPanel);
        tabs.addTab("Lecturers", lecturersPanel);
        //creating the footer
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.white);
        JLabel footerLabel = new JLabel("Copy right_Janz 2019");
        footerPanel.add(footerLabel);
        //adding items to frame and showing the frame
        
        this.setJMenuBar(menus);
        this.add(tabs);
        this.add(footerPanel,BorderLayout.SOUTH);
        this.setVisible(true);
        
        
    }
    
    private static void setLookAndFeel() {
       try {
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
       } catch (Exception ex) {
           System.out.println(ex.getMessage());
       } 
    }
}
