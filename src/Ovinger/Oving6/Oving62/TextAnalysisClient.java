package Oving62;

import java.util.Arrays;
import java.util.Scanner;

public class TextAnalysisClient {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String text = "";
        String x = new String();

        do{
            System.out.println("Skriv inn teksten (0 for å avslutte): ");

            x = in.nextLine();

            if(x.equals("0")){
                break;
            }

            text = x;
            text = text.toLowerCase();

            TextAnalysis theText = new TextAnalysis(text);

            theText.checkForChar();

            System.out.println(theText.toString());

            System.out.println("\nNumber of different letters: " + theText.numberOfDifferentLetters());
            System.out.println("Total number of letters: " + theText.totalNumberOfLetters());
            System.out.println("Letter(s) most used: " + theText.letterWrittenMost());
            System.out.println("Total times the designated letter is used: " + theText.totalTimesLetter('a'));
            System.out.println("Percent of the text that isn't letters: " + theText.percentOfLetters() + "%\n");
        }while(1<2);



        //System.out.println(text);
    }
}

