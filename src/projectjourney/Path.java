package projectjourney;

public class Path {
    
    private String name;
    private int choice;
    
    public Path(String n) {
        name = n;
        choice  = 0;
    }
    public Path(String n, int c) {
        name = n;
        choice  = c;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    
}