package org.example;

import java.util.ArrayList;

public class GraphCreationParameters {
    ArrayList<ValueMetric> selectedMetrics;

    GraphOptions graphOption;

    GraphCreationParameters(ArrayList<ValueMetric> selectedMetrics, GraphOptions graphOption) {
        this.selectedMetrics = selectedMetrics;
        this.graphOption = graphOption;
    }
}
