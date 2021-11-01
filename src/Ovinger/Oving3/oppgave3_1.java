import java.util.*;

//Ta inn tallet hvor programmet skal starte fra - JA
// Ta inn tallet hvor tabellen skal slutte - JA
// Sette opp en løkke som looper gjennom gangetabellen til det første tallet - JA
// Deretter gå over til neste tall - Ja
// Stoppe på det avsluttende tallet - JA

public class oppgave3_1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String fra;
        String til;
        do{
            System.out.print("Tallet hvor multiplikasjonstabellen skal starte: ");
            fra = in.nextLine();

            System.out.print("Tallet hvor multiplikasjonstabellen skal stoppe: ");
            til = in.nextLine();
        } while(Integer.parseInt(til) <= Integer.parseInt(fra));
        //System.out.println(!til.matches("[a-zA-Z_]+"));
        //System.out.println(!fra.matches("[a-zA-Z_]+"));

        if(til.matches("[a-zA-Z_]+") || fra.matches("[a-zA-Z_]+")){
            System.out.println("Du kan bare skrive inn tall, din luring ;)");
        }else{

        int x = 1;
        int tallFra = Integer.parseInt(fra);
        int tallTil = Integer.parseInt(til);
        int regnestykke;

        //Legger +1 på tallFra, slik at multiplikasjonstabellen til neste tall blir printet
        do{
            System.out.printf("\n\n%d-gangen: ", tallFra);
            do{
                //Printer regnestykket med svar fra 1-10
                regnestykke = tallFra * x;
                System.out.printf("\n%d x %d = %d", tallFra, x, regnestykke);
                x += 1;

            }while( x <= 10);
            x = 1;
            tallFra += 1;
        }while(tallFra <= tallTil);
        in.close();
        }
    }
}
