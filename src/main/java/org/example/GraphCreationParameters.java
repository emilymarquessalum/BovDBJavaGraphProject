package org.example;

import java.util.ArrayList;

public class GraphCreationParameters {
    ArrayList<ValueMetric> selectedMetrics;

    GraphOptions graphOption;
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
