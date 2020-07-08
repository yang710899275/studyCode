package sheji;

public class beiwangluDemo {
    public static void main(String[] args) {
        Originator  o = new Originator();
        o.setState("1");
        System.out.println(o.getState());
        Caretaker c = new Caretaker();
        c.setM(o.createMememo());
        o.setState("2");
        System.out.println(o.getState());
        o.restore(c);
        System.out.println(o.getState());
    }

}

class Mememo{
    private String state;

    public Mememo(String state){
        this.state = state;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class Originator{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    Mememo createMememo(){
        return new Mememo(state);
    }

    void restore(Caretaker c){
        this.state = c.getM().getState();
    }
}

class Caretaker{
    private Mememo m;

    public Mememo getM() {
        return m;
    }

    public void setM(Mememo m) {
        this.m = m;
    }
}