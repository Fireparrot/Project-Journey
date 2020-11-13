package projectjourney;

import java.awt.Color;

public class Map {

    private static final int DEFAULTX = 50;
    private static final int DEFAULTY = 50;
    private static final Color DARKGREEN = new Color(0, 128, 0);
    
    private Tile[][] tiles;
    private Environment environment;
    private boolean wrap;
    private int spawnX, spawnY;
    
    public Map(Environment env) {
        tiles = new Tile[DEFAULTX][DEFAULTY];
        for (int i = 0; i < DEFAULTX; i++) {
            for (int j = 0; j < DEFAULTY; j++) {
                tiles[i][j] = new Tile(env);
                tiles[i][j].setColor(DARKGREEN);
                tiles[i][j].setColor2(Color.white);
            }
        }
        
        wrap = false;
        
        buildSafely(env);
        
        determine(env);
        
    }
    public Map(int x, int y, Environment env) {
        tiles = new Tile[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tiles[i][j] = new Tile(env);
                tiles[i][j].setColor(Color.green);
            }
        }
        wrap = false;
        
        buildSafely(env);
        
        determine(env);
        
        do {
            spawnX = 2+(int)(Math.random()*(tiles.length-4));
            spawnY = 2+(int)(Math.random()*(tiles[0].length-4));
        } while(!(tiles[spawnX][spawnY].getTemperatureAverage() > 0   && tiles[spawnX][spawnY].getTemperatureAverage() < 30   &&
                  tiles[spawnX][spawnY].getHumidity() > 5             && tiles[spawnX][spawnY].getHumidity() < 15             &&
                  tiles[spawnX][spawnY].getDepth() > 4                && tiles[spawnX][spawnY].getDepth() < 10));
        checkAccessibilities(spawnX, spawnY);
    }

    public Tile[][] getTiles() {
        return tiles;
    }
    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }
    public void setTile(int x, int y, Tile t) {
        tiles[x][y] = t;
    }
    public int getWidth() {return tiles.length;}
    public int getHeight() {return tiles[0].length;}
    public Tile getTile(int x, int y) {
        if(wrap) {
            return tiles[x%tiles.length][y%tiles[0].length];
        } else {
            if(x%tiles.length != x || x < 0 || y%tiles[0].length != y || y < 0) {
                return null;
            } else {
                return tiles[x][y];
            }
        }
    }
    public boolean tileExists(int x, int y) {
        return x%tiles.length == x && x >= 0 && y%tiles[0].length == y && y >= 0; 
    }
    public boolean canAccess(int x, int y) {
        if(wrap) {
            return true;
        } else {
            return x%tiles.length == x && x >= 0 && y%tiles[0].length == y && y >= 0; 
        }
    }
    
    public void spawn(Player player) {
        player.setPosition(spawnX, spawnY);
    }
    
    public boolean isDiscovered(int x, int y) {
        return tiles[x][y].isDiscovered();
    }
    public void setSight(int x, int y, boolean b) {
        if(canAccess(x, y)) {
            getTile(x, y).setDiscovered(b);
        }
    }
    
    public boolean canEnter(int x, int y, Player p) {
        return tiles[x][y].canEnter(p);
    }
    public void enter(int x, int y, Player p) {
        tiles[x][y].enter(p);
    }
    
    public boolean getWrap() {return wrap;}
    public void setWrap(boolean b) {wrap = b;}
    
    public boolean isDepthSet(int x, int y) {
        return tiles[x][y].isDepthSet();
    }
    public boolean isHumiditySet(int x, int y) {
        return tiles[x][y].isHumiditySet();
    }
    public boolean isTemperatureHSet(int x, int y) {
        return tiles[x][y].isTemperatureHSet();
    }
    public boolean isTemperatureLSet(int x, int y) {
        return tiles[x][y].isTemperatureLSet();
    }
    
    public void setDepthSet(int x, int y, boolean b) {
        tiles[x][y].setDepthSet(b);
    }
    public void setHumiditySet(int x, int y, boolean b) {
        tiles[x][y].setHumiditySet(b);
    }
    public void setTemperatureHSet(int x, int y, boolean b) {
        tiles[x][y].setTemperatureHSet(b);
    }
    public void setTemperatureLSet(int x, int y, boolean b) {
        tiles[x][y].setTemperatureLSet(b);
    }
    
    public void setDepth(int x, int y, double d) {
        tiles[x][y].setDepth(d);
        //tiles[x][y].setDepthSet(true);
    }
    public void setHumidity(int x, int y, double d) {
        tiles[x][y].setHumidity(d);
        //tiles[x][y].setHumiditySet(true);
    }
    public void setTemperatureH(int x, int y, double d) {
        tiles[x][y].setTemperatureH(d);
        //tiles[x][y].setTemperatureHSet(true);
    }
    public void setTemperatureL(int x, int y, double d) {
        tiles[x][y].setTemperatureL(d);
        //tiles[x][y].setTemperatureLSet(true);
    }
    
    public void buildSafely(Environment env) {
        do {
            buildDepth(env);
            //System.out.println("Depth layer built!");
            buildHumidity(env);
            //System.out.println("Humidity layer built!");
            buildTemperature(env);
            //System.out.println("Temperature layer built!");
            //System.out.println(overallDepth() + "\n" + overallHumidity() + "\n" + overallTemperature() + "\n");
        } while(!checkOverallDepth(         env.getDepthAverage()       -env.getDepthVariance(),            env.getDepthAverage()       +env.getDepthVariance())        ||
                !checkOverallHumidity(      env.getHumidityAverage()    -env.getHumidityVariance(),         env.getHumidityAverage()    +env.getHumidityVariance())     ||
                !checkOverallTemperature(   env.getTemperatureAverage() -env.getTemperatureVariance(),      env.getTemperatureAverage() +env.getTemperatureVariance())      );
        
    }
    
    public void buildDepth(Environment env) {
        double[][] depthMap = Func.perlinCubicSigned(tiles.length, tiles[0].length, 2, 6, 0.5);
        double multiplier = env.getDepthVariance();
        double elevationBonus = env.getDepthAverageAdjusted();
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                setDepth(i, j, depthMap[i][j]/Func.range(depthMap)*2*multiplier + elevationBonus);
                setDepthSet(i, j, true);
            }
        }
    }
    
    public double waterBonus(int x, int y) {
        double bonus = 0;
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                if(i == x && j == y) {
                    //bonus += tiles[i][j].waterBonus() * 8;
                } else {
                    bonus += tiles[i][j].waterBonus()/Func.square(Func.distance(i,j,x,y));
                }
            }
        }
        return bonus;
    }
    public void buildHumidity(Environment env) {
        double[][] humidityMap = Func.perlinCubicSigned(tiles.length, tiles[0].length, 3, 6, 0.3);
        double multiplier = env.getHumidityVariance();
        double humidityBonus = env.getHumidityAverageAdjusted();
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                setHumidity(i, j, humidityMap[i][j]/Func.range(humidityMap)*2*multiplier + humidityBonus + waterBonus(i,j));
                setHumiditySet(i, j, true);
            }
        }
    }
    
    public double getHTH(int i, int j) {
        return getHTH(tiles[i][j].getHumidity());
    }
    public double getHTL(int i, int j) {
        return getHTL(tiles[i][j].getHumidity());
    }
    public static double getHTH(double h) {
        return h*0.5;
    }
    public static double getHTL(double h) {
        return h*1;
    }
    public void buildTemperature(Environment env) {
        double[][] temperatureMap = Func.perlinCubicSigned(tiles.length, tiles[0].length, 3, 6, 0.4);
        double multiplier = env.getTemperatureVariance();
        double difference = env.getTemperatureDifferenceAdjusted();
        double temperatureBonus = env.getTemperatureAverageAdjusted();
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                setTemperatureH(i, j, temperatureMap[i][j]/Func.range(temperatureMap)*2*multiplier + temperatureBonus + difference/2 - getHTH(i,j));
                setTemperatureL(i, j, temperatureMap[i][j]/Func.range(temperatureMap)*2*multiplier + temperatureBonus - difference/2 + getHTL(i,j));
                if(getTile(i, j).getTemperatureH() < getTile(i, j).getTemperatureL()) {getTile(i, j).setTemperatureH(getTile(i, j).getTemperatureL());}
                setTemperatureHSet(i, j, true);
                setTemperatureLSet(i, j, true);
            }
        }
    }
    
    public double overallDepth() {
        int n = 0;
        double total = 0;
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                n++;
                total += tiles[i][j].getDepth();
            }
        }
        return total/n;
    }
    public boolean checkOverallDepth(double d1, double d2) {
        return overallDepth() > d1 && overallDepth() < d2;
    }
    public double overallHumidity() {
        int n = 0;
        double total = 0;
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                n++;
                total += tiles[i][j].getHumidity();
            }
        }
        return total/n;
    }
    public boolean checkOverallHumidity(double d1, double d2) {
        return overallHumidity() > d1 && overallHumidity() < d2;
    }
    public double overallTemperature() {
        int n = 0;
        double total = 0;
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                n++;
                total += tiles[i][j].getTemperatureAverage();
            }
        }
        return total/n;
    }
    public boolean checkOverallTemperature(double d1, double d2) {
        return overallTemperature() > d1 && overallTemperature() < d2;
    }
    
    public void determine(Environment env) {
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                tiles[i][j].determine();
            }
        }
    }
    
    public void checkAccessibilities(int x, int y) {
        checkAccessibility(x, y);
        int checked;
        do {
            checked = 0;
            for(int i = 0; i < tiles.length; ++i) {
                for(int j = 0; j < tiles[0].length; ++j) {
                    if(     !tiles[i][j].isAccSet() && (
                            (tileExists(i-1, j) && tiles[i-1][j].isAccSet()) ||
                            (tileExists(i+1, j) && tiles[i+1][j].isAccSet()) ||
                            (tileExists(i, j-1) && tiles[i][j-1].isAccSet()) ||
                            (tileExists(i, j+1) && tiles[i][j+1].isAccSet()))) {
                        checkAccessibility(i, j);
                        ++checked;
                    }
                }
            }
        } while(checked > 0);
    }
    public void checkAccessibility(int x, int y) {
        Tile tile = tiles[x][y];
        if(tile.isTerrainAccessible()) {
            tile.setAccSet(true);
            tile.setAccessible(true);
        } else {
            tile.setAccSet(true);
            tile.setAccessible(false);
        }
    }
    
}
