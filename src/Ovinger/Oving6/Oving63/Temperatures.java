package Ovinger.Oving6.Oving63;

import java.util.Arrays;

public class Temperatures {
    private int[][] temp = {{-3, -5, -3, -3, 1, -2}, {4, 0, 8, 6, 5, 6}, {10, 10, 9, 8, 8, 7}};

    private double[] middleTempEachDay;
    private double[] middleTempEachHour;
    private double middleTempMonth;
    private int[] numberOfDays;

    public double[] middleTempEachDay(){
        middleTempEachDay = new double[3];

        for(int i = 0; i < temp.length; i++){
            double c = 0;
            for(int y = 0; y < temp[i].length; y++){

                c += temp[i][y];

            }
            middleTempEachDay[i] = Math.round((c/temp[i].length) * 10.0)/10.0;
        }
        return getMiddleTempEachDay();
    }

    public double[] getMiddleTempEachDay() {
        return middleTempEachDay;
    }

    public double[] middleTempEachHour(){
        middleTempEachHour = new double[6];
        for(int y = 0; y < middleTempEachHour.length; y++) {
            double c = 0;
            for (int i = 0; i < temp.length; i++) {
                c += temp[i][y];

            }
            middleTempEachHour[y] = Math.round((c/temp[0].length)*10.0)/10.0;
        }
        return getMiddleTempEachHour();
    }

    public double[] getMiddleTempEachHour() {
        return middleTempEachHour;
    }

    public double middleTempMonth(){
        middleTempMonth = 0;
        double c = 0;

        for( int i = 0; i < temp.length; i++){

            for(int y = 0; y < temp[i].length; y++){

                c += temp[i][y];

            }
        }

        middleTempMonth = Math.round((c/(temp[0].length * temp.length)*10.0))/10.0;
        return getMiddleTempMonth();
    }

    public double getMiddleTempMonth() {
        return middleTempMonth;
    }

    public int[] numberOfDaysWith(){

        double[] temp = middleTempEachDay();

        numberOfDays = new int[5];

        for(int i = 0; i < temp.length; i++){

            if(temp[i] < -5){
                numberOfDays[0]++;
            }else if(temp[i] > -5 && temp[i] < 0){
                numberOfDays[1]++;
            }else if(temp[i] > 0 && temp[i] < 5){
                numberOfDays[2]++;
            }else if(temp[i] > 5 && temp[i] < 10){
                numberOfDays[3]++;
            }else if(temp[i] > 10){
                numberOfDays[4]++;
            }
        }
        return getNumberOfDays();
    }

    public int[] getNumberOfDays() {
        return numberOfDays;
    }

    public int[][] getTemp() {
        return temp;
    }

    @Override
    public String toString() {
        return "Temperatures{" +
                " middleTempEachDay=" + Arrays.toString(middleTempEachDay) +
                ", middleTempEachHour=" + Arrays.toString(middleTempEachHour) +
                ", middleTempMonth=" + middleTempMonth +
                ", numberOfDays=" + Arrays.toString(numberOfDays) +
                '}';
    }
}
