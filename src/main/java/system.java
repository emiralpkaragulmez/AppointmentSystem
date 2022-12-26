
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class system {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        admin adminSystem = new admin(111, "system", 111);
        adminSystem.admins.add(adminSystem);
        adminSystem.insertHospitalSample();


        patient selectedPatient = null;
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
        boolean runScenario = true;


        while (!quit) {

            viewInformation = false;
            takeAppointmentSelected = false;
            patientVerified = false;
            createNewPatient = false;
            adminVerified = false;
            admin = false;
            selectedAdmin = null;
            int chosenOption = 3;


            if (!runScenario) {
                System.out.print("""
                        Enter your choice:\s
                        \t1-) Patient Login
                        \t2-) Admin login.
                        \t3-) Run 'Use Case 1' Scenario Again
                        \t""");
                chosenOption = scanner.nextInt();
            }

            if (chosenOption == 3) {
                runScenario = true;
                chosenOption = 1;
                if (selectedPatient != null && selectedPatient.appointments.size() != 0) {
                    selectedPatient.appointments.remove(0);
                }
                System.out.println("""
                        Patient comes to the kiosk at the hospital to take an appointment
                        Patient choose 'Take An Appointment choice'
                        Patient Enter ID : 33943443924
                        """);
            }

            selectedPatient = null;

            switch (chosenOption) {

                case 1:


                    int counter = 0;
                    while (counter != 11) {
                        counter = 0;
                        if (!runScenario) {
                            System.out.print("Enter your id: ");
                            patientId = scanner.nextLong();
                        }
                        if (runScenario) {
                            String input = "33943443924";
                            patientId = Long.parseLong(input);
                        }
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
                    System.out.println("There isn't any patient with the ID please fill your information to take an appointment ");
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
                String inputName = "";
                int inputAge;
                System.out.println();
                System.out.print("Please enter your full name: ");
                if (!runScenario) {
                    scanner.nextLine();
                    inputName = scanner.nextLine();
                }
                if (runScenario) {
                    System.out.println();
                    System.out.println("Patient entered his name 'Emir Alp Karagulmez'");
                    inputName = "Emir Alp Karagulmez";
                    System.out.println();
                }
                System.out.print("Please enter your age: ");
                inputAge = 0;
                inputGender = "";

                if (!runScenario) {
                    inputAge = scanner.nextInt();
                }
                if (runScenario) {
                    System.out.println();
                    System.out.println("Patient entered his age '22'");
                    inputAge = 22;
                    System.out.println();
                }

                System.out.print("Please enter your gender: ");
                if (!runScenario) {
                    scanner.nextLine();
                    inputGender = scanner.nextLine();
                }
                if (runScenario) {
                    System.out.println();
                    System.out.println("Patient entered his gender 'Male'");
                    inputGender = "Male";
                    System.out.println();
                }
                patientVerified = true;
                selectedPatient = new patient(inputName, inputGender, patientId, inputAge);
                adminSystem.patients.add(selectedPatient);
            }

            if (patientVerified) {
                System.out.print("""
                        Enter your choice:\s
                        \t1-) Take an appointment.
                        \t2-) View appointments' information.
                        \t""");
                boolean pass = false;
                if (!runScenario) {
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
                if (runScenario) {
                    System.out.print("Patient choosed first choice.");
                    takeAppointmentSelected = true;
                    pass = true;
                    System.out.println();
                }
            }


            if (takeAppointmentSelected) {

                boolean appointmentApproved = false;
                while (!appointmentApproved) {

                    Iterator<hospital> iteratorHospital = adminSystem.hospitals.listIterator();
                    System.out.println();
                    System.out.println("Enter your hospital: ");
                    int x = 1;
                    while (iteratorHospital.hasNext()) {
                        System.out.print("\t" + x + "-) " + (iteratorHospital.next()).getName() + "\n");
                        x++;
                    }
                    int selectedHospital = 0;
                    if (!runScenario) {
                        selectedHospital = scanner.nextInt() - 1;
                    }
                    if (runScenario) {
                        System.out.println("Patient choosed first choice.");
                        System.out.println();
                    }
                    hospital selectedAppointmentHospital = adminSystem.hospitals.get(selectedHospital);

                    System.out.println("Enter your department: ");
                    adminSystem.hospitals.get(selectedHospital).printDepartments();
                    int selectedDepartment = 0;
                    if (!runScenario) {
                        selectedDepartment = scanner.nextInt() - 1;
                    }
                    if (runScenario) {
                        System.out.println("Patient choosed 'Interial Medicine' department");
                        System.out.println();
                    }
                    department selectedAppointmentDepartment = selectedAppointmentHospital.departments.get(selectedDepartment);

                    System.out.println("Enter your doctor: ");
                    selectedAppointmentDepartment.printDoctors();
                    int selectedDoctor = 1;
                    if (!runScenario) {
                        selectedDoctor = scanner.nextInt() - 1;
                    }
                    if (runScenario) {
                        System.out.println("Patient choosed 'IMRAN TOKMAKOGLU'");
                        System.out.println();
                    }
                    doctor selectedAppointmentDoctor = selectedAppointmentDepartment.doctors.get(selectedDoctor);


                    System.out.println("Enter the date you would like have an appointment.");
                    System.out.print("Enter appointment year (2022 or 2023): ");
                    int chosenAppointmentYear = 2023;
                    if (!runScenario) {
                        chosenAppointmentYear = scanner.nextInt();
                    }
                    if (runScenario) {
                        System.out.println("Patient choosed '2023'");
                        System.out.println();
                    }
                    System.out.print("Enter appointment month (1 to 12): ");
                    int chosenAppointmentMonth = 3;
                    if (!runScenario) {
                        chosenAppointmentMonth = scanner.nextInt();
                    }
                    if (runScenario) {
                        System.out.println("Patient choosed '3'");
                        System.out.println();
                    }
                    System.out.print("Enter appointment day (1 to 30): ");
                    int chosenAppointmentDay = 25;
                    if (!runScenario) {
                        chosenAppointmentDay = scanner.nextInt();
                    }
                    if (runScenario) {
                        System.out.println("Patient choosed '25'");
                        System.out.println();
                    }

                    ArrayList<appointmentDate> availableAppointmentDates = selectedAppointmentDoctor.returnAvailableAppointmentsForSelectedDate(chosenAppointmentDay, chosenAppointmentMonth, chosenAppointmentYear);
                    Iterator<appointmentDate> printNamesOfAppointmentDates = availableAppointmentDates.listIterator();
                    int order = 1;
                    while (printNamesOfAppointmentDates.hasNext()) {
                        System.out.println(order + "-) " + printNamesOfAppointmentDates.next().getName());
                        order++;
                    }

                    System.out.println("Enter appointment you would like to choose: ");

                    int chosenAppointmentDate = 10;

                    if (!runScenario) {
                        chosenAppointmentDate = scanner.nextInt();
                    }
                    if (runScenario) {
                        System.out.println("Patient choosed '10'");
                        System.out.println();
                    }
                    appointmentDate selectedAppointmentDate = availableAppointmentDates.get(chosenAppointmentDate);
                    selectedAppointmentDate.setAvailable(false);

                    selectedPatient.addAppointment(new appointment(selectedAppointmentDate.getName(),
                            selectedAppointmentHospital.getName(), selectedAppointmentDepartment.getName(),
                            selectedAppointmentDoctor.getName(), selectedAppointmentDate.getAppointmentDate()));


                    if (!runScenario) {
                        selectedPatient.appointments.get(selectedPatient.getAppointmentCount() - 1).appointmentInfo();
                    }
                    if (runScenario){
                        selectedPatient.appointments.get(0).appointmentInfo();
                    }
                    System.out.println("Is all appointment information is correct?");

                    if (!runScenario) {
                        scanner.nextLine();

                        boolean answerPass = false;
                        while (!answerPass) {
                            String isAnswerCorrect = scanner.nextLine();

                            if (isAnswerCorrect.equals("Yes")) {
                                System.out.println("Your appointment has created.");
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

                    if (runScenario) {
                        System.out.println("Patient said 'Yes'");
                        appointmentApproved = true;
                        runScenario = false;
                        System.out.println();
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
