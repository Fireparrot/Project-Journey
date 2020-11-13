package projectjourney;

public class Quest {
    
    private boolean isComplete;
    private String name;
    private Questable quest;
    
    public Quest(String n, Questable q) {
        isComplete = false;
        name = n;
        quest = q;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Questable getQuest() {
        return quest;
    }
    public void setQuest(Questable quest) {
        this.quest = quest;
    }
    
    public boolean check(Narrator n) {
        if(quest.isComplete(n)) {
            quest.finish(n);
            isComplete = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean isIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
    
}