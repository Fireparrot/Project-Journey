package projectjourney;

public class Time {
    
    private int year;
    private long time;
    private final static int[] DAYSINMONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final static String[] NAMESOFMONTHS = {"January", "February", "March", "April", "May",
        "June", "July", "August", "September", "October", "November" , "December"};
    private final static String[] NAMESOFDAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    
    public Time() {
        time = 0;
    }
    
    public void set(long t) {time = t; checkOverflow();}
    public void add(long t) {time += t; checkOverflow();}
    public void add() {time += 1; checkOverflow();}
    public void addMinute(long t) {time += t*60; checkOverflow();}
    public void addMinute() {time += 60; checkOverflow();}
    public void addHour(long t) {time += t*60*60; checkOverflow();}
    public void addHour() {time += 60*60; checkOverflow();}
    public void addDay(long t) {time += t*60*60*24; checkOverflow();}
    public void addDay() {time += 60*60*24; checkOverflow();}
    public void addYear(int t) {year += t; checkOverflow();}
    public void addYear() {year += 1;}
    
    public long get() {return time;}
    public long getSecond() {return time%60;}
    public long getMinute() {return (time%3600 - time%60)/60;}
    public long getHour() {return (time%(60*60*24) - time%(60*60))/(60*60);}
    public long getDay() {return (time%(60*60*24*365) - time%(60*60*24))/(60*60*24) + 1;}
    public int getDayM() {
        int day = (int)(time%(60*60*24*365) - time%(60*60*24))/(60*60*24) + 1;
        int acc = 0;
        for(int i = 0; i < 12; i++) {
            acc += DAYSINMONTHS[i];
            if(day <= acc) {return (day - acc + DAYSINMONTHS[i]);}
        }
        return -1;
    }
    public int getDayW() {
        return (int)((time - time%(60*60*24))/(60*60*24) + year*(365%7)+4)%7;
    }
    public String getDayWName() {
        return NAMESOFDAYS[getDayW()];
    }
    public int getMonth() {
        int day = (int)(time%(60*60*24*365) - time%(60*60*24))/(60*60*24) + 1;
        int acc = 0;
        for(int i = 0; i < 12; i++) {
            acc += DAYSINMONTHS[i];
            if(day <= acc) {return i+1;}
        }
        return -1;
    }
    public String getMonthName() {
        int day = (int)(time%(60*60*24*365) - time%(60*60*24))/(60*60*24) + 1;
        int acc = 0;
        for(int i = 0; i < 12; i++) {
            acc += DAYSINMONTHS[i];
            if(day <= acc) {return NAMESOFMONTHS[i];}
        }
        return "";
    }
    public int getYear() {return (int)(time - time%(60*60*24*365))/(60*60*24*365) + year;}
    
    public double daylight() {
        double t1 = 5;
        double t2 = 6;
        double t3 = 18;
        double t4 = 19;
        
        if(getHour() < t1) {
            return 0;
        } else if(getHour() < t2) {
            return Func.between(t1, getHour()+(double)getMinute()/60, t2);
        } else if(getHour() < t3) {
            return 1;
        } else if(getHour() < t4) {
            return Func.between(t4, getHour()+(double)getMinute()/60, t3);
        } else {
            return 0;
        }
    }
    
    public void checkOverflow() {
        while(time >= 60*60*24*365) {
            time -= 60*60*24*365;
            year += 1;
        }
    }
    
    public boolean isNight() {return getHour() < 6 || getHour() > 18;}
    public boolean isDay() {return getHour() >= 6 && getHour() <= 18;}
    
}