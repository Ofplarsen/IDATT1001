package Ovinger.Oving8.Oving81;
import java.util.Scanner;
public class MainClient {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] choices = {"Tax percent", "Monthly wage", "Print employee info", "Exit"};
        Person person1 = new Person("Olav Finne Præsteng", "Larsen", 2001);
        Employee employee1 = new Employee(person1, 00000001, 2011, 600000, 30);

        System.out.println(employee1.toString());
        /*
        System.out.println(employee1.getYearsInCompany());
        System.out.println(employee1.moreThanYears(10));
        System.out.println(employee1.taxPerMonth());
        System.out.println(employee1.yearlyWage());
        System.out.println(employee1.getYearsInCompany());
        System.out.println(employee1.yearlyTax());
        */

        System.out.println(employee1.testClass());

        do{
            String whatToDo = "";
            System.out.println("Change");
            //Printer ut de ulike tingene man kan gjøre i en liste
            for(int i = 0; i < choices.length; i++){
                System.out.println(i+1 + ". " + choices[i]);
            }
            String choice = in.nextLine();
            //Løkke og loop for
            if(choice.equals("1")){
                do {
                    try {
                        System.out.println(employee1.yearlyTax());
                        System.out.println("What would like to change the tax percent to? (Old one = " + employee1.getTaxPercent() + "%)");
                        whatToDo = in.nextLine();
                        if(Integer.parseInt(whatToDo) > 100){
                            System.out.println("Tax percent need to be less than 100%");
                        }else {
                            employee1.setTaxPercent(Integer.parseInt(whatToDo));
                            System.out.println("New tax percent: " + employee1.getTaxPercent() + "%");
                        }

                    }catch (Exception e){
                        System.out.println("Tax percent need to be a number");
                    }
                }while(Integer.parseInt(whatToDo) > 100);
            }else if(choice.equals("2")){
                try {
                    System.out.println("What would you like to set the new monthly wage to? (Old one = " + employee1.getMonthlyWage() + " kr)");
                    whatToDo = in.nextLine();
                    employee1.setMonthlyWage(Integer.parseInt(whatToDo));
                    System.out.println("New monthly wage is: " + employee1.getMonthlyWage() + " kr");
                }catch(Exception e){
                    System.out.println("Invalid monthly wage");
                }
            }else if(choice.equals("3")){
                System.out.println(employee1.toString());
            }
            else if(choice.equals("4")){
                System.out.println(employee1.toString());
                System.out.println("Shutting down...");
                break;
            }else{
                System.out.println("Number out of range, or you have written an invalid character");
            }

        }while(true);
    }
}
