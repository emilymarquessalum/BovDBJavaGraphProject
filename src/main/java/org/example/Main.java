package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JPanel graphPanel;

    public Main() {
        // Set up the main frame
        setTitle("Line Graph App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Button panel with the "+" button
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("+");
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.NORTH);

        // Panel that will contain the graphs
        graphPanel = new JPanel();
        graphPanel.setLayout(new GridLayout(0, 1));  // Stack graphs vertically
        add(new JScrollPane(graphPanel), BorderLayout.CENTER);

        // Add action listener to the "+" button to add new graphs
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewGraph();
            }
        });
    }

    private void addNewGraph() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(new GridLayout(0, 1));  // Stack graphs vertically
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Stack components vertically

        JButton removeButton = new JButton("X");
        panel.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphPanel.remove(panel);
                graphPanel.revalidate();
                graphPanel.repaint();
            }
        });
        new GraphUI().createGraph(panel);
        new GraphActionsUI().createGraphActions(panel);

        graphPanel.add(panel);
        // Refresh the UI to show the new graph
        graphPanel.revalidate();
        graphPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }
}
