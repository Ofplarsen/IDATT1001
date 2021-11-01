package Oving62;

public class TextAnalysis {
    private int[] numberOfChars = new int[30];
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyzæøå".toCharArray();
    private char[] text;

    public TextAnalysis(String text){
        this.text = text.toCharArray();
    }

    public void checkForChar(){

        for(int i = 0; i < text.length; i++){
            int check = 0;
            for(int x = 0; x < alphabet.length; x++){

                if(alphabet[x] == text[i]){
                    numberOfChars[x] += 1;
                    check = 1;
                    break;
                }
            }
            if(check == 0){
                numberOfChars[29] += 1;
            }
        }
    }

    public int[] getNumberOfChars() {
        return numberOfChars;
    }

    public int numberOfDifferentLetters(){
        int differentLetters = 0;

        for(int i = 0; i < numberOfChars.length-1; i++){
            if(numberOfChars[i] > 0){
                differentLetters++;
            }
        }
        return differentLetters;
    }

    public int totalNumberOfLetters(){
        int totalNumber = 0;

        for(int i = 0; i < numberOfChars.length-1; i++){
            totalNumber += numberOfChars[i];
        }
        return totalNumber;
    }

    public int percentOfLetters(){
        int d = totalNumberOfLetters();
        int f = numberOfChars[numberOfChars.length-1]+totalNumberOfLetters();
        int c = 100*d/f;
        return 100-c;
    }

    public int totalTimesLetter(char letter){
        int totalTimes = 0;

        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i] == letter){
                totalTimes = numberOfChars[i];
            }
        }
        return totalTimes;
    }

    public String letterWrittenMost(){
        int max = 0;
        String str = "";
        for(int i = 0; i < numberOfChars.length-1; i++){
            if(numberOfChars[i] > max){
                max = numberOfChars[i];
            }
        }
        
        for(int i = 0; i < numberOfChars.length-1; i++){
            if(max == numberOfChars[i]){
                str += alphabet[i] + " ";
            }
        }
        return str;
    }

    public String toString(){
        String str = "";

        for(int i = 0; i < numberOfChars.length-1; i++){
            str += "\n " + alphabet[i] + " occurs " + numberOfChars[i] + " time(s)";
        }

        str += "\n other signs occurs " + numberOfChars[numberOfChars.length-1] + " time(s)";
        return str;
    }


}
