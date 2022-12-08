import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class admin extends adminPanel{
    long id;
    String name;
    int password;
    ArrayList<hospital> hospitals = new ArrayList<hospital>();
    Scanner scanner = new Scanner(System.in);

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

    void addHospital(){
        System.out.print("Please enter new hospital's name: ");

        String hospitalName = scanner.nextLine();

        System.out.print("Please enter founder's name of new hospital: ");

        String founderName = scanner.nextLine();

        hospitals.add(new hospital(hospitalName,founderName));
    }
    void addDepartment(){
        Iterator<hospital> iteratorHospital = hospitals.listIterator();
        System.out.println("Which hospital are you going add department?");

        int x = 1;
        while (iteratorHospital.hasNext()){
            System.out.print(x + "-) " + (iteratorHospital.next()).getName() + "\n");
            x++;
        }

        int answer = scanner.nextInt();

        System.out.print("Please enter department name: ");
        scanner.nextLine();
        String departmentName = scanner.nextLine();

        hospitals.get(answer - 1).addDepartment(departmentName);
    }


    void addDoctor(){
        Iterator<hospital> hospitalIterator = hospitals.listIterator();
        System.out.println("Select hospital.");

        int x = 1;
        while (hospitalIterator.hasNext()){
            System.out.print(x + "-) " + (hospitalIterator.next()).getName() + "\n");
            x++;
        }

        int hospitalAnswer = scanner.nextInt();

        System.out.println("Which department are you going add doctor?");
        hospitals.get(hospitalAnswer - 1).printDepartments();

        int  departmentAnswer = scanner.nextInt();

        System.out.print("Please enter doctor's name: ");
        scanner.nextLine();
        String nameOfDoctor = scanner.nextLine();

        System.out.print("Please enter doctor's age: ");
        int doctorAge = scanner.nextInt();

        System.out.print("Please enter how long doctor have been doing it's job: ");
        int doctorExperience = scanner.nextInt();

        System.out.print("Please enter what is the doctor's gender: ");
        scanner.nextLine();
        String doctorGender = scanner.nextLine();

        //hospitals.get(hospitalAnswer - 1).departments.get(departmentAnswer - 1).addDoctor(nameOfDoctor, doctorAge, doctorExperience, doctorGender);
    }





}
