package Oppg42;

import java.util.Scanner;

/*

1. Kast terning i for loop, 1 for hver spiller hver runde
   Førstemann til 100
    - Hvis en av de kaster 1, blir scoren deres resatt

2. Opprett to objekter av klassen; Spiller

3. Lag en loop som kjører inntil en av spillerne har vunnet
    - Hver spiller kaster terningen 1 gang
    - Print ut rundenummer og poengsummene fortløpende
    Hvis man kommer over 100
        - Skal neste kast trekkes fra til man kommer akkurat på 100
    Hvis man er under 100 igjen skal kastet legges til 


Ideer (Kan gi navnet sitt til de ulike spillerne for å gjøre det interaktivt)
*/

public class DiceBattle {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Navn på spiller 1: ");
        String spiller1Navn = in.nextLine();

        System.out.println("Navn på spiller 2: ");
        String spiller2Navn = in.nextLine();

        Spiller spiller1 = new Spiller(spiller1Navn);
        Spiller spiller2 = new Spiller(spiller2Navn);
        int rundenummer = 0;
        do{ 
            if(spiller1.erFerdig(spiller1.getSumPoeng())){
                System.out.println(spiller1.toString());
                break;
            }
            else if(spiller2.erFerdig(spiller2.getSumPoeng())) {
                System.out.println(spiller2.toString());
                break;
            }
            int terningkast1 = spiller1.kastTerningen();
            spiller1.addToSum(terningkast1);
            
            int terningkast2 = spiller2.kastTerningen();
            spiller2.addToSum(terningkast2);

            System.out.print(rundenummer + ": "+"Spiller 1: " + terningkast1 + " - " + spiller1.getSumPoeng());
            System.out.print(" --- Spiller 2: " + terningkast2 + " - " + spiller2.getSumPoeng() + "\n");          
            rundenummer++;
        }while(true);
        in.close();
    }
}
