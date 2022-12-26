import java.util.ArrayList;

abstract class simpleDatabaseSample {
    protected ArrayList<patient> patients = new ArrayList<patient>();
    protected ArrayList<admin> admins = new ArrayList<admin>();
    protected ArrayList<hospital> hospitals = new ArrayList<hospital>();

    public void insertHospitalSample(){
        hospital yunusEmreDevletHastanesi = new hospital("Yunus Emre Hospital", "Yunus Emre");
        hospitals.add(yunusEmreDevletHastanesi);


        yunusEmreDevletHastanesi.addDepartment("Internal Medicine"); // index 0 department
        yunusEmreDevletHastanesi.addDepartment("Neurology");      // index 1 department
        yunusEmreDevletHastanesi.addDepartment("Cardiology");  // index 2 department


        yunusEmreDevletHastanesi.departments.get(0).addDoctor("\t\n" +
                "BUGRA OZKAN", 35,10,"Male");
        yunusEmreDevletHastanesi.departments.get(0).addDoctor("IMRAN TOKMAKOGLU", 40,14,"Male");
        yunusEmreDevletHastanesi.departments.get(1).addDoctor("\t\n" +
                "ADEM ILTER UYSAL", 40,15,"Male");
        yunusEmreDevletHastanesi.departments.get(1).addDoctor("SAADET TASTABAN", 40,15,"Female");
        yunusEmreDevletHastanesi.departments.get(2).addDoctor("\t\n" +
                "MUHAMMED ERZURUM", 35,10,"Male");
        yunusEmreDevletHastanesi.departments.get(2).addDoctor("MESUT PAK", 40,13,"Male");

    }




}


