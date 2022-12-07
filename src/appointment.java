public class appointment {
    String appointmentName;
    String hospitalName;
    String departmentName;
    String doctorName;
    String appointmentDate;

    public appointment(String appointmentName, String hospitalName, String departmentName, String doctorName, String appointmentDate) {
        this.appointmentName = appointmentName;
        this.hospitalName = hospitalName;
        this.departmentName = departmentName;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public  void appointmentInfo(){
        System.out.println("You have an appointment in " + departmentName + " at " + appointmentDate + " .");
    }
}
