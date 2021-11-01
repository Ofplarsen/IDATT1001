package Ovinger.Oving7.Oving71;

public class NyStringClient {
    public static void main(String[] args) {
        String str = "Denne setningen kan forkortes";
        NyString newString = new NyString(str);

        System.out.println(newString.shorten());
        System.out.println(newString.replaceLetter("e"));
    }
}

