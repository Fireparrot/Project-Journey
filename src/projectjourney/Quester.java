package projectjourney;

public class Quester {
    
    private List<Quest> quests;
    
    public Quester() {
        quests = new List<Quest>();
    }
    
    public void add(Quest q) {quests.add(q);}
    public void remove(Quest q) {quests.remove(q);}
    public void remove(String n) {
        Quest q = get(n);
        if(q != null) {
            quests.remove(q);
        }
    }
    
    public Quest get(int i) {return quests.get(i);}
    public Quest get(String n) {
        Quest q = null;
        for(int i = 0; i < quests.length(); i++) {
            if(quests.get(i).getName().equals(n)) {q = quests.get(i);}
        }
        return q;
    }
    public int getIndex(String n) {
        for(int i = 0; i < quests.length(); i++) {
            if(quests.get(i).getName().equals(n)) {return i;}
        }
        return -1;
    }
    
    public void check(Narrator n) {
        int complete;
        do {
            complete = 0;
            for(int i = 0; i < quests.length(); i++) {
                if(quests.get(i).check(n)) {
                    quests.remove(i);
                    complete++;
                }
            }
        } while(complete != 0);
    }
    
}