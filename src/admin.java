public class admin extends adminPanel{
    int id;
    String name;
    int password;

    public admin(int id, String name, int password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    boolean enterAdmin(int id,int password){
        if (this.id == id && this.password == password) {
            return true;
        }
        else return false;
    }

}
