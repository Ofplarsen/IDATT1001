package Ovinger.Oving9;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskOverview {
    private Student[] students;
    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private int numbOfStud = 0;

    // Konstruktor hvor man tar inn ulike studenter i en tabell
    public TaskOverview(Student[] students){
        this.numbOfStud = students.length;
        this.students = new Student[numbOfStud];

        for(int i = 0; i < numbOfStud; i++){
            this.students[i] = students[i];
        }
    }
    //registrerer ny student, kopiere den eksisterende tabellen og legger til den nye studenten paa slutten
    public void registerNewStudent(Student newStudent){
        this.numbOfStud += 1;
        Student[] student = new Student[numbOfStud];

        for(int i = 0; i < numbOfStud-1; i++){
            student[i] = this.students[i];
        }
        student[numbOfStud-1] = newStudent;

        this.students = student;

        studentArrayList.add(newStudent);
    }

    // add number tasks Student
    public boolean addNmbTasksStudent(Student student, int numberOfTasksToAdd){
        for(Student student1 : students){
            if(student1.equals(student)){
                student1.addNmbTasks(numberOfTasksToAdd);
                return true;
            }
        }
        return false;
    }

    // Metode for aa finne ut hvor mange tasks en bestemt student har gjennomfort.
    public int nmbOfTasksSpesStudent(Student student){
        return student.getNmbTasks();
    }

    // get-metoder
    public int getNumbOfStud() {
        return numbOfStud;
    }

    public String[] getStudents(){
        String[] str = new String[numbOfStud];
        for(int i = 0; i < numbOfStud; i++){
            str[i] = (students[i].getName());
        }
        return str;
    }

    @Override
    public String toString() {
        return "TaskOverview{" +
                "students=" + Arrays.toString(students) +
                ", numbOfStud=" + numbOfStud +
                '}';
    }
}
