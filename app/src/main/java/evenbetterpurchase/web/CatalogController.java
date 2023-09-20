package evenbetterpurchase.web;

import evenbetterpurchase.data.CartList;
import evenbetterpurchase.data.CatalogFilter;
import evenbetterpurchase.data.Item;
import evenbetterpurchase.data.appliances.Appliance;
import evenbetterpurchase.data.appliances.DishWasher;
import evenbetterpurchase.data.appliances.Dryer;
import evenbetterpurchase.data.appliances.Oven;
import evenbetterpurchase.data.appliances.Refrigerator;
import evenbetterpurchase.data.appliances.Washer;
import evenbetterpurchase.data.catalog.Catalog;
import evenbetterpurchase.data.enums.Color;
import evenbetterpurchase.data.enums.DryerSize;
import evenbetterpurchase.data.hometheater.HomeAudio;
import evenbetterpurchase.data.hometheater.Television;
import evenbetterpurchase.data.order.Order;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for the Spring Framework.
 */
@Controller
public class CatalogController {

    /**
     * Route to Homepage.
     */
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    /**
     * Route to About.
     */
    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    /**
     * Route to All Items.
     */
    @GetMapping("/items")
    public String items(Model model) {
        Catalog cat = new Catalog();
        model.addAttribute("appliances", cat.getAppliances());
        model.addAttribute("home", cat.getHomeTheater());
        return "items";
    }

    /**
     * Route to all Appliances.
     */
    @GetMapping("/appliances")
    public String appliances(Model model) {
        Catalog cat = new Catalog();
        model.addAttribute("appliances", cat.getAppliances());
        return "appliances";
    }

    /**
     * Route to all Home Theater items.
     */
    @GetMapping("/hometheater")
    public String hometheater(Model model) {
        Catalog cat = new Catalog();
        model.addAttribute("home", cat.getHomeTheater());
        return "hometheater";
    }

    /**
     * Route to more page.
     */
    @GetMapping("/more")
    public String more(Model model) {
        return "more";
    }

    /**
     * Route for searching.
     */
    @GetMapping("/search")
    public String search(Model model) {
        return "search";
    }

    /**
     * Post Mapping for search.
     *
     *<p>This Post Mapping uses a list of keywords provided by a form
     to search through all items of the store.
     */
    @PostMapping("/search")
    public String searchResults(
            @RequestParam(name = "text", required = true, defaultValue = " ") String text,
            Model model) {
        model.addAttribute("text", text);
        LinkedList<Item> items = new Catalog().getAllItems();
        items = CatalogFilter.filterKeywords(items, text);
        model.addAttribute("items", items);
        return "search";
    }

    /**
     * Route to cart.
     */
    @GetMapping("/cart")
    public String cart(Model model) {
        CartList c = CartList.getInstance();
        model.addAttribute("items", c);
        Order order = new Order();
        for (int i = 0; i < c.size(); i++) {
            order.addItem(c.get(i));
        }
        model.addAttribute("order", order);
        return "cart";
    }

    /** 
     * New DishWasher Item.
     */
    @GetMapping("/newdishwasher")
    public String newDishWasher(Model model) {
        CartList c = CartList.getInstance();
        DishWasher d = new DishWasher();
        model.addAttribute("cartitem", d);
        model.addAttribute("thirdrack", true);
        return "newdishwasher";
    }

    /** 
     * New Dryer Item.
     */
    @GetMapping("/newdryer")
    public String newDryer(Model model) {
        CartList c = CartList.getInstance();
        Dryer dr = new Dryer();
        model.addAttribute("dryer", dr);
        model.addAttribute("steamer", false);
        model.addAttribute("topload", true);
        return "newdryer";
    }

    /**
     * Post Mapping for dishwasher.
     */
    @PostMapping("/cart")
    public String newDishWasherForm(
            @ModelAttribute("cartitem") DishWasher d,
            @ModelAttribute("dryer") Dryer dr,
            @ModelAttribute("itemname") String itemname,
            @RequestParam(name = "color", required = true, 
                          defaultValue = "STAINLESS_STEEL") String text,
            @RequestParam(name = "thirdrack", 
                          defaultValue = "false") boolean thirdrack,
            @RequestParam(name = "dryersize", required = true, 
                          defaultValue = "SEVENPOINTTHREE") String dryersize,
            @RequestParam(name = "steamer", defaultValue = "false") boolean steamer,
            @RequestParam(name = "topload", defaultValue = "true") boolean topload,
                Model model) {
        model.addAttribute("color", text);
        model.addAttribute("thirdrack", thirdrack);
        
        if (text.equals("STAINLESS_STEEL")) {
            d.setColor(Color.STAINLESS_STEEL);
        } else if (text.equals("BLACK")) {
            d.setColor(Color.BLACK);
        } else if (text.equals("WHITE")) {
            d.setColor(Color.WHITE);
        } else if (text.equals("BLUE")) {
            d.setColor(Color.BLUE);
        }
        d.setThirdRack(thirdrack);
        model.addAttribute("cartitem", d);
        CartList c = CartList.getInstance();
        c.add(d);
        if (itemname.equals("Dryer")) {
            model.addAttribute("color", text);
            model.addAttribute("dryersize", dryersize);
            model.addAttribute("steamer", steamer);
            model.addAttribute("topload", topload);
            //CartList c = CartList.getInstance();
            if (text.equals("STAINLESS_STEEL")) {
                dr.setColor(Color.STAINLESS_STEEL);
            } else if (text.equals("BLACK")) {
                dr.setColor(Color.BLACK);
            } else if (text.equals("WHITE")) {
                dr.setColor(Color.WHITE);
            } else if (text.equals("BLUE")) {
                dr.setColor(Color.BLUE);
            }
            if (text.equals("SIXPOINTSEVEN")) {
                dr.setSize(DryerSize.SIXPOINTSEVEN);
            } else if (text.equals("SEVENPOINTTHREE")) {
                dr.setSize(DryerSize.SEVENPOINTTHREE);
            } else if (text.equals("SEVENPOINTEIGHT")) {
                dr.setSize(DryerSize.SEVENPOINTEIGHT);
            } else if (text.equals("NINEPOINTZERO")) {
                dr.setSize(DryerSize.NINEPOINTZERO);
            }
            dr.setSteamer(steamer);
            dr.setTopLoadDryer(topload);
            model.addAttribute("dryer", dr);
            c.add(dr);
        }
        /*model.addAttribute("color", text);
        model.addAttribute("thirdrack", thirdrack);
        CartList c = CartList.getInstance();
        if (text.equals("STAINLESS_STEEL")) {
            d.setColor(Color.STAINLESS_STEEL);
        } else if (text.equals("BLACK")) {
            d.setColor(Color.BLACK);
        } else if (text.equals("WHITE")) {
            d.setColor(Color.WHITE);
        } else if (text.equals("BLUE")) {
            d.setColor(Color.BLUE);
        }
        d.setThirdRack(thirdrack);
        model.addAttribute("dishwasher", d);
        c.add(d);*/
        return "redirect:/cart";
    }

