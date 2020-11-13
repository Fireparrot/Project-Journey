package projectjourney;

//UNIMPLEMENTED

public class Determinator {
    
    private double temperatureHMax;
    private double temperatureHMin;
    private double temperatureLMax;
    private double temperatureLMin;
    private double depthMax;
    private double depthMin;
    private double humidityMax;
    private double humidityMin;
    private Determinatorable d;
    
    public boolean fallsInRange(Tile t) {
        return  t.getTemperatureH() <=  temperatureHMax     &&      t.getTemperatureH() >=  temperatureHMin &&
                t.getTemperatureL() <=  temperatureLMax     &&      t.getTemperatureL() >=  temperatureLMin &&
                t.getDepth()        <=  depthMax            &&      t.getDepth()        >=  depthMin        &&
                t.getHumidity()     <=  humidityMax         &&      t.getHumidity()     >=  humidityMax;
    }
    
    public void determine(Tile t) {
        d.determine(t);
    }
    
}