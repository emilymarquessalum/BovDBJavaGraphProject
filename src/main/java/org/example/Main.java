package org.example;

import org.example.graph.ui.GraphUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main extends JFrame {

    private JPanel graphPanel;

    public Main() {
        // Set up the main frame
        setTitle("Line Graph App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ArrayList<ValueMetric> valueMetrics = new ArrayList<ValueMetric>(new ArrayList<ValueMetric>() {{
            add(new ValueMetric("open"));
            add(new ValueMetric("high"));
            add(new ValueMetric("low"));
            add(new ValueMetric("close"));
        }});

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
                GraphCreationHandler popup = new GraphSelectOptionsPopup();
                popup.createGraph(valueMetrics, new Consumer<GraphCreationParameters>() {
                    @Override
                    public void accept(GraphCreationParameters selected) {
                        addNewGraph(selected);
                    }
                });
            }
        });
    }

    private void addNewGraph(GraphCreationParameters parameter) {

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
        BovDataset dataset = new BovDataset(parameter.selectedMetrics);

        new GraphUI().createGraph(panel, dataset);
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