    /** 
     * Edit DishWasher Item.
     */
    @GetMapping("/cart/{id}/editdishwasher")
    public String editDishWasher(@PathVariable int id,
                Model model) {
        CartList c = CartList.getInstance();
        
        model.addAttribute("cartitem", c.get(id));
        model.addAttribute("id", id);
        return "editdishwasher";
    }

    /**
     * Post Mapping for dishwasher.
     */
    @PostMapping("/cart/{id}")
    public String edititem(@PathVariable int id,
            @ModelAttribute("cartitem") DishWasher d,
            @RequestParam(name = "color", required = true, 
                          defaultValue = "STAINLESS_STEEL") String text,
            @RequestParam(name = "thirdrack", defaultValue = "false") boolean thirdrack,
                Model model) {
        if (d instanceof DishWasher) {
            DishWasher dw = (DishWasher) d;
            model.addAttribute("color", text);
            model.addAttribute("thirdrack", thirdrack);
            
            if (text.equals("STAINLESS_STEEL")) {
                dw.setColor(Color.STAINLESS_STEEL);
            } else if (text.equals("BLACK")) {
                dw.setColor(Color.BLACK);
            } else if (text.equals("WHITE")) {
                dw.setColor(Color.WHITE);
            } else if (text.equals("BLUE")) {
                dw.setColor(Color.BLUE);
            }
            dw.setThirdRack(thirdrack);
            model.addAttribute("cartitem", dw);
            CartList c = CartList.getInstance();
            c.delete(id);
            c.add(dw);
            
        }
        return "redirect:/cart";
    }

    /**
     * Mapping to edit single item.
     */
    @GetMapping("/cart/{id}/edit")
    public String editForm(@PathVariable int id, Model model) {
        CartList c = CartList.getInstance();
        model.addAttribute("cartitem", c.get(id));
        model.addAttribute("id", id);
        return "editform";
    }

    /**
     * Mapping to delete item from cart.
     */
    @GetMapping("/cart/{id}/delete")
    public String deleteForm(@PathVariable int id, Model model) {
        CartList c = CartList.getInstance();
        model.addAttribute("cartitem", c.get(id));
        model.addAttribute("id", id);
        return "deleteform";
    }

    /**
     * Post mapping for confirmation of deletion.
     */
    @PostMapping("/cart/{id}/delete")
    public String delete(@PathVariable int id) {
        CartList c = CartList.getInstance();
        c.delete(id);
        return "redirect:/cart";
    }

    /**
     * Post Mapping for saving cart.
     */
    @PostMapping("/cart/save")
    public String save() {
        CartList c = CartList.getInstance();
        c.save();
        return "redirect:/cart";
    }

    /**
     * Get mapping for checkout.
     */
    @GetMapping("/checkout")
    public String checkout(Model model) {
        CartList c = CartList.getInstance();
        model.addAttribute("items", c);
        Order order = new Order();
        for (int i = 0; i < c.size(); i++) {
            order.addItem(c.get(i));
        }
        model.addAttribute("order", order);
        return "checkout";
    }

    /**
     * Get mapping for orderpickup.
     */
    @GetMapping("/orderpickup")
    public String orderpickup(Model model) {
        CartList c = CartList.getInstance();
        model.addAttribute("items", c);
        Order order = new Order();
        for (int i = 0; i < c.size(); i++) {
            order.addItem(c.get(i));
        }
        model.addAttribute("order", order);
        return "orderpickup";
    }

    /**
     * Get mapping for orderpickupsuccess.
     */
    @GetMapping("/orderpickupsuccess")
    public String orderpickupsuccess(Model model) {
        return "orderpickupsuccess";
    }

    /**
     * Get mapping for delivery.
     */
    @GetMapping("/delivery")
    public String delivery(Model model) {
        CartList c = CartList.getInstance();
        model.addAttribute("items", c);
        Order order = new Order();
        for (int i = 0; i < c.size(); i++) {
            order.addItem(c.get(i));
        }
        model.addAttribute("order", order);
        return "delivery";
    }

    /**
     * Get mapping for deliverysuccess.
     */
    @GetMapping("/deliverysuccess")
    public String deliverysuccess(Model model) {
        return "deliverysuccess";
    }
}