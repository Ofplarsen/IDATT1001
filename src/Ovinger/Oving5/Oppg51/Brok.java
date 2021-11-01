package Ovinger.Oving5.Oppg51;

/*
    1. Lag 2 konstruktører
        - En som tar teller og nevner inn som argument
            * Hvis det blir skrevet inn 0 som nevner, skal et unntaksobjekt av typen IllegalArgumentException kastes
        - En som kun tar teller inn som argument (nevner skal settes = 1)

    2. Klassen skal ha get-metoder, men IKKE set

    3. Klassen skal ha metoder for å summere, subtrahere, multiplisere og dividere en brøk (this) med en annen brøk (parameter til metoden)
        -Det som menes med "this" argumentet som blir skrevet inn i konstruktøren
        - Det skal ikke returneres en verdi, men etter at operasjonen er utført, skal det ligge resultatet i "this"
    
    4. Test i classen
    
    5. Hvis man vil, kan man forkorte brøken (ekstraoppdrag)

*/    
public class Brok {

    private int teller;
    private int nevner;
    private int[] resultat = {0, 0};
    private static String k = "Alle brøk følger ...";
    public Brok(int teller, int nevner)throws IllegalArgumentException{
        if(nevner == 0)
            throw new IllegalArgumentException("Kan ikke dividere på 0!");
        this.teller = teller;
        this.nevner = nevner;
    }
    
    public Brok(int teller){
        this.teller = teller;
        this.nevner = 1;
    }

    public int getTeller(){
        return teller;
    }

    public int getNevner(){
        return nevner;
    }

    public int[] getResultat(){
        return resultat;
    }

    public void summere(int teller1, int nevner1) {

        int resTeller = teller*nevner1 + teller1*nevner;
        int resNevner = nevner*nevner1 + nevner1*nevner;

        oppdaterResultat(resTeller, resNevner);
    }

    public void subtrahere(int teller1, int nevner1){

        int resTeller = teller*nevner1 - teller1*nevner;
        int resNevner = nevner*nevner1;

        oppdaterResultat(resTeller, resNevner);
    }

    public void multiplisere(int teller1, int nevner1){
        
        int resTeller = teller * teller;
        int resNevner = nevner * nevner1;

        oppdaterResultat(resTeller, resNevner);
    }

    public void dividere(int teller1, int nevner1){
        int resTeller = teller * nevner1;
        int resNevner = nevner * teller1;

        oppdaterResultat(resTeller, resNevner);
    }

    private void oppdaterResultat(int resTeller, int resNevner){
        this.resultat[0] = resTeller;
        this.resultat[1] = resNevner;
    }

    public int getResT(){
        return resultat[0];
    }

    public int getResN(){
        return resultat[1];
    }

    public int gcm(int a, int b) {
        if (b == 0) {
            return a;
        }else{
            return gcm(b, a % b);
        }
    }
    public String asFraction(int a, int b) {
        int gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }


    public String toString(){
        String str = String.format("Svaret er: " + resultat[0] + "/" + resultat[1] + ", og forkortet:  %s", asFraction(resultat[0], resultat[1]));
     return str;
    }
}