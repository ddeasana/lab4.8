package restaurant.service;

import restaurant.model.MenuItem;

import java.util.List;
import java.util.ArrayList;

public class MenuService {

    private static List<MenuItem> menuItems = new ArrayList<>();

    public static List<MenuItem> getAllMenuItems() {
        return menuItems;
    }

    public static MenuItem getMenuItemById(int id) {
        for (MenuItem item : menuItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public static void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void removeMenuItem(int id) {
        menuItems.removeIf(item -> item.getId() == id);
    }
}

