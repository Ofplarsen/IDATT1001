package Ovinger.Oving5.Oving52;

public class Intervall {
    public static void main(String[] args) {

        for (int x = 1; x <= 100; x++) {
            System.out.println(x + ". -  " + MinRandom.nesteDesimaltall(0.01, 0.02) + "  -  " +
                    MinRandom.nesteHeltall(4, 10));
        }
    }
}

