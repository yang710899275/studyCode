package sheji;

public class shipeiqiTwoWayDemo {
    public static void main(String[] args) {
        System.out.println("目标通过双向适配器访问适配者：");
        TwoWayAdaptee adaptee=new AdapteeRealize();
        TwoWayTarget target=new adapter5(adaptee);
        target.request();
        System.out.println("-------------------");
        System.out.println("适配者通过双向适配器访问目标：");
        target=new TargetRealize();
        adaptee=new adapter5(target);
        adaptee.specificRequest();
    }
}

interface TwoWayTarget{
    void request();
}

class TargetRealize implements TwoWayTarget{

    public void request() {
        System.out.println("目标代码被实现");
    }
}

interface TwoWayAdaptee{
    void specificRequest();
}

class AdapteeRealize implements TwoWayAdaptee{

    public void specificRequest() {
        System.out.println("适配器代码被实现");
    }
}

class adapter5 implements TwoWayTarget,TwoWayAdaptee{
    private TwoWayTarget t1;
    private TwoWayAdaptee a1;

    public adapter5(TwoWayTarget t1){
        this.t1 = t1;
    }
    public adapter5(TwoWayAdaptee a1){
        this.a1 = a1;
    }

    public void request() {
        t1.request();
    }

    public void specificRequest() {
        a1.specificRequest();
    }
}


