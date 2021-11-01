package Ovinger.Oving7.Oving71;
import java.lang.String;

public class NyString {
    private String text;

    public NyString(String text){
        this.text = text;
    }

    public String textToLower(String text){
        return text.toLowerCase();
    }

    public String shorten(){

        String[] listOfText = textToLower(text).split(" ");
        String newStr = "";
        for(int i = 0; i < listOfText.length; i++){
            newStr += listOfText[i].charAt(0);
        }
        return newStr;
    }

    public String replaceLetter(String x){
        String replaced = "";
        if(x.length() > 1){
            throw new IllegalArgumentException("Must be a char");
        }
        replaced = text.replace(x, "");

        return replaced;
    }
    
}
