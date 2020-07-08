package sheji;

public class proxyDemo {

    public static void main(String[] args) {
        subject s = new proxySubject();
        s.show();
    }

}

interface subject{
    void show();
}

class realSubject implements subject{

    public void show() {
        System.out.println("真实");
    }
}

class proxySubject implements subject{
    private realSubject realSubject;

    public proxySubject(){
        if (realSubject == null){
            realSubject = new realSubject();
        }
    }
    public void show() {
        System.out.println("代理钱");
        realSubject.show();
        System.out.println("dailihou");
    }
}
