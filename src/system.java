import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class system {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<patient> patients = new ArrayList<patient>();
        ArrayList<admin> admins = new ArrayList<admin>();

        admin adminEmir = new admin(339,"emir",123);
        admins.add(adminEmir);


        hospital bezmialem = new hospital("bezmialem", "valide sultan");




        bezmialem.addDepartment("Dahiliye"); // index 0 department
        bezmialem.addDepartment("KBB");      // index 1 department
        bezmialem.addDepartment("Üroloji");  // index 2 department


        bezmialem.departments.get(0).addDoctor("muzaffer", 40,10,"erkek");
        bezmialem.departments.get(0).addDoctor("ayşe", 40,10,"erkek");
        bezmialem.departments.get(1).addDoctor("asya", 40,10,"erkek");
        bezmialem.departments.get(1).addDoctor("emir", 40,10,"erkek");
        bezmialem.departments.get(2).addDoctor("mustafa", 40,10,"erkek");
        bezmialem.departments.get(2).addDoctor("ayberk", 40,10,"erkek");


        boolean quit = false;
        int patientId = 0;
        boolean patientVerified = false;
        boolean createNewPatient = false;
        boolean adminVerified = false;
        int adminId = 0;
        boolean admin = false;
        while (!quit){

            patientVerified = false;
            createNewPatient = false;
            adminVerified = false;
            adminId = 0;
            admin = false;

            System.out.print("Enter your choice: \n" + "\t1-) Take An Appointment\n" + "\t2-) Admin panel.\n\t" );
            int chosenOption = scanner.nextInt();




            switch (chosenOption){

                case 1:
                    System.out.print("Enter your id: ");
                    patientId = scanner.nextInt();

                    Iterator<patient> patientsIterator = patients.listIterator();

                    while (patientsIterator.hasNext()) {
                        if (patientsIterator.next().enterPatient(patientId)) {
                            patientVerified = true;
                        }
                    }
                    if (patientVerified) {
                        System.out.println("Patient selected.");
                        break;
                    }
                    System.out.println("Please fill information section to take an appointment.");
                    createNewPatient = true;
                    break;
                case 2:
                    System.out.print("Enter your admin id: ");
                    adminId = scanner.nextInt();
                    System.out.print("\nEnter your password: ");
                    int adminPassword = scanner.nextInt();

                    Iterator<admin> adminsIterator = admins.listIterator();

                    while (adminsIterator.hasNext()) {
                        admin = adminsIterator.next().enterAdmin(adminId, adminPassword);
                        if (admin == true) {
                            System.out.println("Information are correct");
                            adminVerified = true;
                        }
                    }
                    if (!admin){
                        System.out.println("Information are incorrect");
                    }
                    break;
            }

            if (createNewPatient){

                String inputGender;
                String inputName;
                int inputAge;

                System.out.print("Please enter your name: ");
                scanner.nextLine();
                inputName = scanner.nextLine();
                System.out.print("Please enter your age: ");
                inputAge = scanner.nextInt();
                System.out.print("Please enter your gender: ");
                scanner.nextLine();
                inputGender = scanner.nextLine();

                patientVerified = true;

                patients.add(new patient(inputName, inputGender, patientId, inputAge));
            }

            if (patientVerified){

                bezmialem.printDepartments();
                System.out.println("Enter your department: ");
                int selectedDepartment = scanner.nextInt();

                bezmialem.departments.get(selectedDepartment - 1).printDoctors();
                System.out.println("Enter your doctor: ");
                int selectedDoctor = scanner.nextInt();

                System.out.println("Enter the date you would like have an appointment.");
                System.out.print("Enter appointment year (2022 or 2023): ");
                int chosenAppointmenYear = scanner.nextInt();
                System.out.print("Enter appointment month (1 to 12): ");
                int chosenAppointmenMonth = scanner.nextInt();
                System.out.print("Enter appointment day (1 to 30): ");
                int chosenAppointmenDay = scanner.nextInt();



                bezmialem.departments.get(selectedDepartment - 1).doctors.get(selectedDoctor - 1).printAvailableAppointmentsForSelectedDate(chosenAppointmenDay,chosenAppointmenMonth,chosenAppointmenYear);
                System.out.println("Enter appointment you would like to choose: ");
                int chosenAppointmentDate = scanner.nextInt();


            }

        }

    }
}
