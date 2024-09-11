package org.example;

import javax.swing.*;

public class DatePeriodInputs {

    private final JTextField startDateField;
    private final JTextField endDateField;
    DatePeriodInputs() {
        startDateField = new JTextField(10); // 10 columns width
        endDateField = new JTextField(10);
    }
    public void createInputs(JPanel parentPanel) {
        JLabel labelStartDate = new JLabel("Start Date (yyyy-MM-dd):");

        JLabel labelEndDate = new JLabel("End Date (yyyy-MM-dd):");


        // Create a submit button

        // Add components to the parentPanel
        parentPanel.add(labelStartDate);
        parentPanel.add(startDateField);
        parentPanel.add(labelEndDate);
        parentPanel.add(endDateField);
    }


    public String getFirstDate() {
        return startDateField.getText();
    }

    public String getLastDate() {
        return endDateField.getText();
    }
}
