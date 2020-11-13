package projectjourney;

public interface Questable {
    
    boolean isComplete(Narrator n);
    void finish(Narrator n);
    
}