package org.example.graph.ui;

import org.example.BovDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

public abstract class GraphUI {

    public abstract void createGraph(JPanel parentPanel, BovDataset dataset);
}
