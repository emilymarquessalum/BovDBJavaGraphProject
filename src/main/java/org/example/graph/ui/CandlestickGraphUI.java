package org.example.graph.ui;

import org.example.BovDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;

import javax.swing.*;
import java.util.ArrayList;

public class CandlestickGraphUI extends GraphUI {
    @Override
    public void createGraph(JPanel parentPanel, BovDataset dataset) {
        // Create the line chart

        DefaultCategoryDataset datasetData = dataset.getDataset();

        ArrayList<OHLCDataItem> dataItems = new ArrayList<>();

        for(int rowIndex=0; rowIndex < datasetData.getRowCount(); rowIndex++) {

            Number high = datasetData.getValue(rowIndex, 2);

            OHLCDataItem item = new OHLCDataItem(
                    row
            );
        }

        DefaultOHLCDataset candlestickDataset = new DefaultOHLCDataset(
                ,
                dataItems
        );
        JFreeChart lineChart = ChartFactory.createCandlestickChart(
                "Daily Chart", // Chart title
                "Date",     // X-Axis label
                "Price",     // Y-Axis label
                dataset.getDataset()     // Dataset
        );
    }
}
