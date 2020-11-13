package projectjourney;

public class TileEnvironment {
    
    private double depth;
    private boolean depthSet;
    private double humidity;
    private boolean humiditySet;
    private double temperatureH;
    private double temperatureL;
    private boolean temperatureHSet;
    private boolean temperatureLSet;
    
    public TileEnvironment() {
        depth = 0;
        humidity = 0;
        temperatureH = 0;
        temperatureL = 0;
        
        clearSets();
    }
    
    public double getDepth() {
        return depth;
    }
    public void setDepth(double depth) {
        this.depth = depth;
    }
    public boolean isDepthSet() {
        return depthSet;
    }
    public void setDepthSet(boolean depthSet) {
        this.depthSet = depthSet;
    }
    
    public double getHumidity() {
        return humidity;
    }
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
    public boolean isHumiditySet() {
        return humiditySet;
    }
    public void setHumiditySet(boolean humiditySet) {
        this.humiditySet = humiditySet;
    }
    
    public double getTemperatureH() {
        return temperatureH;
    }
    public void setTemperatureH(double temperatureH) {
        this.temperatureH = temperatureH;
    }
    public double getTemperatureL() {
        return temperatureL;
    }
    public void setTemperatureL(double temperatureL) {
        this.temperatureL = temperatureL;
    }
    
    public boolean isTemperatureHSet() {
        return temperatureHSet;
    }
    public void setTemperatureHSet(boolean temperatureHSet) {
        this.temperatureHSet = temperatureHSet;
    }
    public boolean isTemperatureLSet() {
        return temperatureLSet;
    }
    public void setTemperatureLSet(boolean temperatureLSet) {
        this.temperatureLSet = temperatureLSet;
    }
    
    public void clearSets() {
        depthSet = false;
        humiditySet = false;
        temperatureHSet = false;
        temperatureLSet = false;
    }
    
}