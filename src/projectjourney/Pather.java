package projectjourney;

public class Pather {
    
    private List<Path> paths;
    
    public Pather() {
        paths = new List<Path>();
    }
    
    public List<Path> getPaths() {
        return paths;
    }
    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }
    
    public void add(String n, int c) {
        paths.add(new Path(n, c));
    }
    public void add(Path p) {
        paths.add(p);
    }
    public void changePath(String n, int c) {
        if(isPathChosen(n)) {
            pathChosenFor(n).setChoice(c);
        }
    }
    
    public boolean isPathChosen(String pathName) {
        List<Path>.Part<Path> part = paths.getFirstPart();
        while(part != null) {
            if(part.getPart().getName().equals(pathName)) {return true;}
            part = part.getNext();
        }
        return false;
    }
    public Path pathChosenFor(String pathName) {
        List<Path>.Part<Path> part = paths.getFirstPart();
        while(part != null) {
            if(part.getPart().getName().equals(pathName)) {return part.getPart();}
            part = part.getNext();
        }
        return null;
    }
    public List<Path>.Part<Path> partChosenFor(String pathName) {
        List<Path>.Part<Path> part = paths.getFirstPart();
        while(part != null) {
            if(part.getPart().getName().equals(pathName)) {return part;}
            part = part.getNext();
        }
        return null;
    }
    public int choiceChosenFor(String pathName) {
        List<Path>.Part<Path> part = paths.getFirstPart();
        while(part != null) {
            if(part.getPart().getName().equals(pathName)) {return part.getPart().getChoice();}
            part = part.getNext();
        }
        return -1;
    }
    
}