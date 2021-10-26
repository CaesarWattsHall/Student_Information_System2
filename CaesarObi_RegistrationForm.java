/*
*By: Caesar W. & Obina E.
*Class: JAVA 1
*Instructor: Dr.Primo
*Assignment: Group-Project
*Date: 12/05/2018
*Due: 12/06/2018 @9:30AM
*/
//START
package caesarobi_registrationform;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.awt.GridLayout;

@SuppressWarnings("serial")
//Using the annotation @SuppressWarnings("serial") makes the compiler be quiet 
//about a missing serialVersionUID. So yes, you can use that to get rid of the 
//warning message, but a better solution is to make your class not implement 
//Serializable (directly or indirectly) if it's not meant to be serialized.

public class CaesarObi_RegistrationForm extends JFrame implements ActionListener {

    JLabel crwhtitle, crwhIDLabel, crwhNameLabel, crwhGenderLabel, crwhAddressLabel, crwhContactLabel;
    JTextField obiField, obiNameField, obiGenderField, obiAddressField, obiContactField;
    JButton crwhRegisterButton, crwhExitButton;
    JRadioButton obiMale, obiFemale;
    ButtonGroup crwhBtnGroup;
    JPanel obiPanel;
    List<User> list = new ArrayList<>();
    JTable crwhTable;
    String obiGender = "";
// Returns a column class of Object               
    DefaultTableModel crwhModel;
    JScrollPane obiSrcPane;
    Object[][] crwhObjData;
// Defining Constructor               

    CaesarObi_RegistrationForm() {
        setSize(700, 360);
        setLayout(null);
        //Defining Labels                               
        crwhtitle = new JLabel("Registration Form");
        crwhtitle.setBounds(60, 7, 200, 30);
        crwhIDLabel = new JLabel("ID");
        crwhIDLabel.setBounds(30, 50, 60, 30);
        crwhNameLabel = new JLabel("Name");
        crwhNameLabel.setBounds(30, 85, 60, 30);
        crwhGenderLabel = new JLabel("Gender");
        crwhGenderLabel.setBounds(30, 120, 60, 30);
        crwhAddressLabel = new JLabel("Address");
        crwhAddressLabel.setBounds(30, 155, 60, 30);
        crwhContactLabel = new JLabel("Contact");
        crwhContactLabel.setBounds(30, 190, 60, 30);
// Defining ID field                                
        obiField = new JTextField();
        obiField.setBounds(95, 50, 100, 30);
        obiField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    e.consume();

                }
            }

        });
// Defining Name field                                
        obiNameField = new JTextField();
        obiNameField.setBounds(95, 85, 100, 30);

        // Defining Gender Buttons
        obiMale = new JRadioButton("Male");
        obiMale.setBounds(95, 120, 60, 30);
        obiMale.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                obiGender = "Male";
            }

        });

        obiFemale = new JRadioButton("Female");
        obiFemale.setBounds(155, 120, 70, 30);

        obiFemale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obiGender = "Female";
            }

        });
        crwhBtnGroup = new ButtonGroup();
        crwhBtnGroup.add(obiMale);
        crwhBtnGroup.add(obiFemale);
        obiAddressField = new JTextField();
        obiAddressField.setBounds(95, 155, 100, 30);
        obiContactField = new JTextField();
        obiContactField.setBounds(95, 190, 100, 30);
        obiContactField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {

                    e.consume();

                }

            }

        });

        //Defining Exit Button
        crwhExitButton = new JButton("Exit");
        crwhExitButton.setBounds(25, 230, 80, 30);
        crwhExitButton.addActionListener(this);
        //Defining Register Button
        crwhRegisterButton = new JButton("Register");
        crwhRegisterButton.setBounds(110, 230, 100, 30);
        crwhRegisterButton.addActionListener(this);
        // fixing all Label,TextField,Button 
        add(crwhtitle);
        add(crwhIDLabel);
        add(crwhNameLabel);
        add(crwhGenderLabel);
        add(crwhAddressLabel);
        add(crwhContactLabel);
        add(obiField);
        add(obiNameField);
        add(obiMale);
        add(obiFemale);
        add(obiAddressField);
        add(obiContactField);
        add(crwhExitButton);
        add(crwhRegisterButton);
        //Defining Panel
        obiPanel = new JPanel();
        obiPanel.setLayout(new GridLayout());
        obiPanel.setBounds(250, 10, 400, 300);
        obiPanel.setBorder(BorderFactory.createDashedBorder(Color.blue));
        add(obiPanel);
        // Defining Model for table 
        crwhModel = new DefaultTableModel();
        crwhTable = new JTable(crwhModel);
        crwhTable.setEnabled(false);
        // Defining Column Names on model 
        crwhModel.addColumn("ID");
        crwhModel.addColumn("Name");
        crwhModel.addColumn("Gender");
        crwhModel.addColumn("Address");
        crwhModel.addColumn("Contact");
        // Enable Scrolling on table
        obiSrcPane = new JScrollPane(crwhTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        obiPanel.add(obiSrcPane);
        obiPanel.setEnabled(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == crwhExitButton) {
            System.exit(0);

        }

        if (ae.getSource() == crwhRegisterButton) {

            if (obiField.getText().equals("") || obiNameField.getText().equals("")
                    || obiAddressField.getText().equals("") || obiContactField.getText().equals("")
                    || obiGender.equals("")) {
                JOptionPane.showMessageDialog(obiField, "Fields will not be blank");
            } else {
                //Storing records in List 
                list.add(new User(obiField.getText(), obiNameField.getText(), obiGender,
                        obiAddressField.getText(), obiContactField.getText()));
                addRows();
                // using for DialogBox
                JOptionPane.showMessageDialog(this, "Successfully Registered");
                obiField.setText("");
                obiNameField.setText("");
                obiGender = "";
                crwhBtnGroup.clearSelection();
                obiAddressField.setText("");
                obiContactField.setText("");

            }

        }
    }
    //Adding records in List

    public void addRows() {
        Object[] row = null;
        User str = list.get(list.size() - 1);
        String string = str.crwhUID + "," + str.obiNAME + "," + str.crwhGENDER + "," + str.obiADDRESS + ","
                + str.crwhCONTACT;

        row = string.split(",");
        //Adding records in table model                           
        crwhModel.addRow(row);
        obiPanel.revalidate();

    }

    public static void main(String[] args) {
        new CaesarObi_RegistrationForm();

    }
}
//END