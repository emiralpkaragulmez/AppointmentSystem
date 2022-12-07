import java.util.ArrayList;
import java.util.Iterator;

public class patient {
    private String name;
    private String gender;
    private String diseases;
    private long id;
    private int age;
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


    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public void addAppointment(appointment appointment){
        appointments.add(appointment);
    }

    public void printAppointments(){
        Iterator<appointment> appointmentIterator = appointments.listIterator();

        while (appointmentIterator.hasNext()){
            appointmentIterator.next().appointmentInfo();

        }
    }
    boolean enterPatient(int id){
        if (this.id == id) {
            return true;
        }
        else return false;
    }
}
