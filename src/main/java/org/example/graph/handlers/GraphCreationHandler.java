package org.example.graph.handlers;

import org.example.ValueMetric;

import java.util.ArrayList;
import java.util.function.Consumer;

public interface GraphCreationHandler {


    void createGraph(ArrayList<ValueMetric> metrics, Consumer<GraphCreationParameters> callback,
                     String startDate, String endDate);

    String getHandlerName();
}
