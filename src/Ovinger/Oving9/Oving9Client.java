package Ovinger.Oving9;

import java.util.Arrays;

public class Oving9Client {
    public static void main(String[] args) {
        Student olav = new Student("Olav", 2);
        Student lars = new Student("Lars");


        TaskOverview test = new TaskOverview(new Student[]{olav, lars});


        System.out.println(test.nmbOfTasksSpesStudent(olav));
        Student ken = new Student("Ken");
        test.registerNewStudent(ken);
        test.addNmbTasksStudent(olav, 3);
        System.out.println(test.nmbOfTasksSpesStudent(olav));
        System.out.println(Arrays.toString(test.getStudents()));
        System.out.println(test.toString());





        if(olav.getName().equals("Olav")){
            System.out.println("Test 1 complete");
        }
        if(lars.getNmbTasks() == 0){
            System.out.println("Test 2 complete");
        }
        if(olav.getNmbTasks() != lars.getNmbTasks()){
            System.out.println("Test 3 complete");
        }
        olav.addNmbTasks(2);
        if(olav.getNmbTasks() != 2 && olav.getNmbTasks() == 4){
            System.out.println("Test 4 complete");
        }

    }

}
