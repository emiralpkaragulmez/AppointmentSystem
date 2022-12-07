import java.util.ArrayList;

abstract class adminPanel {
    ArrayList<hospital> hospitals = new ArrayList<hospital>();
    void addHospital(String name, String founder){
        hospital  h = new hospital(name, founder);
        hospitals.add(h);
    }

    void addDepartment(String whichHospital, String newDepartmentName){
        int x = hospitals.indexOf(whichHospital);
        hospitals.get(x).addDepartment(newDepartmentName);
    }

    void addDoctor(String whichDepartment, String newDoctorName, int doctorAge, int experienceOfDoctor, String doctorGender){
        String selectedHospitalName = null;
        int x = hospitals.indexOf(selectedHospitalName);
        int y = hospitals.get(x).departments.indexOf(whichDepartment);
        hospitals.get(x).departments.get(y).addDoctor(newDoctorName, doctorAge, experienceOfDoctor, doctorGender);
    }

}
