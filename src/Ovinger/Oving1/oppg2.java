import static javax.swing.JOptionPane.*;

public class oppg2 {
    public static void main(String[] args){
        String timerLest = showInputDialog("Antall timer: ");
        String minutterLest = showInputDialog("Antall minutter: ");
        String sekunderLest = showInputDialog("Antall sekunder: ");

        double timer = Double.parseDouble(timerLest);
        double minutter = Double.parseDouble(minutterLest);
        double sekunder = Double.parseDouble(sekunderLest);

        double samSekunder = timer*3600 + minutter*60 + sekunder;


        showMessageDialog(null, timer + "t, " + minutter + "min, og " + sekunder + "s, blir " + samSekunder + "s");
    }
}
