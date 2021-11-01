package Ovinger.Oving10.Oving102;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Klassen Menu
 * @version 1.01 2020-10-22
 * @author Olav Finne Praesteng Larsen
 */

public class Menu {

    private ArrayList<Dish> appetizers = new ArrayList<>();
    private ArrayList<Dish> mains = new ArrayList<>();
    private ArrayList<Dish> desserts = new ArrayList<>();

    /**
     * Konstruktor som oppretter et objekt av typen Menu
     * @param appetizer
     * @param main
     * @param dessert
     */
    public Menu(Dish appetizer, Dish main, Dish dessert){
        this.appetizers.add(new Dish(appetizer.getName(),appetizer.getDishType(),appetizer.getPrice(),appetizer.getRecipe()));
        this.mains.add(new Dish(main.getName(),main.getDishType(),main.getPrice(),main.getRecipe()));
        this.desserts.add(new Dish(dessert.getName(),dessert.getDishType(),dessert.getPrice(),dessert.getRecipe()));
    }

    /**
     * Konstruktor som oppretter objekt av typen Menu
     * @param appetizers
     * @param mains
     * @param desserts
     */
    public Menu(ArrayList<Dish> appetizers, ArrayList<Dish> mains, ArrayList<Dish> desserts){
        this.appetizers = deepCopyDishes(appetizers);
        this.mains = deepCopyDishes(mains);
        this.desserts = deepCopyDishes(desserts);
    }

    /**
     * Konstruktor som oppretter objekt av typen Menu
     * @param dishesToAdd
     */
    public Menu(ArrayList<Dish> dishesToAdd){
        ArrayList<Dish> appetizers = new ArrayList<>();
        ArrayList<Dish> mains = new ArrayList<>();
        ArrayList<Dish> desserts = new ArrayList<>();

        for(Dish d : dishesToAdd){
            if(d.getDishType().equals("appetizer")){
                appetizers.add(d);
            }else if(d.getDishType().equals("main")){
                mains.add(d);
            }else if(d.getDishType().equals("dessert")){
                desserts.add(d);
            }else{
                System.out.println(d.getName() + " did not match any of the types: " + d.getDishType());
            }
        }

        this.appetizers = appetizers;
        this.mains = mains;
        this.desserts = desserts;
    }

    /**
     * Metode som lager en dyp kopi av ArrayList typen Dish
     * @param copyFrom
     * @return
     */
     private ArrayList<Dish> deepCopyDishes(ArrayList<Dish> copyFrom) {
        ArrayList<Dish> copy = new ArrayList<>();

        Iterator<Dish> it = copyFrom.iterator();
        while(it.hasNext()){
            Dish e = it.next();
            Dish newD = new Dish(e.getName(), e.getDishType(), e.getPrice(), e.getRecipe());
            copy.add(newD);
        }
        return copy;
    }

    public ArrayList<Dish> getAppetizers() {
        return appetizers;
    }

    public ArrayList<Dish> getMains() {
        return mains;
    }

    public ArrayList<Dish> getDesserts() {
        return desserts;
    }

    /**
     * Metode som returnerer en ArrayList av alle de ulike rettene i menyen
     * @return
     */
    public ArrayList<Dish> getDishes(){
        ArrayList<Dish> allDishes = new ArrayList<>();

        for(Dish d : appetizers){
            allDishes.add(d);
        }
        for(Dish d: mains){
            allDishes.add(d);
        }
        for(Dish d : desserts){
            allDishes.add(d);
        }
        return allDishes;
    }

    /**
     * Metode som returnerer totalprisen til menyen
     * @return
     */
    public int getTotalPrice(){
        int price = 0;
        for(Dish d : getDishes()){
            price += d.getPrice();
        }
        return price;
    }

}
