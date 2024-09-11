package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphActionsUI {


    public void createGraphActions(JPanel actionsPanel,String startDate,
                                   String endDate) {

        DatasetCodeTransformer datasetCodeTransformer = new DatasetCodeTransformer(
                startDate, endDate
        );
        String contentToCopy = datasetCodeTransformer.getTransformedCode();

        JButton copyButton = new JButton("Copy");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(
                        contentToCopy.replace("<br>", "\n"));
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });

        JTextPane f = new JTextPane();

        f.setContentType("text/html"); // let the text pane know this is what you want
        f.setText("<html><body style='font-size:12px;'>" + contentToCopy +
                "</body></html>"); // showing off

        f.setEditable(false); // as before
        f.setBackground(null); // this is the same as a JLabel
        f.setBorder(null); // remove the border
        JScrollPane scrollPane = new JScrollPane(f);
        scrollPane.setBorder(null); // Remove border if needed
        scrollPane.setVisible(false);
        //scrollPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        // Optional: Set preferred size for the scrollPane
        scrollPane.setPreferredSize(new Dimension(400, 300)); // Adjust width and height as needed


        JButton toggleButton = new JButton("Show/Hide");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setMaximumSize(new Dimension(200,30));
        buttonPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        buttonPanel.add(toggleButton);
        buttonPanel.add(copyButton);
        copyButton.setVisible(false);
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle visibility of the JScrollPane
                scrollPane.setVisible(!scrollPane.isVisible());
                copyButton.setVisible(!copyButton.isVisible());
                // Refresh the panel layout
                actionsPanel.revalidate();
                actionsPanel.repaint();
            }
        });

        actionsPanel.add(buttonPanel);
        actionsPanel.add(scrollPane);


    }
}
