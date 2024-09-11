package org.example.graph.ui;

import org.example.BovDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CandlestickGraphUI extends GraphUI {
    @Override
    public void createGraph(JPanel parentPanel, BovDataset dataset) throws ParseException {
        // Create the line chart

        System.out.println("createGraph");
        DefaultCategoryDataset datasetData = dataset.getDataset();

        ArrayList<OHLCDataItem> dataItems = new ArrayList<>();
        System.out.println(datasetData.getRowCount());
        System.out.println(datasetData.getColumnCount());
        System.out.println(datasetData.getRowKeys());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

       for(int columnIndex=0; columnIndex < datasetData.getColumnCount(); columnIndex++) {

           String columnKey = (String) datasetData.getColumnKey(columnIndex);
           Date columnDate = formatter.parse(columnKey);



           Number open = datasetData.getValue("open",columnKey);
           Number high = datasetData.getValue("high",columnKey);
            Number low = datasetData.getValue("low",columnKey);
            Number close = datasetData.getValue("close", columnKey);
            OHLCDataItem item = new  OHLCDataItem(
                    columnDate,
                    (Double) open, (Double) high, (Double) low, (Double) close,1
            );
            dataItems.add(item);
        }
       /**/
        OHLCDataItem[] dataItemsArray = dataItems.toArray(new OHLCDataItem[0]);


        DefaultOHLCDataset candlestickDataset = new DefaultOHLCDataset("Dados",
                dataItemsArray
        );
        JFreeChart lineChart = ChartFactory.createCandlestickChart(
                "Daily Chart", // Chart title
                "Date",     // X-Axis label
                "Price",     // Y-Axis label
                candlestickDataset, true     // Dataset
        );

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension(600, 300));
        parentPanel.add(chartPanel);
    }
}
