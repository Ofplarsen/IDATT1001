package Ovinger.Oving10.Oving102;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Klassen MenuRegister
 * @version 1.01 22-10-2020
 * @author Olav Finne Praesteng Larsen
 */
public class MenuRegister {
    private ArrayList<Menu> menus;
    private ArrayList<Dish> dishes;

    /**
     * Konstruktoren som oppretter et objekt av typen MenuRegister
     */
    public MenuRegister(){

    }
    /**
     * Konstruktoren som oppretter et objekt av typen MenuRegister
     * @param menus
     */
    public MenuRegister(ArrayList<Menu> menus){
        this.menus = deepCopyMenu(menus);

    }

    /**
     * Metode som dypkopierer en arraylist av typen Menu
     * @param listToCopy
     * @return deepCopiedArraylistCopy
     */
    private ArrayList<Menu> deepCopyMenu(ArrayList<Menu> listToCopy){
        ArrayList<Menu> copy = new ArrayList<>();
        Iterator<Menu> it = listToCopy.iterator();
        while(it.hasNext()){
            Menu e = it.next();
            Menu newM = new Menu(e.getAppetizers(), e.getMains(), e.getDesserts());
            copy.add(newM);
        }
        return copy;
    }

    /**
     * Metode som dypkopierer en ArrayList av typen Dish
     * @param listToCopy
     * @return deepCopiedCopy
     */

    private ArrayList<Dish> deepCopyDish(ArrayList<Dish> listToCopy){
        ArrayList<Dish> copy = new ArrayList<>();
        Iterator<Dish> it = listToCopy.iterator();
        while(it.hasNext()){
            Dish e = it.next();
            Dish newD = new Dish(e.getName(), e.getDishType(), e.getPrice(), e.getRecipe());
            copy.add(newD);
        }
        return copy;
    }

    /**
     * Metode som registerer en ny rett (Dish)
     * @param name
     * @param dishType
     * @param price
     * @param recipe
     */

    public void registerNewDish(String name, String dishType, int price, String recipe){

        for(Dish d : getAllDishes()){
            if(d.getName().equals(name)){
                throw new IllegalArgumentException("Dish already registered");
            }
        }

        getAllDishes().add(new Dish(name, dishType, price, recipe));

    }

    /**
     *
     * @param dishName
     * @return
     */

    public Dish findDish(String dishName){
        try {
            for (Dish d : getAllDishes()) {
                if (d.getName().equals(dishName)) {
                    return d;
                }
            }
        }catch (Exception E){
            throw new IllegalArgumentException("No dishes matched the given dish name!");
        }
        return null;
    }

    /**
     * Lager en liste med alle retter, og fjerner duplikater
     */

    public void allDishes(){
        ArrayList<Dish> allDishes = new ArrayList<>();

        for(Menu m : menus){
            for(Dish d : deepCopyDish(m.getDishes())){
                allDishes.add(d);

            }
        }

        dishes =  removeDuplicate(allDishes);
    }

    /**
     * Fjerner duplikater i en gitt ArrayList
     * @param list
     * @param <T>
     * @return
     */
    private static <T> ArrayList <T> removeDuplicate(ArrayList<T> list){
        ArrayList<T> newList = new ArrayList<T>();


        for (T element : list) {

            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        return newList;
    }

    /**
     * Finn alle retter gitt type
     * @param type
     * @return
     */


    public ArrayList<Dish> findDishesOfType(String type){
        ArrayList<Dish> dishesOfType = new ArrayList<>();

        for(Dish d : getAllDishes()){
            if(d.getDishType().equals(type)){
                dishesOfType.add(d);
            }
        }
        if(dishesOfType.size() == 0){
            throw new IllegalArgumentException("Didnt find any dishes of given type");
        }
        return dishesOfType;
    }

    /**
     *  Registerer en ny meny
     * @param dishesToAdd
     */
    public void registerNewMenu(ArrayList<Dish> dishesToAdd){

        Menu newMenu = new Menu(dishesToAdd);
        menus.add(newMenu);
    }

    /**
     * Finner aller menyer innenfor et prisintervall
     * @param start
     * @param end
     * @return
     */

    public ArrayList<Menu> findAllMenusGivenPriceInterval(int start, int end){
        if(end < start){
            throw new IllegalArgumentException("End !< start");
        }
        ArrayList<Menu> menusBetweenInterval = new ArrayList<>();
        for(Menu m : menus){
            if(m.getTotalPrice() >= start && m.getTotalPrice() <= end){
                menusBetweenInterval.add(m);
            }
        }
        return menusBetweenInterval;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public ArrayList<Dish> getAllDishes() {
        return dishes;
    }
}
