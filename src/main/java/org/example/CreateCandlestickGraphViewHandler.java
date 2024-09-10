package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CreateCandlestickGraphViewHandler implements GraphCreationHandler {
    @Override
    public void createGraph(List<ValueMetric> metrics, Consumer<GraphCreationParameters> callback) {
        callback.accept(new GraphCreationParameters(
                new ArrayList<ValueMetric>(),
                GraphOptions.CANDLESTICK
        ));
    }

    @Override
    public String getHandlerName() {
        return "Candlestick";
    }


}
