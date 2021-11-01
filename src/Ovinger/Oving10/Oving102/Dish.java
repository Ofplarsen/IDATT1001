package Ovinger.Oving10.Oving102;

/**
 * Klassen Dish
 * @version 1.01 2020.10.23
 * @author Olav Finne Praesteng Larsen
 */
public class Dish {
    private String name;
    private String dishType;
    private int price;
    private String recipe;

    /**
     * Konstruktor som oppretter et objekt av typen Dish
     * @param name
     * @param dishType
     * @param price
     * @param recipe
     */
    public Dish(String name, String dishType, int price, String recipe){
        dishType.toLowerCase();
        if(!(dishType.equals("main") || dishType.equals("dessert") || dishType.equals("appetizer"))){
            throw new IllegalArgumentException("The dish type does not exist");
        }
        this.name = name;
        this.dishType = dishType;
        this.price = price;
        this.recipe = recipe;
    }

    public String getDishType() {
        return dishType;
    }

    public int getPrice() {
        return price;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getName(){
        return name;
    }

    /**
     * toString-metode som returnerer en streng med de ulike attributene i klassen
     * @return
     */
    @Override
    public String toString() {
        return "\nDish{" +
                "name='" + name + '\'' +
                ", dishType='" + dishType + '\'' +
                ", price=" + price +
                ", recipe='" + recipe + '\'' +
                '}';
    }
}
