package Ovinger.Oving7.Oving72;

public class WordProcessingClient {
    public static void main(String[] args){
        String text = "Hei, dette er en testtekst som skal brukes til å teste de ulike metodene i klassen: 'WordProcessing'! " +
                "Nå skal vi bruke æ, ø, og å. Her finnes det, finnes, funnet.";

        WordProcessing test = new WordProcessing(text);
        test.cleanTextForSigns(text);
        test.numberOfWords();
        test.averageWordPerSign();
        test.changeAWord("finnes", "fins");
        test.averageWordLength();
        /*
        System.out.println(test.getWordPerSign());
        System.out.println(test.getCleanText());
        System.out.println(test.getAverWordLen());
        System.out.println(test.getNumberOfWords());
        System.out.println(test.getText());
        System.out.println(test.getTextInCaps());
        System.out.println(test.getAWordChanged());
        */
        System.out.println(test.toString());
        System.out.println(test.getTextInCaps());
    }
}
