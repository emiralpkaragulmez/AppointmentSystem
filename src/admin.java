public class admin extends adminPanel{
    long id;
    String name;
    int password;

    public admin(long id, String name, int password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    boolean enterAdmin(long id,int password){
        if (this.id == id && this.password == password) {
            return true;
        }
        else return false;
    }

}
