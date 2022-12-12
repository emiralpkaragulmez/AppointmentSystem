import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class admin extends adminPanel{
    long id;
    String name;
    int password;

    public admin(long id, String name, int password) {
        this.id = id;
        this.name = name;
        this.password = password;

    }

    private void addAdmin (long id, String name, int password){
        admin tempAdmin = new admin(id, name, password);
        admins.add(tempAdmin);
    }

    boolean enterAdmin(long id,int password){
        if (this.id == id && this.password == password) {
            return true;
        }
        else return false;
    }





}
