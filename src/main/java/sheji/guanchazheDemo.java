package sheji;

import java.util.ArrayList;
import java.util.List;

public class guanchazheDemo {
    public static void main(String[] args) {
        Subject a = new tongzhi();
        Observer o1 = new xiao1();
        Observer o2 = new xiao2();
        a.add(o1);
        a.add(o2);
        a.response();
    }


}

abstract class Subject{
    protected List<Observer> li = new ArrayList<Observer>();

    public void add(Observer o){
        li.add(o);
    }

    public void remove(Observer o){
        li.remove(o);
    }

    abstract void response();

}

class tongzhi extends Subject{

    void response() {
        for (Object o:
             li) {
            ((Observer)o).response();
        }
    }
}

interface Observer{
    void response();
}

class xiao1 implements Observer{

    public void response() {
        System.out.println("小1已经响应");
    }
}

class xiao2 implements Observer{

    public void response() {
        System.out.println("小2已经响应");
    }
}