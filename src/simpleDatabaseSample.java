import java.util.ArrayList;

abstract class simpleDatabaseSample {
    ArrayList<patient> patients = new ArrayList<patient>();
    ArrayList<admin> admins = new ArrayList<admin>();
    ArrayList<hospital> hospitals = new ArrayList<hospital>();

    public void insertHospitalSample(){
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

    }




}


