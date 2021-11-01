package Ovinger.Oving8.Oving81;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Employee {
    private static GregorianCalendar Calendar = new java.util.GregorianCalendar();
    private static int year = Calendar.get(java.util.Calendar.YEAR);

    private Person personalia;
    private int employeeNumb;
    private int yearEmployed;
    private double monthlyWage;
    private double taxPercent;

    public Employee(Person personalia, int employeeNumb, int yearEmployed, double monthlyWage, double taxPercent){
        this.personalia = new Person(personalia.getFirstname(), personalia.getSurname(), personalia.getYearBorn());
        this.employeeNumb = employeeNumb;
        this.yearEmployed = yearEmployed;
        this.monthlyWage = roundToTwo(monthlyWage);
        this.taxPercent = taxPercent;
    }

    public String testClass(){
        String str = "Tax per month: " + taxPerMonth() + "\n" +
                "Yearly wage before tax: " + yearlyWage() + "\n" +
                "Tax per year: " + yearlyTax() + "\n" +
                "Employee name: " + getName() + "\n" +
                "Age: " + getAge() + "\n" +
                "Years in company: " + getYearsInCompany() + "\n" +
                "Person hired more than x(10) years: " + moreThanYears(10);
        return str;
    }

    public double roundToTwo(double numberToRound){
        return numberToRound;
    }



    public double taxPerMonth(){
        double taxPerMonth = roundToTwo(monthlyWage*(taxPercent/100));

        return taxPerMonth;
    }

    public double yearlyWage(){
        double yearlyWage = Math.round(12 * monthlyWage);

        return yearlyWage;
    }

    public double yearlyTax(){
        double yearlyTax = Math.round((10 * taxPerMonth()) + (taxPerMonth() / 2));

        return roundToTwo(yearlyTax);
    }

    public String getName(){
        String name = personalia.getSurname() + ", " + personalia.getFirstname();
        return name;
    }

    public int getAge(){
        int age = year - personalia.getYearBorn();
        return age;
    }

    public int getYearsInCompany(){
        int yearsInCompany = year - yearEmployed;
        return yearsInCompany;
    }

    public boolean moreThanYears(int years){
        return years < getYearsInCompany();
    }

    public String getPersonalia() {
        String str = personalia.getSurname() + ", " + personalia.getFirstname() + ", " + personalia.getYearBorn();
        return str;
    }

    public int getEmployeeNumb() {
        return employeeNumb;
    }

    public int getYearEmployed() {
        return yearEmployed;
    }

    public double getMonthlyWage() {
        return monthlyWage;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setMonthlyWage(int monthlyWage) {
        this.monthlyWage = monthlyWage;
    }

    public void setTaxPercent(int taxPercent) {
        this.taxPercent = taxPercent;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "personalia=" + getName() + ", " + personalia.getYearBorn() +
                ", employeeNumb=" + employeeNumb +
                ", yearEmployed=" + yearEmployed +
                ", monthlyWage=" + monthlyWage +
                ", taxPercent=" + taxPercent +
                ", " + "yearlyWage= "  + yearlyWage() +
                ", " + "yearlyTax= " + yearlyTax() +
                '}';
    }

}
