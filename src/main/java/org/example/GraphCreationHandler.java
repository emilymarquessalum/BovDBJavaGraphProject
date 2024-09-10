package org.example;

import java.util.List;
import java.util.function.Consumer;

interface GraphCreationHandler {


    void createGraph(List<ValueMetric> metrics, Consumer<GraphCreationParameters> callback);

    String getHandlerName();
}
