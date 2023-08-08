package com.dit.screens;
import com.dit.db.*;
import com.dit.models.User;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;  
  
//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class LoginScreen extends JPanel implements ActionListener  
{  
	DataBase db;
    //initialize button, panel, label, and text field  
    JButton b1;  
  
    JLabel  headingLabel, sapIdLabel, passLabel;  
    final JTextField  sapIdField, passwordField;  
    JPanel headingPanel, sapIdPanel,passPanel,submitPanel;
      
    //calling constructor  
    LoginScreen()  
    {   db=new DataBase();
    	setLayout(new GridLayout(4,1));     
    	headingLabel=new JLabel();
    	headingLabel.setText("LOGIN");
    	headingLabel.setFont(new Font("Arial", Font.PLAIN, 50));
    	headingPanel=new JPanel();
    	headingPanel.add(headingLabel);
    	
        //create label for username   
        sapIdLabel = new JLabel();  
        sapIdLabel.setText("Sap ID:");
        sapIdLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        //create text field to get username from the user  
        sapIdField = new JTextField(25);    //set length of the text  
        sapIdPanel=new JPanel();
        sapIdPanel.add(sapIdLabel);
        sapIdPanel.add(sapIdField);
        
        //create label for password  
        passLabel = new JLabel();  
        passLabel.setText("Password");      //set label value for textField2  
        passLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        //create text field to get password from the user  
        passwordField = new JPasswordField(15);    //set length for the password  
        passPanel=new JPanel();
        passPanel.add(passLabel);
        passPanel.add(passwordField);  
    	
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        submitPanel=new JPanel();
        submitPanel.add(b1);
    	
        //create panel to put form elements  
        add(headingPanel);
        add(sapIdPanel);    //set username label to panel  
        add(passPanel);   //set text field to panel  
        add(submitPanel);  
          
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button  
         //set title to the login form  
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
        String sapValue = sapIdField.getText();        //get user entered username from the textField1  
        String passValue = passwordField.getText();        //get user entered password from the textField2  
        User user= db.getUser(sapValue,passValue);        //check whether the credentials are authentic or not  
        if (user!=null) {  
             System.out.println("logged in as"); 
             System.out.println(user);
             this.removeAll();
             this.add(new HomeScreen(user,this.db));
        }  
        else{  
            //show error message  
            System.out.println("Please enter valid username and password");  
        }  
    }  
}  
