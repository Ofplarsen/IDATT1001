package Ovinger.Oving10.Oving101;

/**
 * Klassen Event
 * @version 1.01 2020-10-22
 */
public class Event implements Comparable<Event>{
    private int numberId;
    private String name;
    private String place;
    private String organizer;
    private String type;
    private long dateAndTime;

    /**
     * Konstruktor som oppretter et objekt av typen Event
     * @param numberId
     * @param name
     * @param place
     * @param organizer
     * @param type
     * @param dateAndTime
     */
    public Event(int numberId, String name, String place, String organizer, String type, long dateAndTime){
        this.numberId = numberId;
        this.name = name;
        this.place = place;
        this.organizer = organizer;
        this.type = type;
        this.dateAndTime = dateAndTime;
    }

    public int getNumberId() {
        return numberId;
    }

    /**
     * Metode som returnerer datoen til Eventet
     * @return
     */
    public long getDate(){
        return dateAndTime/10000;
    }

    /**
     * Metode som returnerer tidspunktet til Eventet
     * @return
     */
    public long getTime(){
        return dateAndTime - (dateAndTime/10000)*10000;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getType() {
        return type;
    }

    public long getDateAndTime() {
        return dateAndTime;
    }

    /**
     * ToString-metode for Event, hvor attributene blir returnert i en streng
     * @return
     */

    @Override
    public String toString() {
        return "Event{" +
                "numberId=" + numberId +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", organizer='" + organizer + '\'' +
                ", type='" + type + '\'' +
                ", dateAndTime=" + dateAndTime +
                '}';
    }

    /**
     * Metode som sammenligner objektets tid med tiden til parameteret
     * @param o
     * @return
     */
    @Override
    public int compareTo(Event o) {

        if(this.getTime() > o.getTime()){
            return 1;
        }else if(this.getTime() == o.getTime()){
            return 0;
        }else{
            return -1;
        }
    }
}
