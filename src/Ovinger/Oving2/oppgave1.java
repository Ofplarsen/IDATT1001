import java.util.*;
public class oppgave1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Årstallet som skal sjekkes for om det er et skuddår: ");
        String arstallStr = in.nextLine();

        int arstallInt = Integer.parseInt(arstallStr);

        if(arstallInt%100 == 0){
            if(arstallInt%400 == 0){
            System.out.printf("\nÅr %d er et skuddår", arstallInt);
            }else{
                System.out.printf("\nÅr %d er ikke et skuddår", arstallInt);
        }
        }else if( arstallInt%4 == 0){
            System.out.printf("\nÅr %d er et skuddår", arstallInt);
        }else{
            System.out.printf("\nÅr %d er ikke et skuddår", arstallInt);
        }


        in.close();
    }
}