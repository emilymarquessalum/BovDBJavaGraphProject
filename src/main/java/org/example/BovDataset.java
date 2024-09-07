package org.example;
import org.jfree.data.category.DefaultCategoryDataset;

public class BovDataset {

    private DefaultCategoryDataset dataset;

    BovDataset() {
        dataset = new DefaultCategoryDataset();
/**/
        DatabaseQuery query = new DatabaseQuery();

        for(String[] row : query.getData()) {
            dataset.addValue(Double.parseDouble(row[2]), "Series 1", row[1]);
        }
/*        dataset.addValue(1, "Series 1", "1");
        dataset.addValue(3, "Series 1", "2");
        dataset.addValue(2, "Series 1", "3");
        dataset.addValue(5, "Series 1", "4");
        dataset.addValue(4, "Series 1", "5");*/
    }

    public DefaultCategoryDataset getDataset() {
        return dataset;
    }
}
