package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

interface GraphCreationHandler {


    void createGraph(ArrayList<ValueMetric> metrics, Consumer<GraphCreationParameters> callback,
                     String startDate, String endDate);

    String getHandlerName();
}
