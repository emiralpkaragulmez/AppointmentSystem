import java.util.ArrayList;
import java.util.Iterator;

public class doctor {
    private String name;
    private int age;
    private int yearOfExperience;
    private String gender;
    int totalAppointmentCount = 0;
    ArrayList<appointmentDate> appointmentDates = new ArrayList<appointmentDate>();

    public doctor(String name) {
        this.name = name;
    }

    public doctor(String name, int age, int yearOfExperience, String gender) {
        this.name = name;
        this.age = age;
        this.yearOfExperience = yearOfExperience;
        this.gender = gender;
        addAppointmentDate();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public String getGender() {
        return gender;
    }


    public void addAppointmentDate(){

        for (int year = 2022; year <= 2023; year++){
            for (int month = 1; month <=12; month++){
                for (int day = 1; day <= 30; day++){
                    for (int hour = 7; hour <= 17; hour++ ){
                        for (int minute = 00; minute <= 30; minute+=30){
                            String name = ("Appointment of " + day + "." + month + "." + year + " - " +
                                    hour + ":" + minute);
                            appointmentDates.add(new appointmentDate(day,month,year,hour,minute,name,true));
                            totalAppointmentCount++;
                        }
                    }
                }
            }
        }
    }

    public ArrayList returnAvailableAppointmentsForSelectedDate(int day, int month, int year){
        ArrayList<appointmentDate> availableAppointmentDateForSelectedDate = new ArrayList<appointmentDate>();
        Iterator<appointmentDate> iterator = appointmentDates.listIterator();
        appointmentDate tempHolder;
        boolean check;
        int x = 1;
        while (iterator.hasNext()){
            tempHolder = iterator.next();
            check = tempHolder.checkAvailableNamesForSelectedDate(day, month, year, x);
            if (check == true){
                availableAppointmentDateForSelectedDate.add(tempHolder);
            }
        }
        return availableAppointmentDateForSelectedDate;
    }
}
