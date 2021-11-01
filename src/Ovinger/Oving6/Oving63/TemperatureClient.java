package Ovinger.Oving6.Oving63;

import java.util.Arrays;

public class TemperatureClient {
    public static void main(String[] args){
        Temperatures temp = new Temperatures();

        System.out.println("Middleverid for dagene: " + Arrays.toString(temp.middleTempEachDay()));

        System.out.println("Middleverid for hver time i måneden: " + Arrays.toString(temp.middleTempEachHour()));

        System.out.println("Middleverid for måneden: " + temp.middleTempMonth());

        System.out.println("Antall for oppgitte verdier: " + Arrays.toString(temp.numberOfDaysWith()));

        System.out.println(temp.toString());
    }

}
