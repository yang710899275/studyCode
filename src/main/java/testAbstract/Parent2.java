package testAbstract;

public abstract class Parent2 extends Parent1 implements Interface1{
    public void test1() {
        System.out.println("Parent2 de test1");
        Parent2AbstractMethod();
    }



    public abstract void Parent2AbstractMethod();
}
