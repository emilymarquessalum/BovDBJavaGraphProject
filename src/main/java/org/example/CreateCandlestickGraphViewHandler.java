package org.example;

import java.util.ArrayList;
import java.util.List;
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
