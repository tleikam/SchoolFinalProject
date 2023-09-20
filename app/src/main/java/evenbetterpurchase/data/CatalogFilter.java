package evenbetterpurchase.data;

import evenbetterpurchase.data.appliances.Appliance;
import java.util.LinkedList;

/**
 * Class for Filtering Catalog.
 */
public class CatalogFilter {

    /**
     * KeyWord filter.
     *
     *<p>This method filters through the list by a entered keyword
     *
     * @param items list of items to filter through
     * @param keywords keywords provided by search
     * @return A new linked list of filtered items
     */
    public static LinkedList<Item> filterKeywords(LinkedList<Item> items, String keywords) {
        if (keywords == null || keywords.length() == 0) {
            return items;
        }
        LinkedList<Item> output = new LinkedList<>();
        for (String keyword : keywords.split(" ")) {
            keyword = keyword.toLowerCase();
            for (Item item : items) {
                if (item.toString().toLowerCase().contains(keyword)) {
                    if (!output.contains(item)) {
                        output.add(item);
                    }
                }
                for (String option : item.options()) {
                    if (option.toLowerCase().contains(keyword)) {
                        if (!output.contains(item)) {
                            output.add(item);
                        }
                    }
                }
            }
        }
        return output;
    }
}