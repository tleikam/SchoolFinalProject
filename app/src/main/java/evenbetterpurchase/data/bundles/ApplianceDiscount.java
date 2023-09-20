package evenbetterpurchase.data.bundles;

import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.appliances.Appliance;
import evenbetterpurchase.data.appliances.DishWasher;
import evenbetterpurchase.data.appliances.Dryer;
import evenbetterpurchase.data.appliances.Oven;
import evenbetterpurchase.data.appliances.Refrigerator;
import evenbetterpurchase.data.appliances.Washer;
import java.util.LinkedList;

/**
 * Class for applying discount to appliances.
 */
public class ApplianceDiscount {

    /** 
     * Discount Method.
     *
     *<p>This method checks to see if the requirements are met
     for an appliance discount, and if they are, it updates
     the price of the item in the order to the correct value.
     *
     * @param order Current order
     */
    public static void discount(LinkedList<Item> order) {
        Item temp = null;
        int smallest = 0;
        int count = 0;
        for (int i = 0; i < order.size(); i++) {
            Item item = order.get(i);
            if (item instanceof Appliance) {
                count++;
                if (temp == null) {
                    temp = order.get(i);
                    smallest = i;
                } else {
                    if (temp.getPrice() >= order.get(i).getPrice()) {
                        temp = order.get(i);
                        smallest = i;
                    }
                }
            }
        }

        if (count >= 4) {
            if (order.get(smallest) instanceof DishWasher) {
                DishWasher target = (DishWasher) order.get(smallest);
                target.setPrice("75 percent");
            } else if (order.get(smallest) instanceof Dryer) {
                Dryer target = (Dryer) order.get(smallest);
                target.setPrice("75 percent");
            } else if (order.get(smallest) instanceof Oven) {
                Oven target = (Oven) order.get(smallest);
                target.setPrice("75 percent");
            } else if (order.get(smallest) instanceof Refrigerator) {
                Refrigerator target = (Refrigerator) order.get(smallest);
                target.setPrice("75 percent");
            } else if (order.get(smallest) instanceof Washer) {
                Washer target = (Washer) order.get(smallest);
                target.setPrice("75 percent");
            }
        }
    }
}