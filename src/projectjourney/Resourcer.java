package projectjourney;

public class Resourcer {
    
    private List<Resource> resources;
    private double carryCapacity;
    
    public Resourcer() {
        resources = new List<Resource>();
        carryCapacity = 0;
    }
    public Resourcer(double c) {
        resources = new List<Resource>();
        carryCapacity = c;
    }

    public List<Resource> getResources() {
        return resources;
    }
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
    public Resource getResource(String n) {
        List<Resource>.Part<Resource> p = resources.getFirstPart();
        for(int i = 0; i < resources.length(); i++) {
            if(p == null) {return null;}
            else if(p.getPart().getName().equals(n)) {return p.getPart();}
            else {p = p.getNext();}
        }
        return null;
    }
    public double getAmount(String n) {
        List<Resource>.Part<Resource> p = resources.getFirstPart();
        for(int i = 0; i < resources.length(); i++) {
            if(p == null) {return -1;}
            else if(p.getPart().getName().equals(n)) {return p.getPart().getAmount();}
            else {p = p.getNext();}
        }
        return -1;
    }
    public boolean has(String n) {
        List<Resource>.Part<Resource> p = resources.getFirstPart();
        for(int i = 0; i < resources.length(); i++) {
            if(p == null) {return false;}
            else if(p.getPart().getName().equals(n)) {return true;}
            else {p = p.getNext();}
        }
        return false;
    }
    public void setResource(String n, double a) {
        if(has(n)) {setResource(getResource(n), a);}
        else {resources.add(new Resource(n, a));}
    }
    public void setResource(Resource r) {
        if(has(r.getName())) {setResource(getResource(r.getName()), r.getAmount());}
        else {resources.add(new Resource(r));}
    }
    public void addResource(String n, double a) {
        if(has(n)) {addResource(getResource(n), a);}
        else {resources.add(new Resource(n, a));}
    }
    public void subResource(String n, double a) {
        if(has(n)) {addResource(getResource(n), -a);}
        else {/*Does nothing, might change later...*/}
    }
    public void setResource(Resource r, double a) {
        if(r != null) {
            if(carryCapacity != 0) {
                if(getTotalWeight() + r.getWeight()*(a-r.getAmount()) > carryCapacity) {
                    r.setAmount(r.canHandleUpTo(carryCapacity - getTotalWeight() + r.getTotalWeight()));
                } else {
                    r.setAmount(a);
                }
            } else {
                r.setAmount(a);
            }
        }
    }
    public void addResource(Resource r, double a) {
        if(r != null) {
            if(carryCapacity != 0) {
                if(getTotalWeight() +r.getWeight()*a > carryCapacity) {
                    r.setAmount(r.canHandleUpTo(carryCapacity - getTotalWeight() + r.getTotalWeight()));
                } else {
                    r.addAmount(a);
                }
            } else {
                r.addAmount(a);
            }
        }
    }
    
    
    public double getCarryCapacity() {return carryCapacity;}
    public void setCarryCapacity(double carryCapacity) {this.carryCapacity = carryCapacity;}
    public double getTotalWeight() {
        double ans = 0;
        for(int i = 0; i < resources.length(); i++) {
            ans += resources.get(i).getTotalWeight();
        }
        return ans;
    }
    
}