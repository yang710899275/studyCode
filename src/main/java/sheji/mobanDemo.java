package sheji;

public class mobanDemo {
    public static void main(String[] args) {
        describe d = new class1();

    }
}

abstract class describe{

    public describe(){
        first();
        second();
        third();
        fourth();
        fiveth();
    }

    public void first(){
        System.out.println("first!");
    }

    public void second(){
        System.out.println("second!");
    }

    public void third(){
        System.out.println("third!");
    }

    abstract void fourth();

    abstract void fiveth();
}

class class1 extends describe{

    public void third(){
        System.out.println("一班third!");
    }

    void fourth() {
        System.out.println("一班4444444");
    }

    void fiveth() {
        System.out.println("一班555555555555");
    }
}