package org.example;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

public class BovDataset {


    private DefaultCategoryDataset dataset;
    private List<String[]> rows;

    BovDataset(List<ValueMetric> valueMetrics) {

        /**/
        DatabaseQuery query = new DatabaseQuery();
        rows = query.getData();

        dataset = new DefaultCategoryDataset();

        for (String[] row : rows) {
            for (ValueMetric valueMetric : valueMetrics) {

                dataset.addValue(getMetricValue(row, valueMetric.name),
                        valueMetric.name, row[1]);
            }
        }
/*        dataset.addValue(1, "Series 1", "1");
        dataset.addValue(3, "Series 1", "2");
        dataset.addValue(2, "Series 1", "3");
        dataset.addValue(5, "Series 1", "4");
        dataset.addValue(4, "Series 1", "5");*/
    }

    private double getMetricValue(String[] row, String metric) {
        switch (metric) {
            case "open":
                return Double.parseDouble(row[2]);
            case "high":
                return Double.parseDouble(row[3]);
            case "low":
                return Double.parseDouble(row[4]);
            case "close":
                return Double.parseDouble(row[5]);
            default:
                return 0;
        }
    }

    public DefaultCategoryDataset getDataset() {
        return dataset;
    }
}
