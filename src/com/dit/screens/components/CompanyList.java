package com.dit.screens.components;
 import javax.swing.*;

import com.dit.db.DataBase;
import com.dit.models.Company;
import com.dit.models.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyList  extends JPanel{
	
        public CompanyList(User user,DataBase db){
            
            List<Company> companyCards = db.getCompanies(user);
            JList<Company> list = new JList<>(companyCards.toArray(new Company[0]));
            list.setCellRenderer(new PanelTemplateRenderer());

            JScrollPane scrollPane = new JScrollPane(list);
            this.add(scrollPane);
            
        }
        public static void main(String args[]) {
        	JFrame frame = new JFrame("Scrollable List of Panels Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.add(new CompanyList(new User()));
            frame.setSize(720, 480);
            frame.setVisible(true);
        }
    }




class PanelTemplateRenderer implements ListCellRenderer<Company> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Company> list, Company company, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        
        return new CompanyCard(company);
    }
}
