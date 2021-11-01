package Ovinger.Oving7.Oving72;
import java.lang.String;
import java.util.Arrays;

public class WordProcessing {

    private String text;
    private String aWordChanged;

    public WordProcessing(String text){
        this.text = text;
    }

    public String cleanTextForSigns(String text){
        String cleanText = "";
        String test = text;
        for(int i = 0; i < text.length(); i++){
            char x = text.charAt(i);
            if(!Character.isLetter(x) && x != ' ' ){
                test = test.replace(String.valueOf(x), "");
            }
            cleanText = test;
        }
        return cleanText;
    }

    public String replace(String wordToReplace, String wordToReplaceWith){
        return text.replace(wordToReplace, wordToReplaceWith);
    }

    private String[] textSplit(String text){
        String[] words = text.split(" ");
        return words;
    }

    public int numberOfWords(){
        String[] words = textSplit(cleanTextForSigns(text));
        int numberOWords = words.length;
        return numberOWords;
    }

    public double averageWordLength(){
        String[] words = textSplit(cleanTextForSigns(text));
        int[] wordlength;
        wordlength = new int[numberOfWords()];
        double x = 0;

        for(int i = 0; i < words.length; i++){
                x += words[i].length();
        }

        return x/wordlength.length;
    }

    public double averageWordPerSign(){
        averageWordLength();
        String[] words = text.split(" ");

        int[] wordlength;
        double wordPerSign = 0;
        int x = 0;
        int count = 0;
        wordlength = new int[numberOfWords()];

        for(int i = 0; i < words.length; i++){
            wordlength[i] = words[i].length();
        }

        for(int i = 0; i < words.length; i++){
            x++;
            if(words[i].contains(",") || words[i].contains(".") || words[i].contains(":") || words[i].contains("!")){
                wordPerSign += x;
                x = 0;
                count++;

            }
        }

        wordPerSign = wordPerSign/count;
        return wordPerSign;
    }

    public double getWordPerSign() {
        return averageWordPerSign();
    }

    public String getTextInCaps(){
        return text.toUpperCase();
    }

    public String getText() {
        return text;
    }

    public void changeAWord(String wordReplaced, String wordReplace){
        aWordChanged = replace(wordReplaced, wordReplace);
    }

    public String getAWordChanged(String word1, String word2) {
        return aWordChanged;
    }

    public double getAverWordLen() {
        return averageWordLength();
    }

    public String getCleanText() {
        return cleanTextForSigns(text);
    }

    public int getNumberOfWords() {
        return numberOfWords();
    }

    @Override
    public String toString() {
        return "WordProcessing{" +
                "text='" + text + '\n' +
                "numberOWords=" + getNumberOfWords() +
                "\ncleanText='" + getCleanText() + '\n' +
                "averWordLen=" + getAverWordLen() +
                "\naWordChanged='" + aWordChanged + '\n' +
                "wordPerSign=" + getWordPerSign() +
                '}';
    }
}
