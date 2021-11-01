package Ovinger.Oving4.Oppg41;

public class Valuta {
    private double output;
    private double kurs;
    private String str;

    public Valuta(double kurs){
        this.kurs = kurs;
    }
    public double fromNok(double number){
        try{
            output = number / kurs;
            return output;
        }
        catch(Exception e){
            System.out.print("Error, Pass på du bare har skrevet inn tall!");
        }
        return output;
    }

    public double toNok(double number){
        try{
            output = number * kurs;
            return output;
        }
        catch(Exception e){
            System.out.print("Error, Pass på du bare har skrevet inn tall!");
        }
        return output;
    }

    public double getKurs(){
        return kurs;
    }

    public String toString(int type){
        if(type == 1){
            str = "\n%.2f NOK er: %.2f %s";
            return str;
        }else{
            str = "\n%.2f %s er: %.2f NOK";
        }
        return str;
    
    }
}