import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class numberOfNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many times would you like to generate a random number?");
        try {

            int index = Integer.parseInt(in.nextLine());

            Random random = new Random();

            int[] numberPerNumber = new int[index];

            for (int i = 0; i < index; i++) {
                int number = random.nextInt(10);
                numberPerNumber[i] = number;
            }
            //System.out.println(Arrays.toString(numberPerNumber));
            int[] oneToNine = new int[10];
            for (int i = 0; i < numberPerNumber.length; i++) {
                int x = -1;
                do {
                    x++;
                    if (x == numberPerNumber[i]) {
                        oneToNine[x] = oneToNine[x] + 1;
                        break;
                    }
                } while (numberPerNumber[i] != x);
            }
            String[] dots = new String[10];

            for (int i = 0; i < dots.length; i++) {
                dots[i] = "";
            }

            for (int w = 0; w < oneToNine.length; w++) {
                int k = 0;
                while (k * index / 100 < Math.round(oneToNine[w])) {
                    dots[w] += "*";
                    k++;
                }
            }

            for (int y = 0; y < oneToNine.length; y++) {
                System.out.println(y + " occurs " + oneToNine[y] + " time(s) " + dots[y]);
            }
        }catch(Exception e){
            System.out.println("You can only write numbers!");
        }

    }

}
