package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class GraphSelectOptionsPopup implements GraphCreationHandler {


    public void createGraph(List<ValueMetric> metrics, Consumer<GraphCreationParameters> callback) {
        // Create the JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Popup Window");
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null); // Center the popup

        // Add some components to the dialog
        JLabel label = new JLabel("Select Graph Option");

        // Add components to the dialog
        dialog.setLayout(new FlowLayout());
        dialog.add(label);

        ArrayList<GraphCreationHandler> handlers = new ArrayList<>();
        handlers.add(new CreateLineGraphViewHandler());
        handlers.add(new CreateCandlestickGraphViewHandler());

        for(GraphCreationHandler handler : handlers) {
            JButton submitButton = new JButton(handler.getHandlerName());
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handler.createGraph(metrics, callback);
                    dialog.dispose();
                }
            });

            dialog.add(submitButton);
        }

        dialog.setVisible(true); // Show the dialog
    }

    @Override
    public String getHandlerName() {
        return "Selection";
    }
}
