import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

abstract class adminPanel extends simpleDatabaseSample{
    Scanner scanner = new Scanner(System.in);


    void addHospital(){
        System.out.print("Please enter new hospital's name: ");

        String hospitalName = scanner.nextLine();

        System.out.print("Please enter founder's name of new hospital: ");

        String founderName = scanner.nextLine();

        hospitals.add(new hospital(hospitalName,founderName));
    }

    void deleteHospital(){
        System.out.println("Which hospital are you going delete?");

        printHospitals();

        int answer = scanner.nextInt();
        hospitals.remove(answer - 1);
    }


    void addDepartment(){
        System.out.println("Which hospital are you going add department?");
        printHospitals();

        int answer = scanner.nextInt();

        System.out.print("Please enter department name: ");
        scanner.nextLine();
        String departmentName = scanner.nextLine();

        hospitals.get(answer - 1).addDepartment(departmentName);
    }

    void deleteDepartment(){
        System.out.println("Select hospital: ");
        printHospitals();

        int answer = scanner.nextInt();

        System.out.println("Which department are you going to delete?");
        hospitals.get(answer - 1).printDepartments();

        int answer2 = scanner.nextInt();
        hospitals.get(answer - 1).departments.remove(answer2 - 1);
    }

    void addDoctor(){
        System.out.println("Select hospital.");

        printHospitals();

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

        hospitals.get(hospitalAnswer - 1).departments.get(departmentAnswer - 1).addDoctor(nameOfDoctor, doctorAge, doctorExperience, doctorGender);
    }

    void deleteDoctor(){

        System.out.println("Select hospital: ");
        printHospitals();

        int answer = scanner.nextInt();

        System.out.println("Select department: ");
        hospitals.get(answer - 1).printDepartments();

        int answer2 = scanner.nextInt();

        System.out.println("Which doctor are you going to delete?");
        hospitals.get(answer - 1).departments.get(answer2 - 1).printDoctors();
        int answer3 = scanner.nextInt();

        hospitals.get(answer - 1).departments.get(answer2 - 1).doctors.remove(answer3 - 1);
    }

    void printHospitals(){
        Iterator<hospital> Iterator = hospitals.listIterator();

        int x = 1;
        while (Iterator.hasNext()){
            System.out.print(x + "-) " + (Iterator.next()).getName() + "\n");
            x++;
        }

    }

}
