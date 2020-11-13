package projectjourney;

public class Player {
    
    public static final boolean PEGASUS = false;
    
    private String name;
    private Narrator narrator;
    private List<Artifact> artifacts;
    private Pather pather;
    private Quester quester;
    private Resourcer resourcer;
    private List<String> adventureLog;
    private Map currentMap;
    private int mapX;
    private int mapY;
    private float health = 1000;
    private float mana = 100;
    private float food = 750;
    private float water = 750;
    private float sleep = 800;
    private float energy = 500;
    private double sightRadius = 35;
    private boolean canMove = true;
    
    private boolean alive = true;
    private String deathMessage = "";
    
    public Player(Narrator n) {
        name = "";
        narrator = n;
        artifacts = new List<Artifact>();
        pather = new Pather();
        quester = new Quester();
        resourcer = new Resourcer();
        resourcer.addResource("food", 10);
        resourcer.addResource("water", 10);
        adventureLog = new List<String>();
        mapX = 10;
        mapY = 10;
        canMove = true;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }
    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public Pather getPather() {
        return pather;
    }
    public void setPather(Pather pather) {
        this.pather = pather;
    }
    public void addPath(Path p) {pather.add(p);}
    public void addPath(String n, int c) {pather.add(new Path(n, c));}
    public Path getPathChosen(String n) {
        return pather.pathChosenFor(n);
    }
    public int getPathChoice(String n) {
        if(pather.isPathChosen(n)) {
            return pather.pathChosenFor(n).getChoice();
        } else {
            return -1;
        }
    }
    public boolean pathChosen(String n) {
        return pather.pathChosenFor(n) != null;
    }
    public void changePath(String n, int c) {
        if(pather.isPathChosen(n)) {
            pather.pathChosenFor(n).setChoice(c);
        }
    }
    
    public Quester getQuester() {return quester;}
    public void setQuester(Quester q) {quester = q;}
    public void addQuest(Quest q) {quester.add(q);}
    public void addQuest(String n, Questable q) {quester.add(new Quest(n, q));}
    
    public void checkQuester(Narrator n) {
        quester.check(n);
    }
    
    public List<String> getAdventureLog() {
        return adventureLog;
    }
    public void setAdventureLog(List<String> adventureLog) {
        this.adventureLog = adventureLog;
    }
    public void addToAL(String text) {
        getAdventureLog().add(text);
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }

    public int getMapX() {
        return mapX;
    }
    public void setMapX(int mapX) {
        this.mapX = mapX;
    }

    public int getMapY() {
        return mapY;
    }
    public void setMapY(int mapY) {
        this.mapY = mapY;
    }
    
    public void setPosition(int x, int y) {
        mapX = x;
        mapY = y;
    }
    
    public Tile getCurrentTile() {return currentMap.getTile(mapX, mapY);}
    
    public boolean canAccess(int x, int y) {
        return currentMap.canAccess(mapX+x, mapY+y);
    }
    public void move(int x, int y) {
        if(currentMap.canAccess(mapX+x, mapY+y)) {
            if(canMove()) {
                if(currentMap.canEnter(mapX+x, mapY+y, this)) {
                    mapX += x;
                    mapY += y;
                    currentMap.enter(mapX, mapY, this);
                    update();
                }
            }
        }
    }
    
    public boolean suitableTilePosition(Tile t) {
        return  t.getTemperatureAverage() > 0   && t.getTemperatureAverage() < 30   &&
                t.getHumidity() > 5             && t.getHumidity() < 15             &&
                t.getDepth() > 4                && t.getDepth() < 10;
    }
    
    public void update() {
        updateSight();
    }
    
    public void updateSight() {
        for(int i = -(int)Math.ceil(sightRadius); i <= (int)Math.ceil(getSightRadius()); i++) {
            for(int j = -(int)Math.ceil(sightRadius); j <= (int)Math.ceil(getSightRadius()); j++) {
                if(currentMap.canAccess(mapX+i, mapY+j)) {
                    if(Math.sqrt(i*i + j*j) <= getSightRadius()) {
                        currentMap.setSight(mapX+i, mapY+j, true);
                    }
                }
            }
        }
    }
    
    public String action(String command) {
        
        return "No such command exists.";
    }

    public Narrator getNarrator() {
        return narrator;
    }

    public void setNarrator(Narrator narrator) {
        this.narrator = narrator;
    }

    public double getSightRadius() {
        return sightRadius;
    }

    public void setSightRadius(double sightRadius) {
        this.sightRadius = sightRadius;
    }

    public boolean isCanMove() {
        return canMove;
    }
    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }
    public boolean canMove() {return canMove&&alive;}
    
    public boolean isPegasus() {return PEGASUS;}

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getDeathMessage() {
        return deathMessage;
    }

    public void setDeathMessage(String deathMessage) {
        this.deathMessage = deathMessage;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getMana() {
        return mana;
    }

    public void setMana(float mana) {
        this.mana = mana;
    }

    public float getFood() {
        return food;
    }

    public void setFood(float food) {
        this.food = food;
    }

    public float getWater() {
        return water;
    }

    public void setWater(float water) {
        this.water = water;
    }

    public float getSleep() {
        return sleep;
    }

    public void setSleep(float sleep) {
        this.sleep = sleep;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }
    
}