package org.example.graph.handlers;

import org.example.graph.GraphOptions;
import org.example.data.ValueMetric;

import java.util.ArrayList;
import java.util.function.Consumer;

public class CreateCandlestickGraphViewHandler implements GraphCreationHandler {
    @Override
    public void createGraph(ArrayList<ValueMetric> metrics, Consumer<GraphCreationParameters> callback,
                            String startDate, String endDate) {


        callback.accept(new GraphCreationParameters(
                metrics,
                GraphOptions.CANDLESTICK,
                startDate,endDate, true
        ));
    }

    @Override
    public String getHandlerName() {
        return "Candlestick";
    }


}
