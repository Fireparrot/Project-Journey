package projectjourney;

public class Environment {
    
    private Time time;
    private double temperatureAverage;
    private double temperatureDifference;
    private double temperatureVariance;
    private double depthAverage;
    private double depthVariance;
    private double humidityAverage;
    private double humidityVariance;
    
    

    public Environment(Time t) {
        time = t;
        temperatureAverage = 10;
        temperatureDifference = 60;
        temperatureVariance = 10;
        depthAverage = 5;
        depthVariance = 12;
        humidityAverage = 20;
        humidityVariance = 20;
    }
    
    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    
    public double getTemperatureAverage() {
        return temperatureAverage;
    }
    public Environment setTemperatureAverage(double temperatureAverage) {
        this.temperatureAverage = temperatureAverage;
        return this;
    }
    public double getTemperatureDifference() {
        return temperatureDifference;
    }
    public Environment setTemperatureDifference(double temperatureDifference) {
        this.temperatureDifference = temperatureDifference;
        return this;
    }
    public double getTemperatureVariance() {
        return temperatureVariance;
    }
    public Environment setTemperatureVariance(double temperatureVariance) {
        this.temperatureVariance = temperatureVariance;
        return this;
    }

    public double getDepthAverage() {
        return depthAverage;
    }
    public Environment setDepthAverage(double depthAverage) {
        this.depthAverage = depthAverage;
        return this;
    }
    public double getDepthVariance() {
        return depthVariance;
    }
    public Environment setDepthVariance(double depthVariance) {
        this.depthVariance = depthVariance;
        return this;
    }

    public double getHumidityAverage() {
        return humidityAverage;
    }
    public Environment setHumidityAverage(double humidityAverage) {
        this.humidityAverage = humidityAverage;
        return this;
    }
    public double getHumidityVariance() {
        return humidityVariance;
    }
    public Environment setHumidityVariance(double humidityVariance) {
        this.humidityVariance = humidityVariance;
        return this;
    }
    
    public double getDepthAverageAdjusted() {return depthAverage;}
    public double getHumidityAverageAdjusted() {
        return humidityAverage-integratedWaterBonus(depthAverage, depthVariance);
    }
    public double integratedWaterBonus(double depthAverage, double depthVariance) {
        final double step = 0.01;
        double total = 0;
        for(double i = depthAverage-depthVariance; i <= depthAverage+depthVariance; i += step) {
            total += Tile.waterBonus(i);
        }
        return total*=step;
    }
    public double getTemperatureLAdjusted() {
        return temperatureAverage-temperatureDifference/2-HTLBonus();
    }
    public double getTemperatureHAdjusted() {
        return temperatureAverage+temperatureDifference/2+HTHBonus();
    }
    public double HTLBonus() {
        return Map.getHTL(humidityAverage);
    }
    public double HTHBonus() {
        return Map.getHTH(humidityAverage);
    }
    public double getTemperatureDifferenceAdjusted() {
        return temperatureDifference+HTHBonus()-HTLBonus();
    }
    public double getTemperatureAverageAdjusted() {
        return temperatureAverage + (HTHBonus()-HTLBonus())/2;
    }
    
    
}