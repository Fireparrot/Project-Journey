package projectjourney;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Narrator {

    private int STORYWAITTIME = 1000;

    private List<Map> maps;
    private Player player;
    private PlayerFrame PF;
    private boolean movementEnabled;
    private List<String> awaitingStory;
    private long storyTime;
    private boolean answerNeeded;
    private boolean answerDelivered;
    private String answerLine;
    private Time time;

    public Narrator() {
        player = new Player(this);
        awaitingStory = new List<String>();
        storyTime = 0;
        time = new Time();
        time.addYear(2015);
        time.addDay(82);
        time.addHour(5);
        maps = new List<Map>();
        answerLine = "";
        Environment env = new Environment(time);
        maps.add(new Map(150, 150, env));
        player.setCurrentMap(maps.get(0));
        /*
        int randX;
        int randY;
        do {
            randX = Func.randInt(5, player.getCurrentMap().getWidth()-5);
            randY = Func.randInt(5, player.getCurrentMap().getHeight()-5);
        } while(!player.suitableTilePosition(player.getCurrentMap().getTile(randX, randY)));
        player.setMapX(randX);
        player.setMapY(randY);
        */
        player.getCurrentMap().spawn(player);
        PF = new PlayerFrame(this);
        player.updateSight();
        update();
    }

    public void run() throws InterruptedException {
        
        setUp();
        
        while (true) {
            Thread.sleep(1);
            update();
        }
    }
    
    private void setUp() {
        addToAS("You wake up.");
        addToAS("You look around yourself, and find youself in an unfamiliar landscape.");
        addToAS("You don't remember how you got there...");
        addToAS("You try to remember what your name is. You think it might be...");
        player.addPath("Name chosen", 0);
        answerNeeded = true;
        player.setCanMove(false);
        
        final Quest chooseName;
        final Quest ventureForth;
        
        ventureForth = new Quest("Venture forth!",
                new Questable() {
                    public boolean isComplete(Narrator n) {
                        return n.getPlayer().getMapX() == player.getPathChoice("Venture Forth quest x") && n.getPlayer().getMapY() == player.getPathChoice("Venture Forth quest y");
                    }
                    public void finish(Narrator n) {
                        addToAS("Congratulations! You made it!");
                        maps.get(0).getTile(player.getMapX(), player.getMapY()).determine();
                    }
                }
        );
        chooseName = new Quest("Choose name",
                new Questable() {
                    public boolean isComplete(Narrator n) {
                        return n.isAnswerDelivered();
                    }
                    public void finish(Narrator n) {
                        String name = n.retrieveAnswer();
                        if(name.equals("")) {
                            changePath("Name chosen", 2);
                            n.getPlayer().setName("Wylynn");
                            addToAS("Wylynn... Yes, that might be it...");
                        } else {
                            changePath("Name chosen", 1);
                            n.getPlayer().setName(name);
                            addToAS(n.getPlayer().getName() + "!");
                            addToAS("Yes, that must be it! " + n.getPlayer().getName() + "!");
                        }
                        time.addMinute(20);
                        player.setCanMove(true);
                        addToAS("It appears there might be something right next to you, due South-East. Go there.");
                        n.getPlayer().addQuest(ventureForth);
                        maps.get(0).getTile(player.getMapX()+1, player.getMapY()+1).setColor2(Color.red);
                        player.addPath("Venture Forth quest x", player.getMapX()+1);
                        player.addPath("Venture Forth quest y", player.getMapY()+1);
                    }
                }
        );
        
        player.addQuest(chooseName);
    }
    
    public void update() {
        //System.out.println("Uhh...\n" + awaitingStory);
        if (getAwaitingStory().length() != 0 && getStoryTime() + STORYWAITTIME <= System.currentTimeMillis()) {
            player.addToAL(getAwaitingStory().popFirst());
            PF.update();
            setStoryTime(System.currentTimeMillis());
        }
        player.checkQuester(this);
    }

    public List<Map> getMaps() {
        return maps;
    }

    public void setMaps(List<Map> maps) {
        this.maps = maps;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void addQuest(Quest q) {player.addQuest(q);}
    public void addQuest(String n, Questable q) {player.addQuest(n, q);}
    public void addPath(Path p) {player.addPath(p);}
    public void addPath(String n) {player.addPath(n, 0);}
    public void addPath(String n, int c) {player.addPath(n, c);}
    public void changePath(String n, int c) {player.changePath(n, c);}

    public PlayerFrame getPF() {
        return PF;
    }

    public void setPF(PlayerFrame PF) {
        this.PF = PF;
    }

    public boolean isMovementEnabled() {
        return movementEnabled;
    }

    public void setMovementEnabled(boolean movementEnabled) {
        this.movementEnabled = movementEnabled;
    }

    public long getStoryTime() {
        return storyTime;
    }

    public void setStoryTime(long storyTime) {
        this.storyTime = storyTime;
    }

    public List<String> getAwaitingStory() {
        return awaitingStory;
    }

    public void setAwaitingStory(List<String> awaitingStory) {
        this.awaitingStory = awaitingStory;
    }

    public void addToAS(String n) {
        awaitingStory.add(n);
    }

    public void addToAS(List<String> list) {
        awaitingStory.add(list);
    }

    public boolean isAnswerNeeded() {
        return answerNeeded;
    }

    public void setAnswerNeeded(boolean AnswerNeeded) {
        this.answerNeeded = AnswerNeeded;
    }

    public void doNeedAnswer() {
        answerNeeded = true;
    }

    public void doNotNeedAnswer() {
        answerNeeded = false;
    }

    public String getAnswerLine() {
        return answerLine;
    }
    public String retrieveAnswer() {
        String ans = answerLine;
        setAnswerLine("");
        answerDelivered = false;
        answerNeeded = false;
        return ans;
    }
    public void pushAnswer(String answerLine) {
        if (answerNeeded) {
            answerDelivered = true;
            answerNeeded = false;
            this.setAnswerLine(answerLine);
        }
    }
    public void setAnswerLine(String answerLine) {
        this.answerLine = answerLine;
    }

    public boolean isAnswerDelivered() {
        return answerDelivered;
    }
    public void setAnswerDelivered(boolean answerDelivered) {
        this.answerDelivered = answerDelivered;
    }
    public void answerDelivered() {answerDelivered = true;}
    public void answerNotDelivered() {answerDelivered = false;}

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
