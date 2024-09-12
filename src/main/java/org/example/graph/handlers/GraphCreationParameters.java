package org.example.graph.handlers;

import org.example.graph.GraphOptions;
import org.example.data.ValueMetric;

import java.util.ArrayList;

public class GraphCreationParameters {
    public ArrayList<ValueMetric> selectedMetrics;

    public GraphOptions graphOption;
    public String startDate;
    public String endDate;
    public boolean usesActions;
    GraphCreationParameters(ArrayList<ValueMetric> selectedMetrics, GraphOptions graphOption,
                            String startDate, String endDate, boolean usesActions) {
        this.selectedMetrics = selectedMetrics;
        this.graphOption = graphOption;
        this.startDate = startDate;
        this.endDate = endDate;
        this.usesActions = usesActions;
    }
}
