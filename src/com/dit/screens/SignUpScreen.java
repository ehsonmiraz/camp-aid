package com.dit.screens;

import javax.swing.*;

import com.dit.db.DataBase;
import com.dit.models.User;
import com.dit.utils.constants;

import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;  
  
//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class SignUpScreen extends JPanel implements ActionListener  ,constants
{   DataBase db;
    //initialize button, panel, label, and text field  
    JButton b1;  
    JComboBox<String> branchComboBox ;
    JLabel headingLabel, sapIdLabel, rollnoLabel, nameLabel, cgpaLabel, currentSemLabel, totalSemLabel, branchLabel, passLabel; 
    JTextField headingTextField, sapIdTextField, rollnoTextField, nameTextField, cgpaTextField, currentSemTextField, totalSemTextField, passTextField;  
    JPanel headingPanel,sapIdPanel,rollnoPanel,namePanel,cgpaPanel,currentSemPanel,totalSemPanel,branchPanel,passPanel,submitPanel;
      
    //calling constructor  
    SignUpScreen()  
    {   this.db=new DataBase();
    	setLayout(new GridLayout(11,1));     
    	headingLabel=new JLabel();
    	headingLabel.setText("Register");
    	headingLabel.setFont(new Font("Arial", Font.PLAIN, 50));
    	headingPanel=new JPanel();
    	headingPanel.add(headingLabel);
    	
    	

    	sapIdLabel = new JLabel();  
    	sapIdLabel.setText("SAP ID");
    	sapIdLabel.setFont(new Font("Arial", Font.PLAIN, 15));//set label value for textField1    
    	sapIdTextField = new JTextField(15);    //set length of the text  
    	sapIdPanel=new JPanel();
    	sapIdPanel.add(sapIdLabel);
    	sapIdPanel.add(sapIdTextField);
    	
    	rollnoLabel = new JLabel();  
    	rollnoLabel.setText("ROLL NO");
    	rollnoLabel.setFont(new Font("Arial", Font.PLAIN, 15));//set label value for textField1  
    	rollnoTextField = new JTextField(15);    //set length of the text  
    	rollnoPanel=new JPanel();
    	rollnoPanel.add(rollnoLabel);
    	rollnoPanel.add(rollnoTextField);
    	
    	nameLabel = new JLabel();  
    	nameLabel.setText("NAME");
    	nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));//set label value for textField1  
        nameTextField = new JTextField(15);    //set length of the text  
        namePanel=new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        
        cgpaLabel = new JLabel();  
    	cgpaLabel.setText("CGPA");    
    	cgpaLabel.setFont(new Font("Arial", Font.PLAIN, 15));  
    	cgpaTextField = new JTextField(15);   
    	cgpaPanel=new JPanel();
    	cgpaPanel.add(cgpaLabel);
    	cgpaPanel.add(cgpaTextField);
    	
    	currentSemLabel = new JLabel();  
    	currentSemLabel.setText("CURRENT SEM");        
    	currentSemLabel.setFont(new Font("Arial", Font.PLAIN, 15)); 
    	currentSemTextField = new JTextField(15);  
    	currentSemPanel=new JPanel();
    	currentSemPanel.add(currentSemLabel);
    	currentSemPanel.add(currentSemTextField);
    	
    	totalSemLabel = new JLabel();  
    	totalSemLabel.setText("TOTAL SEMS");     
    	totalSemLabel.setFont(new Font("Arial", Font.PLAIN, 15));
    	totalSemTextField = new JTextField(15);   
    	totalSemPanel=new JPanel();
    	totalSemPanel.add(totalSemLabel);
    	totalSemPanel.add(totalSemTextField);
    	
    	branchLabel = new JLabel();  
    	branchLabel.setText("BRANCH");
    	branchLabel.setFont(new Font("Arial", Font.PLAIN, 15));//set label value for textField1    
    	  

        // Create a JComboBox with the choices array
        branchComboBox = new JComboBox<>(branchChoices);      

        // Add an ActionListener to the JComboBox
        branchComboBox.addActionListener(null);
        
        branchPanel=new JPanel();
    	branchPanel.add(branchLabel);
    	branchPanel.add(branchComboBox);
    	

    	
    	passLabel = new JLabel();  
        passLabel.setText("PASSWORD");     
        passLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        passTextField = new JPasswordField(15);  
        passPanel=new JPanel();
        passPanel.add(passLabel);
        passPanel.add(passTextField);
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
        b1.setFont(new Font("Arial", Font.PLAIN, 15));
        submitPanel=new JPanel();
        submitPanel.add(b1);
    	
        
        add(headingPanel);
        add(sapIdPanel);
        add(rollnoPanel);
        add(namePanel);
        add(cgpaPanel);
        add(currentSemPanel);
        add(totalSemPanel);    
        add(branchPanel);
        add(passPanel);
        add(submitPanel);  
          
         
        b1.addActionListener(this);
          
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
    	String sapIdValue=sapIdTextField.getText();
    	String rollnoValue=rollnoTextField.getText();
    	String nameValue=nameTextField.getText();
    	double cgpaValue=Double.parseDouble(cgpaTextField.getText());
    	int currentSemValue=Integer.parseInt(currentSemTextField.getText());
    	int totalSemValue=Integer.parseInt(totalSemTextField.getText());
    	String branchValue=branchComboBox.getSelectedItem().toString();
    	String passValue=passTextField.getText();
    	
    	User currentUser=db.addUser(sapIdValue, rollnoValue,nameValue,cgpaValue,currentSemValue, totalSemValue, branchValue,passValue);
    	
    	//db.addUser("1000015166","200102529","Ehson",7.82,7,8,"BT-CSE","G13pics007@");;
        //check whether the credentials are authentic or not  
        if (currentUser!=null) {  //if authentic, navigate user to a new page  
        	 
             System.out.println("logged in as:"); 
             System.out.println(currentUser); 
            
        }  
        else{  
            //show error message  
            System.out.println("Please enter valid username and password");  
        }  
    }  
}  
