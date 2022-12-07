public class appointmentDate {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private String name;
    private boolean available;

    public appointmentDate(int day, int month, int year, int hour, int minute,String name, boolean available) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.name = name;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public boolean printAvailableNamesForSelectedDate(int day, int month, int year, int x){
        if (this.day == day && this.month == month && this.year == year && available == true){
            return true;
        }else
        return false;
    }

    public boolean checkByName(String name){
        if (this.name == name){
            return true;
        }
        else return false;
    }

    public boolean checkAvailability(){
        return available;
    }
}
