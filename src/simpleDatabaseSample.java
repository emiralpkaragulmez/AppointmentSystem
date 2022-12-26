import java.util.ArrayList;

abstract class simpleDatabaseSample {
    protected ArrayList<patient> patients = new ArrayList<patient>();
    protected ArrayList<admin> admins = new ArrayList<admin>();
    protected ArrayList<hospital> hospitals = new ArrayList<hospital>();

    public void insertHospitalSample(){
        hospital yunusEmreDevletHastanesi = new hospital("Yunus Emre Devlet Hastanesi", "valide sultan");
        hospitals.add(yunusEmreDevletHastanesi);


        yunusEmreDevletHastanesi.addDepartment("Internal Medicine"); // index 0 department
        yunusEmreDevletHastanesi.addDepartment("Neurology");      // index 1 department
        yunusEmreDevletHastanesi.addDepartment("Cardiology");  // index 2 department


        yunusEmreDevletHastanesi.departments.get(0).addDoctor("\t\n" +
                "BUĞRA ÖZKAN", 35,10,"Male");
        yunusEmreDevletHastanesi.departments.get(0).addDoctor("İMRAN TOKMAKOĞLU", 40,14,"Male");
        yunusEmreDevletHastanesi.departments.get(1).addDoctor("\t\n" +
                "ADEM İLTER UYSAL", 40,15,"Male");
        yunusEmreDevletHastanesi.departments.get(1).addDoctor("SAADET TAŞTABAN", 40,15,"Female");
        yunusEmreDevletHastanesi.departments.get(2).addDoctor("\t\n" +
                "MUHAMMED ERZURUM", 35,10,"Male");
        yunusEmreDevletHastanesi.departments.get(2).addDoctor("MESUT PAK", 40,13,"erkek");

    }




}


