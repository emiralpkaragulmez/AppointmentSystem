import java.util.ArrayList;

public class patient {
    private String name;
    private String gender;
    private String diseases;
    private long id;
    private int age;

    public patient(String name, String gender, long id, int age) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.age = age;
        ArrayList<appointment> appointments = new ArrayList<appointment>();
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

    //public static void createAppointment(String hospitalName, String departmentName, String doctorName, )


    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public void takeAppointment(){

    }

    boolean enterPatient(int id){
        if (this.id == id) {
            return true;
        }
        else return false;
    }
}
