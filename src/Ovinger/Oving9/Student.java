package Ovinger.Oving9;

import java.util.Objects;

public class Student {
    private String name;
    private int nmbTasks;

    // konstruktorer, en hvor man tar inn nmbTasks og navn, og en hvor nmbTasks er null
    public Student(String name, int nmbTasks){
        this.name = name;
        this.nmbTasks = nmbTasks;
    }
    public Student(String name){
        this.name = name;
        this.nmbTasks = 0;
    }

    // metode som adder til antall tasks studenten har gjort
    public void addNmbTasks(int add){
        if(add < 0){
            throw new IllegalArgumentException("Can't add negative number of tasks");
        }
        this.nmbTasks += add;
    }

    // get-metoder
    public String getName() {
        return name;
    }

    public int getNmbTasks() {
        return nmbTasks;
    }

    // toString-metode

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nmbTasks=" + nmbTasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return nmbTasks == student.nmbTasks &&
                (name.equals(student.name));
    }

}
