package Ovinger.Oving5.Oppg51;

import java.util.Scanner;

/*
1. Lese inn teller fra bruker
2. Lese inn nevner fra bruker

3. Lage ny klasse med nevner og teller
    Hvis nevner == 0, skal klassen være

*/
public class BrokRegner {
    public static void main(String[] args){
        //try {
            String teller2S;
            String nevner2S;
            Scanner in = new Scanner(System.in);
            String[] mathList = {"addere", "subtrahere", "mulitplisere", "dividere", "avslutt"};

            System.out.println("\nSkriv inn telleren: ");
            int teller = Integer.parseInt(in.nextLine());

            System.out.println("Skriv inn nevner: ");
            int nevner = Integer.parseInt(in.nextLine());
            Brok brok = new Brok(teller, nevner);
            int whatToDo;
            do {
                System.out.println("Was werden Sie machen?\n");
                for (int i = 0; i < mathList.length; i++) {
                    System.out.printf("%d. %s \n", i + 1, mathList[i]);
                }

                System.out.println("\nSchreib hier: ");
                whatToDo = Integer.parseInt(in.nextLine());



                System.out.println("Skriv inn teller til brøk 2: ");
                teller2S = in.nextLine();
                int teller2 = Integer.parseInt(teller2S);

                System.out.println("Skriv inn nevner til brøk 2: ");
                nevner2S = in.nextLine();
                int nevner2 = Integer.parseInt(nevner2S);


                Brok brok2 = new Brok(teller2, nevner2);

                switch (whatToDo) {
                    case 1:
                        brok.summere(brok2.getTeller(), brok2.getNevner());
                        break;
                    case 2:
                        brok.subtrahere(brok2.getTeller(), brok2.getNevner());
                        break;

                    case 3:
                        brok.multiplisere(brok2.getTeller(), brok2.getNevner());
                        break;

                    case 4:
                        brok.dividere(brok2.getTeller(), brok2.getNevner());
                        break;
                    default:
                        System.out.println("Du har skrevet utenfor intervallet");

                }

                brok.gcm(brok.getResT(), brok.getNevner());
                System.out.println(brok.toString());

            }while(whatToDo != 5);
        //}catch(Exception IllegalArgument) {
        //    System.out.println("Error! Grrr...");
        //}
        in.close();
    }   
}

