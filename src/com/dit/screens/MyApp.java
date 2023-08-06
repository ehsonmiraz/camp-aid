package com.dit.screens;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import com.dit.utils.constants;

public class MyApp extends JFrame implements constants{
    public MyApp(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(TITLE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(SWIDTH, SHEIGHT);
		setLocationRelativeTo(null);
		
		add(new AuthScreen(),BorderLayout.CENTER);
        setVisible(true);
        
        
        
    }
    
}