package com.dit.screens;

import javax.swing.*;

import com.dit.models.User;
import com.dit.screens.components.CompanyList;
import com.dit.db.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JPanel {
     
	public HomeScreen(User user,DataBase db){
		// Create a welcome label
        JLabel welcomeLabel = new JLabel("Welcome to the Camp-Aid!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        // Add components to the panel
        add(welcomeLabel, BorderLayout.CENTER);
        add(new CompanyList(user,db));
        setVisible(true);
	}
	
}
