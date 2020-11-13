package projectjourney;

public class Resource {
    
    private String name;
    private double amount;
    private double weight;
    private boolean canBeNegative;
    
    public Resource(String n) {
        name = n;
        amount = 0;
        weight = 1;
        canBeNegative = false;
    }
    public Resource(String n, double a) {
        name = n;
        amount = a;
        weight = 1;
        canBeNegative = false;
    }
    public Resource(String n, boolean b) {
        name = n;
        amount = 0;
        weight = 1;
        canBeNegative = b;
    }
    public Resource(String n, double a, boolean b) {
        name = n;
        amount = a;
        weight = 1;
        canBeNegative = b;
    }
    public Resource(String n, double a, double w) {
        name = n;
        amount = a;
        weight = w;
        canBeNegative = false;
    }
    public Resource(String n, boolean b, double w) {
        name = n;
        amount = 0;
        weight = w;
        canBeNegative = b;
    }
    public Resource(String n, double a, boolean b, double w) {
        name = n;
        amount = a;
        weight = w;
        canBeNegative = b;
    }
    public Resource(Resource r) {
        name = r.getName();
        amount = r.getAmount();
        weight = r.getWeight();
        canBeNegative = r.canBeNegative();
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount; checkZero();}
    public void addAmount(double a) {amount += a; checkZero();}
    public void subAmount(double a) {amount -= a; checkZero();}
    
    public void checkZero() {if(!canBeNegative) {if(amount < 0) {amount = 0;}}}

    public double getWeight() {return weight;}
    public void setWeight(double weight) {this.weight = weight;}
    public double getTotalWeight() {return weight*amount;}
    public double canHandleUpTo(double w) {return (w/weight);}
    
    public boolean canBeNegative() {return canBeNegative;}
    public void setCanBeNegative(boolean canBeNegative) {this.canBeNegative = canBeNegative;}
    
    public String toString() {return name + ": " + amount;}
    
}