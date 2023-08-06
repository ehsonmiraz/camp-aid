package com.dit.screens;

import javax.swing.JPanel;

import com.dit.utils.Enums;
import com.dit.screens.*;
public class AuthScreen extends JPanel  implements Enums{
	MODE mode;
	AuthScreen(){
		mode=MODE.LOGINMODE;
		setAlignmentY(CENTER_ALIGNMENT);
        setAlignmentX(CENTER_ALIGNMENT);
		if(mode==MODE.LOGINMODE) {
			add(new LoginScreen());
		}
		else {
			add(new SignUpScreen());
		}
	}
	
	
}
