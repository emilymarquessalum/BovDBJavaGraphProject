package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

public class GraphUI {

    public void createGraph(JPanel parentPanel) {
        BovDataset dataset = new BovDataset();

        // Create the line chart
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Daily Chart", // Chart title
                "Date",     // X-Axis label
                "Price",     // Y-Axis label
                dataset.getDataset()     // Dataset
        );

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension(600, 300));
        parentPanel.add(chartPanel);
    }
}
