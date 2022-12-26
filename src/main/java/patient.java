import java.util.ArrayList;
import java.util.Iterator;

public class patient {
    private String name;
    private String gender;
    private String diseases;
    private long id;
    private int age;
    private int appointmentCount = 0;
    ArrayList<appointment> appointments = new ArrayList<appointment>();

    public patient(String name, String gender, long id, int age) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDiseases() {
        return diseases;
    }

    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getAppointmentCount() {
        return appointmentCount;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public void addAppointment(appointment appointment){
        appointments.add(appointment);
        appointmentCount++;
    }
    public void deleteAppointment(int select){
        appointments.remove(select);
        appointmentCount--;
    }


    public void printAppointments(){
        Iterator<appointment> appointmentIterator = appointments.listIterator();
        int order = 1;

        while (appointmentIterator.hasNext()){
            System.out.print(order + "-) ");
            appointmentIterator.next().appointmentInfo();
            order++;
        }
    }
    boolean enterPatient(long id){
        if (this.id == id) {
            return true;
        }
        else return false;
    }
}
