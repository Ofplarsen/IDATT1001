package Ovinger.Oving10.Oving101;

import java.util.*;

/**
 * Klassen EvenRegistry
 * @version 1.01 2020-10-22
 * @author Olav Finne Praesteng Larsen
 */
public class EventRegistry{

    /**
     * Konstruktor for EventRegistry
     */
    public EventRegistry(){

    }

    /**
     * Konstruktor for EventRegistry
     * @param events
     */
    public EventRegistry(Event events){
        registerNewEvent(events);
    }

    /**
     * Konstruktor for EventRegistry
     * @param events
     */
    public EventRegistry(ArrayList<Event> events){
        this.eventsRegistered = deepCopy(events);
    }

    /**
     * Comparator som sammenligner to objekter Event basert paa plass
     *
     */
    private Comparator<Event> comByPlace = new Comparator<Event>() {
        /**
         * Metode som sammenlinger to objekter Event basert paa String plass
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Event o1, Event o2) {

            return o1.getPlace().compareTo(o2.getPlace());
        }
    };
    /**
     * Comparator som sammenligner to objekter Event basert paa tidspunkt
     */
    private Comparator<Event> comByTime = new Comparator<Event>() {
        /**
         * Metode compare som sammenligner to objekter Event basert paa tidspunkt
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Event o1, Event o2) {
            if(o1.getTime() > o2.getTime()){
                return 1;
            }else if(o1.getTime() == o2.getTime()){
                return 0;
            }else{
                return -1;
            }
        }
    };
    /**
     * Comparator som sammenligner to objekter Event basert paa type
     */
    private Comparator<Event> comByType = new Comparator<Event>() {
        /**
         * Compare-metode som sammenligner to objekter Event basert paa type
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Event o1, Event o2) {
            return o1.getType().compareTo(o2.getType());
        }
    };

    /**
     * Comparator som sammenligner to objekter Event basert paa dato og tidspunkt
     */
    private Comparator<Event> comByTimeAndDate = new Comparator<Event>() {
        /**
         * Compare-metode som sammenligner to objekter Event basert paa dato og tidspunkt
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Event o1, Event o2) {
            if(o1.getDateAndTime() > o2.getDateAndTime()){
                return 1;
            }else if(o1.getDateAndTime() == o2.getDateAndTime()){
                return 0;
            }else{
                return -1;
            }
        }
    };

    private ArrayList<Event> eventsRegistered = new ArrayList<Event>();

    /**
     * Metode som registerer nytt event i registeret
     * @param eventToRegister
     */
    public void registerNewEvent(Event eventToRegister){
        for(Event e : eventsRegistered){
            if(e.getNumberId() == eventToRegister.getNumberId()){
                throw new IllegalArgumentException("Event ID already used");
            }
        }
        eventsRegistered.add(new Event(eventToRegister.getNumberId(), eventToRegister.getName(),eventToRegister.getPlace(),eventToRegister.getOrganizer(),eventToRegister.getType(),eventToRegister.getDateAndTime()));
    }

    public ArrayList<Event> getEventsRegistered(){
        return eventsRegistered;
    }

    /**
     * Metode som dypkopierer en ArrayList med Event'er
     * @param listToCopy
     * @return
     */
    private ArrayList<Event> deepCopy(ArrayList<Event> listToCopy){
        ArrayList<Event> copy = new ArrayList<>();
        Iterator<Event> it = listToCopy.iterator();
        while(it.hasNext()){
            Event e = it.next();
            Event newE = new Event(e.getNumberId(), e.getName(), e.getPlace(),e.getOrganizer(),e.getType(),e.getDateAndTime());
            copy.add(newE);
        }
        return copy;
    }

    /**
     * Metode som finner alle events paa gitt plass
     * @param place
     * @return
     */
    public ArrayList<Event> allEventsGivenPlace(String place){
        ArrayList<Event> eventsGivenPlace = new ArrayList<>();

        for(Event element : eventsRegistered){
            if(element.getPlace().equals(place)){
                eventsGivenPlace.add(element);
            }
        }
        if(eventsGivenPlace.size() == 0){
            throw new IllegalArgumentException("None of the events are located at the given place");
        }

        return eventsGivenPlace;
    }

    /**
     * Metode som finner alle events paa gitt dato
     * @param date
     * @return
     */

    public ArrayList<Event> allEventsGivenDate(long date){
        ArrayList<Event> givenDateList = new ArrayList<>();

        for(Event events : eventsRegistered) {
            if (events.getDateAndTime() / 10000 == date) {
                givenDateList.add(events);
            }
        }
        if(givenDateList.size() == 0){
            throw new IllegalArgumentException("Did not find any events on given date");
        }
        return givenDateList;
    }

    /**
     * Metode som finner events i et intervall mellom to gitte datoer
     * @param start
     * @param finish
     * @return
     */
    public ArrayList<Event> eventsGivenDates(long start, long finish){
        ArrayList<Event> givenDates = new ArrayList<>();
        for(Event e : eventsRegistered){
            if(e.getDate() >= start && e.getDate() <= finish){
                givenDates.add(e);
            }
        }

        Collections.sort(givenDates);
        return givenDates;
    }

    /**
     * Metode som sorterer registrerte events basert paa type
     * @return
     */
    public ArrayList<Event> toStringSortByType(){
        Collections.sort(eventsRegistered, comByType);
        return eventsRegistered;
    }


    /**
     * Metode som sorterer registrerte events basert paa plass
     * @return
     */
    public ArrayList<Event> toStringSortedByPlace() {
        Collections.sort(eventsRegistered, comByPlace);
        return eventsRegistered;
    }

    /**
     * Metode som sorterer registrerte events basert paa tidspunkt og dato
     * @return
     */

    public ArrayList<Event> toStringByTimeAndDate(){
        Collections.sort(eventsRegistered, comByTimeAndDate);
        return eventsRegistered;
    }

    /**
     * Metode som returnerer alle evnets mellom to datoer
     * @param start
     * @param finish
     * @return
     */
    public ArrayList<Event> toStringDates(long start, long finish) {
        ArrayList<Event> copy = new ArrayList<>();
        copy = deepCopy(eventsGivenDates(start, finish));
        Collections.sort(copy, comByTime);
        return copy;
    }

}
