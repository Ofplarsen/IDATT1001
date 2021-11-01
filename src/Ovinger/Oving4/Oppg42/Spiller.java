package Oppg42;

import java.util.Random;

/*
    Klassen skal simulere en spiller
        - Skal ha objektvariabler som:
            sumPoeng

        - Skal ha metoder som:
            getSumPoeng(), kastTerningen(), erFerdig()

        Java.util.Random terning= new java.util.Random(); // vi lager en tilfeldigtallgenerator
        I metoden kastTerningen() henter du et tilfeldig tall i intervallet (0, 5) på følgende måte:
        Int terningkast = terning.nextint(6);
        Legg til 1 for å få et gyldig terningkast.

*/

public class Spiller {

    private int sumPoeng = 0;
    private String spillerNavn;

    public Spiller(String navn) {
        this.spillerNavn = navn;
    }

    public int getSumPoeng() {
        return sumPoeng;
    }



    public int kastTerningen() {
        Random terning = new Random();
        int terningkast = terning.nextInt(6) + 1;
        return terningkast;
    }

    public int addToSum(int sum){
        if(sum == 1){
            sumPoeng = 0;
            return sumPoeng;
        }else if(sumPoeng >= 100){
            sumPoeng -= sum;
            return sumPoeng;
        }
        else{
            sumPoeng += sum;
            return sumPoeng;
        }
    }
    public int resetSum(int ternkast){
        if(ternkast == 1){
            sumPoeng = 0;
            return sumPoeng;
        }else{

        }
        return sumPoeng;
    }
    
    public boolean erFerdig(int num){

        if(num == 100){
            return true;
        }else{
            return false;
        }
    }
    
    public String toString(){

        String str = ("Gratulerer, " + spillerNavn + "! Du vant!");

        return str;
    }
}
