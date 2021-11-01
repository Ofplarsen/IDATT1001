package Ovinger.Oving10.Oving101;

import javax.swing.*;
import javax.swing.JPanel;
import java.util.ArrayList;

public class EventClient {
    //BRUK JOPTIONPANE NaaR DU LoSER DENNE!!
    public static void main(String[] args) {

        Event test1 = new Event(001, "Event1", "Palace", "BBA", "Party", 200202062000L);
        Event test2 = new Event(002, "Event2", "Bank", "BBB", "Concert", 200202301200L);
        Event Etest3 = new Event(003, "Event2", "Away", "BBC", "Concert", 200203041300L);
        Event test4 = new Event(004, "Event2", "Home", "BBD", "Spelling contest", 200203112300L);
        ArrayList<Event> arrayListEvent = new ArrayList<Event>();
        arrayListEvent.add(test1);
        arrayListEvent.add(test2);
        arrayListEvent.add(Etest3);
        arrayListEvent.add(test4);
        EventRegistry test3 = new EventRegistry(arrayListEvent);

        JTextField numberIDField = new JTextField(5);
        JTextField nameField = new JTextField(5);
        JTextField placeField = new JTextField(5);
        JTextField organizerField = new JTextField(5);
        JTextField typeField = new JTextField(5);
        JTextField dateTimeField = new JTextField(5);

        JTextField firstDate = new JTextField(5);
        JTextField secondDate = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Number ID:"));
        myPanel.add(numberIDField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Name: "));
        myPanel.add(nameField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Place: "));
        myPanel.add(placeField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Organizer: "));
        myPanel.add(organizerField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Type: "));
        myPanel.add(typeField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Date and Time: "));
        myPanel.add(dateTimeField);

        JPanel twoDates = new JPanel();
        twoDates.add(new JLabel("First date:"));
        twoDates.add(firstDate);
        twoDates.add(Box.createHorizontalStrut(15)); // a spacer
        twoDates.add(new JLabel("Second date: "));
        twoDates.add(secondDate);

        JPaneCheck JPmain = new JPaneCheck();
        int result = 0;
        do {
            result = JPmain.mainPane();
            switch (result) {
                case 0:
                    int newEvent = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Event Information", JOptionPane.OK_CANCEL_OPTION);
                    if (newEvent == JOptionPane.OK_OPTION) {
                        test3.registerNewEvent(new Event(Integer.parseInt(numberIDField.getText()), nameField.getText(), placeField.getText(), organizerField.getText(), typeField.getText(), Long.parseLong(dateTimeField.getText())));
                    }
                    JOptionPane.showMessageDialog(null, new JList(test3.getEventsRegistered().toArray(new Event[0])));
                    continue;
                case 1:
                    String placeToFind = JOptionPane.showInputDialog("Place to search for: ");
                    JOptionPane.showMessageDialog(null, new JList(test3.allEventsGivenPlace(placeToFind).toArray(new Event[0])));
                    //JOptionPane.showMessageDialog(null, JPmain.printJOption(test3).toString());
                    continue;
                case 2:
                    long givenDate = Long.parseLong(JOptionPane.showInputDialog("Date to search for: "));
                    JOptionPane.showMessageDialog(null, new JList(test3.allEventsGivenDate(givenDate).toArray(new Event[0])));
                    continue;
                case 3:
                    int twoDatesEvents = JOptionPane.showConfirmDialog(null, twoDates, "Please Enter Start and End Date", JOptionPane.OK_CANCEL_OPTION);

                    if(twoDatesEvents == JOptionPane.OK_OPTION){
                        JOptionPane.showMessageDialog(null, new JList(test3.eventsGivenDates(Long.parseLong(firstDate.getText()), Long.parseLong(secondDate.getText())).toArray(new Event[0])));
                    }
                case 4:
                    int resultCase4 = JPmain.chooseToSort();
                    switch (resultCase4){
                        case 0:
                            JOptionPane.showMessageDialog(null, new JList(test3.toStringSortedByPlace().toArray(new Event[0])));
                            continue;
                        case 1:
                            JOptionPane.showMessageDialog(null, new JList(test3.toStringSortByType().toArray(new Event[0])));
                            continue;
                        case 2:
                            JOptionPane.showMessageDialog(null, new JList(test3.toStringByTimeAndDate().toArray(new Event[0])));
                            continue;
                    }
                default:
                    System.out.println("Error");
            }
        }while(result!=JOptionPane.CLOSED_OPTION);

        //new JPaneCheck();


        //Test-klient


        test3.allEventsGivenPlace("Home");
        for(Event e : test3.allEventsGivenPlace("Home")){
            System.out.println(e.toString());
        }

        for(Event e : test3.allEventsGivenDate(20020311)){
            System.out.println(e.toString());
        }

        /*
        System.out.println(Arrays.toString(test3.allEventsGivenDate(20020230)));
        //test3.toStringDates(20020230, 20020330);
        test3.toStringSortedByPlace();

        System.out.println("Time and date: ");
        for(Event e : test3.toStringByTimeAndDate()){
            System.out.println(e.toString());
        }
        System.out.println("\n by place");
        for(Event e : test3.toStringSortedByPlace()){
            System.out.println(e.toString());
        }
        System.out.println("\n by time between dates");
        for(Event e : test3.toStringDates(20020206, 20020306)){
            System.out.println(e.toString());
        }
        */
    }
}
