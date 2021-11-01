package Ovinger.Oving10.Oving102;

import java.util.ArrayList;

public class ResturantClient {
    public static void main(String[] args) {


        //test client
        ArrayList<Dish> dishes = new ArrayList<>();
        Dish spaghetti = new Dish("spaghetti", "main", 100, "Recipe for spaghetti");
        Dish cake = new Dish("cake", "dessert", 90, "Recipe for cake");
        Dish bread = new Dish("bread", "appetizer", 50, "Recipe for bread");
        Dish nachos = new Dish("nachos", "appetizer", 60, "Recipe for nachos");
        Dish taco = new Dish("taco", "main", 100, "Recipe for taco");
        Dish chiliMeal = new Dish("chili", "main", 90, "Recipe for chili");
        Dish iceCream = new Dish("ice cream", "dessert", 85, "Recipe for ice cream");
        dishes.add(cake);
        dishes.add(bread);
        dishes.add(nachos);
        dishes.add(taco);
        dishes.add(chiliMeal);
        dishes.add(iceCream);
        dishes.add(spaghetti);

        ArrayList<Dish> appetizers = new ArrayList<>();
        appetizers.add(nachos);
        appetizers.add(bread);

        ArrayList<Dish> main = new ArrayList<>();
        main.add(taco);
        main.add(chiliMeal);

        ArrayList<Dish> dessert = new ArrayList<>();
        dessert.add(iceCream);
        dessert.add(cake);

        Menu italianMenu = new Menu(bread, spaghetti, cake);
        Menu mexicanMenu = new Menu(appetizers,main,dessert);
        Menu allDishesInOne = new Menu(dishes);

        ArrayList<Menu> listOfMenus = new ArrayList<>();
        listOfMenus.add(italianMenu);
        listOfMenus.add(mexicanMenu);
        listOfMenus.add(allDishesInOne);

        MenuRegister menuRegister = new MenuRegister(listOfMenus);

        menuRegister.allDishes();
        //test 1
        System.out.println("All dishes:");
        for(Dish d : menuRegister.getAllDishes()){
            if(!d.getName().equals("cookies")){
                System.out.println("No cookies");
            }
        }
        menuRegister.registerNewDish("cookies", "dessert", 60, "Recipe for cookies");


        for(Dish d : menuRegister.getAllDishes()){
            if(d.getName().equals("cookies")){
                System.out.println("Cookies added! Test 1 complete!");
            }
        }

        //test 2

        if(menuRegister.findDish("cookies").getName().equals("cookies")){
            System.out.println(menuRegister.findDish("cookies").toString());
            System.out.println("Test 2 complete!");
        }

        //test 3
        System.out.println("\nAll main dishes:");
        System.out.println(menuRegister.findDishesOfType("main").toString());

        //test 4
        System.out.println("\nBefore new Menu: ");
        for(Menu m : menuRegister.getMenus()){
            System.out.println("\nMenu: " + m.getDishes());
        }

        Dish cornbread = new Dish("cornbread", "appetizer", 40, "Recipe for corn bread");
        dishes.add(cornbread);

        menuRegister.registerNewMenu(dishes);
        menuRegister.allDishes();
        System.out.println("\nAfter new Menu: ");
        for(Menu m : menuRegister.getMenus()){
            System.out.println("\nMenu: " + m.getDishes());
        }

        System.out.println("\nAll Menus given Interval:");

        for(Menu m : menuRegister.findAllMenusGivenPriceInterval(100, 1000)){
            System.out.println("\nMenus in price range: "+ m.getDishes() +  " - "+ m.getTotalPrice() + "kr");
        }

    }
}
