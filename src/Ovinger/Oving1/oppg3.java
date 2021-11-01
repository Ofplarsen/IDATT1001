import static javax.swing.JOptionPane.*;

public class oppg3 {
    public static void main(String[] args){
        String sekunderLest = showInputDialog("Antall sekunder: ");

        int sekTilTimer = Integer.parseInt(sekunderLest);
        int antallTimer = sekTilTimer/3600;

        int antallMinutter = sekTilTimer%3600;

        int antallSekunder = antallMinutter%60;

        antallMinutter /= 60;



        showMessageDialog(null, antallTimer +"t, " + antallMinutter + "min, og " + antallSekunder + "s." );
    }    
}