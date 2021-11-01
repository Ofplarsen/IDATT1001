package Ovinger.Oving11;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        PropertyRegistry myRegistry = new PropertyRegistry();
        myRegistry.registerProperty(1445, "Gloppen", 77, 631, 1017.6, "Jens Olsen", "");
        myRegistry.registerProperty(1445, "Gloppen", 77, 131, 661.3, "Nicolay Madsen","Syningom");
        myRegistry.registerProperty(1445, "Gloppen", 75, 19, 650.6, "Evilyn Jensen", "Fugletun");
        myRegistry.registerProperty(1445, "Gloppen", 74, 188, 1457.2, "Karl Ove Bråten", "");
        myRegistry.registerProperty(1445, "Gloppen", 69, 47, 1339.4, "Elsa Indregård", "Håiberg");
        //TODO Feiltest helt ferdig
        MenuInterface menu = new MenuInterface(myRegistry);
        menu.start();

    }


}

/* Jeg velger å legge til en ekstra klasse for ryddighetens skyld, slik at main-metoden ikke blir veldig fylt og stygg*/
/**
 * Klassen MenuInterface
 * Version 1.01
 * @author xray2
 */
class MenuInterface{
    // Constants representing the different menu choices
    private final int ADD_PROPERTY = 1;
    private final int LIST_ALL_PROPERTIES = 2;
    private final int FIND_PROPERTY = 3;
    private final int CALCULATE_AVERAGE_AREA = 4;
    private final int REMOVE_PROPERTY = 5;
    private final int FIND_PROPERTIES = 6;
    private final int NUMBER_OF_PROP = 7;
    private final int EXIT = 9;
    private PropertyRegistry myRegistry;

    public MenuInterface(PropertyRegistry test){
        this.myRegistry = test;
    }

    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1.
     * If 0 is returned, the user has entered a wrong value
     */
    private int showMenu()
    {
        int menuChoice = 0;
        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search property");
        System.out.println("4. Calculate average area");
        System.out.println("5. Remove property");
        System.out.println("6. Search for properties");
        System.out.println("7. Get number of properties");
        System.out.println("9. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.\n");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            menuChoice = sc.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice;
    }

    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality.
     */
    public void start() {
        boolean finished = false;
        Scanner in = new Scanner(System.in);
// The while-loop will run as long as the user has not selected
// to quit the application
        while (!finished) {
            String municipalityName = "";
            double area = 0;
            int muniNr = 0;
            int gnr = 0;
            int bnr = 0;
            String nameOfOwner = "";
            String nameOfProp = "";

            int menuChoice = this.showMenu();
            switch (menuChoice)
            {
                case ADD_PROPERTY:
                    try {
                        System.out.println("MunicipalityNr: ");
                        muniNr = in.nextInt();
                        in.nextLine();
                        System.out.println("MunicipalityName: ");
                        municipalityName = in.next();
                        in.nextLine();
                        System.out.println("Gnr: ");
                        gnr = in.nextInt();
                        in.nextLine();
                        System.out.println("Bnr: ");
                        bnr = in.nextInt();
                        in.nextLine();
                        System.out.println("Area: ");
                        String testingTheString = Integer.toString(muniNr) + "-" + Integer.toString(gnr) + "/" + Integer.toString(bnr);
                        if(checkAlready(testingTheString)){
                            throw new IllegalArgumentException("Property already existing");
                        }
                        area = in.nextDouble();
                        in.nextLine();
                        if(area < 0){
                            throw new IllegalArgumentException("Area can't be less than 0");
                        }
                        System.out.println("Name of Owner: ");
                        nameOfOwner = in.next();
                        in.nextLine();
                        System.out.println("Name of Property (press 0 if none): ");
                        nameOfProp = in.next();
                        in.nextLine();
                        if (nameOfProp.equals("0")) {
                            nameOfProp = "";
                        }
                        myRegistry.registerProperty(muniNr, municipalityName, gnr, bnr, area, nameOfOwner, nameOfProp);
                        printList();
                        break;
                    }catch(Exception e){
                        System.out.println("Something went wrong :P");
                    }
                case LIST_ALL_PROPERTIES:
                    printList();
                    break;
                case FIND_PROPERTY:
                    try {
                        System.out.println("MunicipalityNr: ");
                        muniNr = in.nextInt();
                        in.nextLine();
                        System.out.println("Gnr: ");
                        gnr = in.nextInt();
                        in.nextLine();
                        System.out.println("Bnr: ");
                        bnr = in.nextInt();
                        in.nextLine();
                        System.out.println(myRegistry.findProperty(muniNr, gnr, bnr).toString());

                        System.out.println(myRegistry.findProperty(muniNr, gnr, bnr)==null ? "Does not exist" : "");
                        break;
                    }catch (Exception e){
                        System.out.println("Something went wrong");
                        break;
                    }
                case CALCULATE_AVERAGE_AREA:
                    System.out.printf("\n%.2f m^2",myRegistry.getAverageArea());
                    break;
                case REMOVE_PROPERTY:
                    try {
                        System.out.println("MunicipalityNr: ");
                        muniNr = in.nextInt();
                        in.nextLine();
                        System.out.println("Gnr: ");
                        gnr = in.nextInt();
                        in.nextLine();
                        System.out.println("Bnr: ");
                        bnr = in.nextInt();
                        in.nextLine();
                        myRegistry.removeProperty(muniNr, gnr, bnr);
                        printList();
                        break;
                    }catch(Exception e){
                        System.out.println("Didn't find any Property with the given criteria");
                    }
                case FIND_PROPERTIES:
                    try {
                        System.out.println("Gnr: ");
                        gnr = in.nextInt();
                        in.nextLine();
                        for (Property p : myRegistry.findProperties(gnr)) {
                            System.out.println(p.toString());
                        }
                        break;
                    }catch(Exception e){
                        System.out.println("The given information did not match any of the registered properties.");
                    }
                case NUMBER_OF_PROP:
                    System.out.println(myRegistry.getRegistrySize());
                    break;
                case EXIT:
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                    break;
                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
            }
        }
        in.close();
    }
    private boolean checkAlready(String stringToTest){
        for(Property p : myRegistry.getListOfProperties()){
            if(p.uniqueIdToString().equals(stringToTest)){
                return true;
            }
        }
        return false;
    }

    public void printList(){
        System.out.println(myRegistry.toString());
    }

}
