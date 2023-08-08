package com.dit.screens.components;

import com.dit.models.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompanyCard extends JPanel {
    private JLabel companyNameLabel;
    private JLabel ctcLabel;
    private JLabel jobTypeLabel;
    private JLabel locationLabel;
    private JLabel branchLabel;  // New component
    private JLabel eligibilityLabel;
    private JButton applyNowButton;

    public CompanyCard(Company company) {
        String branch="";
        for( String s: company.branches) branch+=s+",";
    	setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Create a round border
        Border roundedBorder = BorderFactory.createLineBorder(new Color(52, 152, 219), 2, true);
        setBorder(BorderFactory.createCompoundBorder(
                roundedBorder,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        )); 
        JPanel infoPanel = new JPanel(new GridLayout(6, 2, 10, 5));  // Updated to 6 rows
        infoPanel.setBackground(Color.WHITE);

        JLabel companyNameTitle = new JLabel("Company:");
        companyNameTitle.setForeground(new Color(44, 62, 80));
        companyNameLabel = new JLabel(company.name);
        JLabel ctcTitle = new JLabel("CTC:");
        ctcTitle.setForeground(new Color(44, 62, 80));
        ctcLabel = new JLabel(Integer.toString(company.ctc));
        JLabel jobTypeTitle = new JLabel("Job Type:");
        jobTypeTitle.setForeground(new Color(44, 62, 80));
        jobTypeLabel = new JLabel(company.jobType);
        JLabel locationTitle = new JLabel("Location:");
        locationTitle.setForeground(new Color(44, 62, 80));
        locationLabel = new JLabel(company.location);
        JLabel branchTitle = new JLabel("Branch:");  // New title
        branchTitle.setForeground(new Color(44, 62, 80));
        branchLabel = new JLabel(branch);  // New component
        JLabel eligibilityTitle = new JLabel("Eligibility:");
        eligibilityTitle.setForeground(new Color(44, 62, 80));
        eligibilityLabel = new JLabel(Double.toString(company.eligibility));

        infoPanel.add(companyNameTitle);
        infoPanel.add(companyNameLabel);
        infoPanel.add(ctcTitle);
        infoPanel.add(ctcLabel);
        infoPanel.add(jobTypeTitle);
        infoPanel.add(jobTypeLabel);
        infoPanel.add(locationTitle);
        infoPanel.add(locationLabel);
        infoPanel.add(branchTitle);
        infoPanel.add(branchLabel);  // New component
        infoPanel.add(eligibilityTitle);
        infoPanel.add(eligibilityLabel);

        applyNowButton = new JButton("Apply Now");
        applyNowButton.setFont(new Font("Arial", Font.BOLD, 14));
        applyNowButton.setBackground(new Color(52, 152, 219));
        applyNowButton.setForeground(Color.WHITE);
        applyNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Application submitted!");
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(applyNowButton);
        buttonPanel.setBackground(new Color(240, 240, 240));

        add(infoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Job Card");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);  // Updated height for the additional component
        
        String companyName = "Example Corp";
        int ctc = 8000000;
        String jobType = "Full-time";
        String location = "City, State";
        String branches[] = {"BT-CSE","MCA","BCA"};  // New branch information
        double eligibility = 70;

        Company company = new Company(companyName, jobType, location,ctc, eligibility,branches);
        CompanyCard jobCardPanel = new CompanyCard(company);
        
        frame.add(jobCardPanel);

        frame.setVisible(true);
    }
}
