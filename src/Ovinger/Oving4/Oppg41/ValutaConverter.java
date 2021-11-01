package Ovinger.Oving4.Oppg41;

import java.util.*;
/*
1. Skrive inn beløp
2. Spør om beløpet skal konverteres mellom de ulike typene
3. Spør om du vil konvertere fra, eller til Nok
4. 
*/

public class ValutaConverter {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String money;
        String[] valutaList = {"dollar", "euro", "svenske kroner", "avslutt"};
        int typeOfValutaInt;

        Valuta dollar = new Valuta(8.92);
        Valuta euro = new Valuta(10.54);
        Valuta sek = new Valuta(1.0204);

        do{
            System.out.println("\n\nVelg valuta");

            for(int i = 0; i < valutaList.length; i++) {
                System.out.printf("%d: %s\n", i+1 ,valutaList[i]);
            }
            System.out.println("\nSkriv inn tall: ");
            String typeOfValuta = in.nextLine();

            typeOfValutaInt = Integer.parseInt(typeOfValuta)-1;

            if(typeOfValutaInt == 3){
                System.out.print("Avslutter program...");
            }else{
                System.out.println("Vil du konvertere: ");
                String[] konvTil = {"fra","til"};

                for(int i = 0; i < 2; i++) {
                    System.out.printf("\n%d: %s", i+1 ,konvTil[i]);
                }
            
                System.out.println("\n\nnorske kroner?");
                String konvTilStr = in.nextLine();

                do{
                    System.out.println("\nSkriv inn beløpet som skal bli omgjort (Skriv n for å avslutte): ");
                    money = in.nextLine();

                    try{
                        double moneyD = Double.parseDouble(money);

                        if(konvTilStr.equals("1")){
                            if(typeOfValutaInt == 0){
                                System.out.printf(dollar.toString(1), moneyD, dollar.fromNok(moneyD), "dollar");
                            }
                            else if(typeOfValutaInt == 1){
                                System.out.printf(euro.toString(1), moneyD, euro.fromNok(moneyD), "euro");
                            }
                            else if(typeOfValutaInt == 2){
                                System.out.printf(sek.toString(1), moneyD, sek.fromNok(moneyD), "SEK");
                            }else{
                                System.out.println("Du har skrevet noe utenfor intervallet");
                            }

                        }else if(konvTilStr.equals("2")){

                            if(typeOfValutaInt == 0){
                                dollar.toNok(moneyD);
                                System.out.printf(dollar.toString(2), moneyD,"dollar", dollar.toNok(moneyD));
                            }
                            else if(typeOfValutaInt == 1){
                                System.out.printf(euro.toString(2), moneyD,"euro", euro.toNok(moneyD));
                            }
                            else if(typeOfValutaInt == 2){
                                System.out.printf(sek.toString(2), moneyD,"SEK", sek.toNok(moneyD));
                            }else{
                                System.out.println("Du har skrevet noe utenfor intervallet");
                            }

                        }else{
                            System.out.println("Du har skrevet noe utenfor intervallet");
                        }
                    }catch(Exception e){
                        System.out.print("Something went wrong");
                    }
                }while(!money.equals("n"));
            }
        }while(typeOfValutaInt != 3);
    in.close();
    }
    
}
