import java.util.Scanner;

public class brokLoop {
    static void brokLooper(){
        String looper;
        do{
            Scanner in = new Scanner(System.in);

            System.out.println("Skriv inn teller til brøk 2: ");
            int teller2 = Integer.parseInt(in.nextLine());

            System.out.println("Skriv inn nevner til brøk 2: ");
            int nevner2 = Integer.parseInt(in.nextLine());


            looper = in.nextLine();

        }while(looper != "n");
    }
}
