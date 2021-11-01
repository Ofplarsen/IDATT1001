package Ovinger.Oving10.Oving101;
import javax.swing.*;

public class JPaneCheck{
    public JPaneCheck(){

    }

    public int mainPane() {

        Object[] options = {"Register new event",
                "Find events given place",
                "Find events given date", "Find events between given time interval",
                "Sort events, either by place, type or date/time."};
        int n = JOptionPane.showOptionDialog(null,
                "Would you like to do?",
                "Events Register",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
        return n;
    }

    public int chooseToSort(){
        Object[] options = {"Sort by place",
                "Sort by type",
                "Sort by time and date"};
        int n = JOptionPane.showOptionDialog(null,
                "Would you like to do?",
                "Events Register",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
        return n;
    }


}
