package projectjourney;

public class List<T> {
    
    public class Part<T> {
        
        private Part<T> previous;
        private T part;
        private Part<T> next;
        
        public Part(Part<T> prev, T p, Part<T> n) {
            previous = prev;
            part = p;
            next = n;
        }
        
        public Part<T> getPrevious() {return previous;}
        public void setPrevious(Part<T> previous) {this.previous = previous;}
        
        public T getPart() {return part;}
        public void setPart(T part) {this.part = part;}
        
        public Part<T> getNext() {return next;}
        public void setNext(Part<T> next) {this.next = next;}
        
        public String toString() {return part.toString();}
        
    }
    
    private Part<T> first;
    private Part<T> last;
    
    public void add(T obj) {
        if(first == null) {
            first = last = new Part<T>(null, obj, null);
        } else {
            Part<T> p = new Part<T>(last, obj, null);
            last.setNext(p);
            last = p;
        }
    }
    public void add(List<T> l) {
        for(int i = 0; i < l.length(); i++) {
            add(l.get(i));
        }
    }
    public void addFirst(T obj) {
        if(first == null) {
            first = last = new Part<T>(null, obj, null);
        } else {
            Part<T> p = new Part<T>(null, obj, first);
            first.setPrevious(p);
            first = p;
        }
    }
    
    public void remove(T obj) {
        if(has(obj)) {
            Part<T> p = getPart(obj);
            if(p.getPrevious() != null) {p.getPrevious().setNext(p.getNext());} else {first = p.getNext();}
            if(p.getNext() != null) {p.getNext().setPrevious(p.getPrevious());} else {last = p.getPrevious();}
        }
    }
    public void remove(int index) {
        Part<T> p;
        if(index <= 0) {
            p = first;
        } else if(index >= length()) {
            p = last;
        } else {
            p = first;
            for(int i = 0; i < index; i++) {
                p = p.getNext();
            }
        }
        if(p.getPrevious() != null) {p.getPrevious().setNext(p.getNext());} else {first = p.getNext();}
        if(p.getNext() != null) {p.getNext().setPrevious(p.getPrevious());} else {last = p.getPrevious();}
    }
    
    public Part<T> getPart(int index) {
        Part<T> p = first;
        for(int i = 0; i < index; i++) {
            if(p == null) {return null;}
            else {p = p.getNext();}
        }
        return p;
    }
    public Part<T> getPart(T obj) {
        Part<T> p = first;
        while(p != null) {
            if(p.getPart().equals(obj)) {return p;}
            else {p = p.getNext();}
        }
        return null;
    }
    public Part<T> getFirstPart() {return first;}
    public Part<T> getLastPart() {return last;}
    public T get(int index) {
        Part<T> p = first;
        for(int i = 0; i < index; i++) {
            if(p == null) {return null;}
            else {p = p.getNext();}
        }
        return p.getPart();
    }
    public T get(String n) {
        Part<T> p = first;
        for(int i = 0; i < length(); i++) {
            if(p.getPart().toString().equals(n)) {return p.getPart();}
            else {p = p.getNext();}
        }
        return null;
    }
    public T getFirst() {return first.getPart();}
    public T getLast() {return last.getPart();}
    public int length() {
        Part<T> p = first;
        int counter = 0;
        while(p != null) {
            counter++;
            p = p.getNext();
        }
        return counter;
    }
    public void set(int i, T obj) {getPart(i).setPart(obj);}
    public T popFirst() {
        T ans = first.getPart();
        remove(0);
        return ans;
    }
    public T popLast() {
        T ans = last.getPart();
        remove(length()-1);
        return ans;
    }
    public boolean has(T obj) {
        Part<T> p = first;
        while(p != null) {
            if(p.getPart().equals(obj)) {return true;}
            p = p.getNext();
        }
        return false;
    }
    public boolean has(Part<T> obj) {
        Part<T> p = first;
        while(p != null) {
            if(p.equals(obj)) {return true;}
            p = p.getNext();
        }
        return false;
    }
    
    public String toString() {
        String str = "";
        Part<T> p = first;
        while(p != null) {
            str += p.toString();
            if(p.getNext() != null) {str += "\n";}
            p = p.getNext();
        }
        return str;
    }
    public String toStringBackwards() {
        String str = "";
        Part<T> p = last;
        while(p != null) {
            str += p.toString();
            if(p.getPrevious() != null) {str += "\n";}
            p = p.getPrevious();
        }
        return str;
    }
    
}