package testAbstract;

public class child extends Parent3 {
    public void Parent3AbstractMethod() {
        System.out.println("544545");
    }

    public void Parent2AbstractMethod() {
        System.out.println("121212");
    }

    public void test1(){
        System.out.println("child test1");
    }

    public static void main(String[] args) {
        child c = new child();
        c.Parent2AbstractMethod();
        c.Parent3AbstractMethod();
        c.hh();
        c.test1();
        c.test2();
    }
}
