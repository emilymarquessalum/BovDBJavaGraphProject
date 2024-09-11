package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CreateLineGraphViewHandler implements GraphCreationHandler {


    public void createGraph(ArrayList<ValueMetric> metrics, Consumer<GraphCreationParameters> callback,
                            String startDate, String endDate) {
        // Create the JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Popup Window");
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null); // Center the popup

        // Add some components to the dialog
        JLabel label = new JLabel("Select relevant metrics!");

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS)); // Arrange checkboxes vertically

        ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
        for (ValueMetric metric : metrics) {
            JCheckBox checkBox = new JCheckBox(metric.name);
            checkBoxes.add(checkBox);
            checkBoxPanel.add(checkBox); // Add checkbox to the panel
        }

        JButton submitButton = new JButton("Confirm");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<ValueMetric> selected = new ArrayList<>();
                for (int i = 0; i < checkBoxes.size(); i++) {
                    JCheckBox checkBox = checkBoxes.get(i);
                    if (checkBox.isSelected()) {
                        selected.add(
                                metrics.get(i)
                        );
                    }
                }
                callback.accept(new GraphCreationParameters(
                        selected, GraphOptions.LINE,
                        startDate,endDate, false
                )); // Pass the selected checkboxes to the callback
                dialog.dispose();
            }
        });
        // Add components to the dialog
        dialog.setLayout(new FlowLayout());
        dialog.add(label);
        dialog.add(submitButton);
        dialog.add(checkBoxPanel);

        dialog.setVisible(true); // Show the dialog
    }

    @Override
    public String getHandlerName() {
        return "Line";
    }


}
