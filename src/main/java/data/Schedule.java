package data;

public class Schedule {

    private String[] lessons = new String[8];
    private String groupName; //TODO replace on Enum of Group
    private String date;  // format:

    private final String[] TIME = {
            "номер пары",
            "1 пара 8:30 - 10:00",
            "2 пара 10:10 - 11:40",
            "3 пара 12:10 - 13:40",
            "4 пара 13:50 - 15:20",
            "5 пара 15:30 - 17:00",
            "6 пара 17:30 - 19:00",
            "7 пара 19:10 - 20:40",
            "8 пара 20:45 - 22:15"
    };

    public String getGroupName() {
        return groupName;
    }

    public String getDate() {
        return date;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String[] getTIME() {
        return TIME;
    }

    public Schedule(String[] lessons) {
        this.lessons = lessons;
    }
}