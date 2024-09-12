package org.example.graph.handlers;

import org.example.dashboard.DatePeriodInputs;
import org.example.ValueMetric;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;

public class GraphSelectOptionsPopup implements GraphCreationHandler {


    public void createGraph(ArrayList<ValueMetric> metrics, Consumer<GraphCreationParameters> callback,
                            String startDate, String endDate) {
        // Create the JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Popup Window");
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null); // Center the popup

        dialog.setLayout(new BoxLayout(dialog, BoxLayout.Y_AXIS));

        // Add some components to the dialog
        JLabel label = new JLabel("Select Graph Option");

        // Add components to the dialog
        dialog.setLayout(new FlowLayout());
        dialog.add(label);
        JPanel panel = new JPanel();
        dialog.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        DatePeriodInputs datePeriodInputs =
        new DatePeriodInputs();

        datePeriodInputs.createInputs(panel);

        ArrayList<GraphCreationHandler> handlers = new ArrayList<>();
        handlers.add(new CreateLineGraphViewHandler());
        handlers.add(new CreateCandlestickGraphViewHandler());


        JPanel buttonPanel = new JPanel();
        dialog.add(buttonPanel);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        for(GraphCreationHandler handler : handlers) {
            JButton submitButton = new JButton(handler.getHandlerName());
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    handler.createGraph(metrics, callback,
                            datePeriodInputs.getFirstDate(), datePeriodInputs.getLastDate());
                    dialog.dispose();
                }
            });

            buttonPanel.add(submitButton);
        }

        dialog.setVisible(true); // Show the dialog
    }

    @Override
    public String getHandlerName() {
        return "Selection";
    }
}
