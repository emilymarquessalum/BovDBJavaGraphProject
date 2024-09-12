package org.example.graph.ui;

import org.example.data.BovDataset;

import javax.swing.*;
import java.text.ParseException;

//Classe abstrata
public abstract class GraphUI {

    // Metodo abstrato -> so tem assinatura
    abstract public void createGraph(JPanel parentPanel, BovDataset dataset) throws ParseException;


}
