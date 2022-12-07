import java.util.ArrayList;
import java.util.Iterator;

public class hospital {
    private String name;
    private String founder;
    private int departmentsNumber = 0;
    ArrayList<department> departments = new ArrayList<department>();

     hospital(String name, String founder) {
        this.name = name;
        this.founder = founder;

    }

    public String getName() {
        return name;
    }

    public String getFounder() {
        return founder;
    }

    public int getDepartmentsNumber() {
        return departmentsNumber;
    }

    public void addDepartment(String name){
        department newDepartment = new department(name);
        departments.add(newDepartment);
        departmentsNumber++;
    }

    public void printDepartments(){
        Iterator<department> iterator = departments.listIterator();

        int x = 1;
        while (iterator.hasNext()){
            System.out.print(x + "-) " + (iterator.next()).getName() + "\n");
            x++;
        }
    }




}
