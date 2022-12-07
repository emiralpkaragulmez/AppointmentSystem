import java.util.ArrayList;
import java.util.Iterator;

public class department {
    private String name;
    private String headOfDepartment;
    private int doctorsNumber;
    ArrayList<doctor> doctors = new ArrayList<doctor>();

    public department(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public int getDoctorsNumber() {
        return doctorsNumber;
    }

    public void addDoctor(String name, int age, int yearOfExperience, String gender){
        doctor newDoctor = new doctor(name, age, yearOfExperience, gender);
        doctors.add(newDoctor);
        doctorsNumber++;
    }

    public void printDoctors(){
        Iterator<doctor> iterator = doctors.listIterator();
        int x = 1;

        while (iterator.hasNext()){
            System.out.print(x + "-) " + (iterator.next()).getName() + "\n");
            x++;
        }
    }


}
