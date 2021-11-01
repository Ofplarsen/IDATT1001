package Ovinger.Oving8.Oving81;

public class Person {

    private String firstname;
    private String surname;
    private int yearBorn;

    public Person(String firstname,String surname, int yearBorn){
        this.firstname = firstname;
        this.surname = surname;
        this.yearBorn = yearBorn;

    }

    public String getFirstname(){
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public int getYearBorn() {
        return yearBorn;
    }
}
