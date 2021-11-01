public class Oppgave2 {
    public static void main(String[] args){
        double kjottdeigA[] = {35.90, 450};
        double kjottdeiB[] = {39.50, 500};
        
        if(kjottdeigA[0]/kjottdeigA[1] > kjottdeiB[0]/kjottdeiB[1]){
            System.out.println("Kjøttdeig B er billigst");
        }else{
            System.out.println("Kjøttdeig A er billigst");
        }
    }
}