package Ovinger.Oppgave1;

import static javax.swing.JOptionPane.*;

public class Oving1 {
    public static void main(String[] args){
        String tommerLest = showInputDialog("Antall tommer til centimeter: ");
        double tommer = Double.parseDouble(tommerLest);
        double centimeter = tommer * 2.54;

        if(tommer != 0 || tommer < 0){
        showMessageDialog(null, tommer + " tommer er " + centimeter + "cm");
        }else{
            showMessageDialog(null, "Feil input");
        }
    }
}
