package c346.rp.edu.sg.demodatabase;

public class Task {
    private int id;
    private String description;
    private String date;

    public Task(int id, String description, String date){
        this.id = id;
        this.date = date;
        this.description = description;
    }

    public int getId(){return id;}
    public String getDescription(){return description;}
    public String getDate(){return date;}
}
