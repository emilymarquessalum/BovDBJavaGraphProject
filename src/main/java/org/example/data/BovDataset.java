package org.example.data;
import org.jfree.data.category.DefaultCategoryDataset;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BovDataset {


    private DefaultCategoryDataset dataset;
    private List<String[]> rows;

    public BovDataset(List<ValueMetric> valueMetrics, String startDate, String endDate) throws ParseException {

        /**/
        DatabaseQuery query = new DatabaseQuery();
        rows = query.getData();

        dataset = new DefaultCategoryDataset();

        for (String[] row : rows) {

            String dateString = row[1];


            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            Date dateFromString = formatter.parse(dateString);

            if(!startDate.isEmpty()) {

                Date startFromDate = formatter.parse(startDate);

                if(dateFromString.before(startFromDate))  {
                    continue;
                }
            }
            if(!endDate.isEmpty()) {

                Date endInDate = formatter.parse(endDate);
                if(dateFromString.after(endInDate)) {
                    continue;
                }
            }



            for (ValueMetric valueMetric : valueMetrics) {


                dataset.addValue(getMetricValue(row, valueMetric.name),
                        valueMetric.name, dateString);
            }
        }
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
