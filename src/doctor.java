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
                    for (int hour = 7; hour <= 15; hour++ ){
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

    public void printAvailableAppointmentsForSelectedDate(int day, int month, int year){
        Iterator<appointmentDate> iterator = appointmentDates.listIterator();
        int x = 1;
        while (iterator.hasNext()){
            x = (iterator.next()).printAvailableNamesForSelectedDate(day, month, year, x);
        }

    }
    public void printAvailableAppointmentDate(){
        Iterator<appointmentDate> iterator = appointmentDates.listIterator();
        while (iterator.hasNext()){
            (iterator.next()).printAvailableName();
        }
        appointmentDate.setOrderDisplayer(1);
    }
}
