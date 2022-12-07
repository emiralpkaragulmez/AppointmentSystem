import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class system {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<patient> patients = new ArrayList<patient>();
        ArrayList<admin> admins = new ArrayList<admin>();
        ArrayList<hospital> hospitals = new ArrayList<hospital>();

        admin adminEmir = new admin(339,"emir",123);
        admins.add(adminEmir);


        hospital bezmialem = new hospital("bezmialem", "valide sultan");
        hospitals.add(bezmialem);


        bezmialem.addDepartment("Dahiliye"); // index 0 department
        bezmialem.addDepartment("KBB");      // index 1 department
        bezmialem.addDepartment("Üroloji");  // index 2 department


        bezmialem.departments.get(0).addDoctor("muzaffer", 40,10,"erkek");
        bezmialem.departments.get(0).addDoctor("ayşe", 40,10,"erkek");
        bezmialem.departments.get(1).addDoctor("asya", 40,10,"erkek");
        bezmialem.departments.get(1).addDoctor("emir", 40,10,"erkek");
        bezmialem.departments.get(2).addDoctor("mustafa", 40,10,"erkek");
        bezmialem.departments.get(2).addDoctor("ayberk", 40,10,"erkek");

        patient selectedPatient = null;
        boolean quit = false;
        int patientId = 0;
        boolean patientVerified = false;
        boolean createNewPatient = false;
        boolean adminVerified = false;
        int adminId = 0;
        boolean admin = false;

        while (!quit){

            selectedPatient = null;
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
                        patient tempPatient = patientsIterator.next();
                        if (tempPatient.enterPatient(patientId)) {
                            patientVerified = true;
                            selectedPatient = tempPatient;
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
                selectedPatient = new patient(inputName, inputGender, patientId, inputAge);
                patients.add(selectedPatient);
            }

            if (patientVerified){

                Iterator<hospital> iteratorHospital = hospitals.listIterator();

                int x = 1;
                while (iteratorHospital.hasNext()){
                    System.out.print(x + "-) " + (iteratorHospital.next()).getName() + "\n");
                    x++;
                }
                System.out.println("Enter your hospital: ");
                int selectedHospital = scanner.nextInt() - 1;
                hospital selectedAppointmentHospital = hospitals.get(selectedHospital);


                bezmialem.printDepartments();
                System.out.println("Enter your department: ");
                int selectedDepartment = scanner.nextInt() - 1;
                 department selectedAppointmentDepartment = selectedAppointmentHospital.departments.get(selectedDepartment);


                bezmialem.departments.get(selectedDepartment).printDoctors();
                System.out.println("Enter your doctor: ");
                int selectedDoctor = scanner.nextInt() - 1;
                doctor selectedAppointmentDoctor = selectedAppointmentDepartment.doctors.get(selectedDoctor);


                System.out.println("Enter the date you would like have an appointment.");
                System.out.print("Enter appointment year (2022 or 2023): ");
                int chosenAppointmentYear = scanner.nextInt();
                System.out.print("Enter appointment month (1 to 12): ");
                int chosenAppointmentMonth = scanner.nextInt();
                System.out.print("Enter appointment day (1 to 30): ");
                int chosenAppointmentDay = scanner.nextInt();




                ArrayList<appointmentDate> availableAppointmentDates = selectedAppointmentDoctor.returnAvailableAppointmentsForSelectedDate(chosenAppointmentDay,chosenAppointmentMonth,chosenAppointmentYear);
                Iterator<appointmentDate> printNamesOfAppointmentDates = availableAppointmentDates.listIterator();
                int order = 1;
                while (printNamesOfAppointmentDates.hasNext()){
                    System.out.println(order + "-) " + printNamesOfAppointmentDates.next().getName());
                    order++;
                }
                System.out.println("Enter appointment you would like to choose: ");
                int chosenAppointmentDate = scanner.nextInt();
                appointmentDate selectedAppointmentDate = availableAppointmentDates.get(chosenAppointmentDate);
                selectedAppointmentDate.setAvailable(false);

                selectedPatient.addAppointment(new appointment(selectedAppointmentDate.getName(),
                        selectedAppointmentHospital.getName(),selectedAppointmentDepartment.getName(),
                        selectedAppointmentDoctor.getName(), selectedAppointmentDate.getAppointmentDate()));

                System.out.println("Would you like to print your appointments' information?");

                boolean pass = false;

                while (!pass) {
                    String answer = scanner.nextLine();

                    if (answer.equals("Yes")) {
                        selectedPatient.printAppointments();
                        pass = true;
                    }
                    else if (answer.equals("No"))
                        pass = true;
                    else
                        System.out.println("Please answer with Yes or No.");
                }
            }

        }

    }
}
