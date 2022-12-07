import java.util.ArrayList;
import java.util.Iterator;

public class admin extends adminPanel{
    long id;
    String name;
    int password;
    ArrayList<hospital> hospitals = new ArrayList<hospital>();

    public admin(long id, String name, int password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    boolean enterAdmin(long id,int password){
        if (this.id == id && this.password == password) {
            return true;
        }
        else return false;
    }

    void addHospital(String hospitalName, String founderName){
        hospitals.add(new hospital(hospitalName,founderName));
    }

    void addDepartment(String hospitalName, String name){
        Iterator<hospital> hospitalIterator = hospitals.listIterator();

        while (hospitalIterator.hasNext()){
            hospital tempHolder = hospitalIterator.next();
            if (tempHolder.getName() == hospitalName){
                tempHolder.departments.add(new department(name));
            }
        }
    }

    void addDoctor(){

    }

}
