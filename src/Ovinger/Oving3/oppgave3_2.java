import java.util.*;


public class oppgave3_2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String oppTilStr;

        System.out.print("Skriv inn et tall: ");
        oppTilStr = in.nextLine();

        int x = 2;
        int oppTil = Integer.parseInt(oppTilStr);
        boolean sant = false;
        
        do{
            if(oppTil % x == 0){
                sant = true;
                break;
            }

            x++;
        }while(x <= oppTil/2);

        if(oppTil == 2){
            System.out.printf("%d er et primtall.", oppTil);
        }
        else if(sant == false){
            System.out.printf("%d er et primtall.", oppTil);
        }else{
            System.out.printf("%d er ikke et primtall.", oppTil);
        }
        
        in.close();
    }
}