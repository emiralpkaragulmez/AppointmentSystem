import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class system {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        admin adminSystem = new admin(111, "system", 111);
        adminSystem.admins.add(adminSystem);
        adminSystem.insertHospitalSample();



        patient selectedPatient;
        boolean quit = false;
        long patientId = 0;
        boolean patientVerified;
        boolean createNewPatient;
        boolean adminVerified;
        int adminId;
        boolean admin;
        boolean takeAppointmentSelected;
        boolean viewInformation;
        admin selectedAdmin;


        while (!quit) {

            viewInformation = false;
            takeAppointmentSelected = false;
            selectedPatient = null;
            patientVerified = false;
            createNewPatient = false;
            adminVerified = false;
            adminId = 0;
            admin = false;
            selectedAdmin = null;

            System.out.print("""
                    Enter your choice:\s
                    \t1-) Patient Login
                    \t2-) Admin login.
                    \t""");
            int chosenOption = scanner.nextInt();


            switch (chosenOption) {

                case 1:


                    int counter = 0;
                    while (counter != 11) {
                        counter = 0;
                        System.out.print("Enter your id: ");

                        patientId = scanner.nextLong();
                        long tempId = patientId;
                        while (tempId > 0) {
                            tempId /= 10;
                            counter++;
                        }

                        if (counter != 11)
                            System.out.println("Id must 11 digit long.");
                    }

                    Iterator<patient> patientsIterator = adminSystem.patients.listIterator();

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

                    Iterator<admin> adminsIterator = adminSystem.admins.listIterator();

                    while (adminsIterator.hasNext()) {
                        admin tempAdmin = adminsIterator.next();
                        admin = tempAdmin.enterAdmin(adminId, adminPassword);
                        if (admin) {
                            selectedAdmin = tempAdmin;
                            System.out.println("Information are correct");
                            adminVerified = true;
                        }
                    }
                    if (!admin) {
                        System.out.println("Information are incorrect");
                    }
                    break;
            }

            if (createNewPatient) {

                String inputGender;
                String inputName;
                int inputAge;

                System.out.print("Please enter your full name: ");
                scanner.nextLine();
                inputName = scanner.nextLine();
                System.out.print("Please enter your age: ");
                inputAge = scanner.nextInt();
                System.out.print("Please enter your gender: ");
                scanner.nextLine();
                inputGender = scanner.nextLine();

                patientVerified = true;
                selectedPatient = new patient(inputName, inputGender, patientId, inputAge);
                adminSystem.patients.add(selectedPatient);
            }

            if (patientVerified) {
                System.out.print("Enter your choice: \n" + "\t1-) Take an appointment.\n" + "\t2-) View appointments' information.\n\t");
                boolean pass = false;
                while (!pass) {
                    int answer = scanner.nextInt();
                    if (answer == 1) {
                        takeAppointmentSelected = true;
                        pass = true;
                    } else if (answer == 2) {
                        viewInformation = true;
                        pass = true;
                    } else
                        System.out.println("Please enter significant digit.");
                }
            }



            if (takeAppointmentSelected) {

                boolean appointmentApproved = false;
                while (!appointmentApproved) {

                    Iterator<hospital> iteratorHospital = adminSystem.hospitals.listIterator();

                    System.out.println("Enter your hospital: ");
                    int x = 1;
                    while (iteratorHospital.hasNext()) {
                        System.out.print(x + "-) " + (iteratorHospital.next()).getName() + "\n");
                        x++;
                    }
                    int selectedHospital = scanner.nextInt() - 1;
                    hospital selectedAppointmentHospital = adminSystem.hospitals.get(selectedHospital);

                    System.out.println("Enter your department: ");
                    adminSystem.hospitals.get(selectedHospital).printDepartments();
                    int selectedDepartment = scanner.nextInt() - 1;
                    department selectedAppointmentDepartment = selectedAppointmentHospital.departments.get(selectedDepartment);


                    selectedAppointmentDepartment.printDoctors();
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


                    ArrayList<appointmentDate> availableAppointmentDates = selectedAppointmentDoctor.returnAvailableAppointmentsForSelectedDate(chosenAppointmentDay, chosenAppointmentMonth, chosenAppointmentYear);
                    Iterator<appointmentDate> printNamesOfAppointmentDates = availableAppointmentDates.listIterator();
                    int order = 1;
                    while (printNamesOfAppointmentDates.hasNext()) {
                        System.out.println(order + "-) " + printNamesOfAppointmentDates.next().getName());
                        order++;
                    }
                    System.out.println("Enter appointment you would like to choose: ");
                    int chosenAppointmentDate = scanner.nextInt();
                    appointmentDate selectedAppointmentDate = availableAppointmentDates.get(chosenAppointmentDate);
                    selectedAppointmentDate.setAvailable(false);

                    selectedPatient.addAppointment(new appointment(selectedAppointmentDate.getName(),
                            selectedAppointmentHospital.getName(), selectedAppointmentDepartment.getName(),
                            selectedAppointmentDoctor.getName(), selectedAppointmentDate.getAppointmentDate()));


                    selectedPatient.appointments.get(selectedPatient.getAppointmentCount() - 1).appointmentInfo();
                    System.out.println("Is all appointment information is correct?");
                    scanner.nextLine();

                    boolean answerPass = false;
                    while (!answerPass) {
                        String isAnswerCorrect = scanner.nextLine();

                        if (isAnswerCorrect.equals("Yes")) {
                            System.out.println("Your appointment has created?");
                            appointmentApproved = true;
                            answerPass = true;

                        } else if (isAnswerCorrect.equals("No")) {
                            selectedPatient.appointments.remove(selectedPatient.getAppointmentCount() - 1);
                            System.out.println("Please select new choices for appointment");
                            answerPass = true;
                        } else {
                            System.out.println("Please answer with Yes or No.");
                        }
                    }
                }
            }

            if (viewInformation) {
                if (selectedPatient.getAppointmentCount() > 0) {

                    selectedPatient.printAppointments();

                    System.out.println("Would you like to cancel your appointment? ");
                    boolean pass = false;
                    while (!pass) {
                        String answer = scanner.nextLine();
                        if (answer.equals("Yes")) {

                            selectedPatient.printAppointments();
                            System.out.println("Which Appointment would you like to cancel?");
                            boolean pass2 = false;
                            while (!pass2) {
                                int answer2 = scanner.nextInt();
                                int appointmentCount = selectedPatient.appointments.size();
                                if (answer2 > 0 && answer2 <= appointmentCount) {
                                    pass2 = true;
                                    selectedPatient.deleteAppointment(answer2 - 1);
                                } else
                                    System.out.println("Please enter valid digit between 0 - " + appointmentCount + ".");
                            }

                            pass = true;
                        } else if (answer.equals("No")) {
                            pass = true;
                        } else
                            System.out.println("Please answer with only 'Yes' or 'No'");
                    }

                } else {
                    System.out.println("You dont have any appointment.");

                }

            }

            if (adminVerified) {
                System.out.print("Enter your choice: \n\t1-) Make changes in the database.\n \t2-) Shut down the system.\n");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter your choice: \n\t1-) Add new hospital.\n \t2-) Delete hospital.\n" +
                                "\t3-) Add new department.\n\t4-) Delete department.\n\t5-) Add new doctor.\n" +
                                "\t6-) Delete doctor.");

                        int choice2 = scanner.nextInt();

                        switch (choice2) {
                            case 1:
                                selectedAdmin.addHospital();
                                break;
                            case 2:
                                selectedAdmin.deleteHospital();
                                break;
                            case 3:
                                selectedAdmin.addDepartment();
                                break;
                            case 4:
                                selectedAdmin.deleteDepartment();
                                break;
                            case 5:
                                selectedAdmin.addDoctor();
                                break;
                            case 6:
                                selectedAdmin.deleteDoctor();
                                break;
                        }
                        break;
                    case 2:
                        quit = true;
                        break;


                }


            }
        }

    }
}
