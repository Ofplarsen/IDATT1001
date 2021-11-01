package Ovinger.Oving5.Oving52;

import java.util.Random;

public class MinRandom {
    private static Random r = new Random();


    public static int nesteHeltall( int nedre, int ovre){
        if(ovre < nedre){
            throw new IllegalArgumentException("Øvre kan ikke være mindre enn nedre (nesteHeltall)");
        }else if(nedre < 0){
            throw new IllegalArgumentException("Nedre kan ikke være mindre enn 0 (nesteHeltall)");
        }
        int heltall = r.nextInt(ovre-nedre+1)+nedre;
        return heltall;
    }

    public static double nesteDesimaltall(double nedre, double ovre){
        if(nedre > ovre){
            throw new IllegalArgumentException("Nedre kan ikke være større enn øvre (nesteDesimaltall)");
        }else if(ovre >= 1){
            throw new IllegalArgumentException("Øvre må være mindre enn 1 (nesteDesimaltall)");
        }else if(nedre < 0){
            throw new IllegalArgumentException("Nedre kan ikke være mindre enn 0 (nesteDesimaltall)");
        }
        double desimaltall = nedre + (ovre - nedre ) * r.nextDouble();
        return desimaltall;
    }
}
