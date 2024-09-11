package org.example.graph.ui;

import org.example.BovDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

//Classe abstrata
public abstract class GraphUI {

    // Metodo abstrato -> so tem assinatura
    abstract public void createGraph(JPanel parentPanel, BovDataset dataset) throws ParseException;


}
