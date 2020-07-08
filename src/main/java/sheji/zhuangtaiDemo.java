package sheji;

public class zhuangtaiDemo {
    public static void main(String[] args) {
        Context c = new Context();
        c.h();
        c.h();
        c.h();
    }
}


class Context{
    private state s;

    public Context(){
        this.s = new oper1();
    }
    public state getS() {
        return s;
    }

    public void setS(state s) {
        this.s = s;
    }

    public void h(){
        s.handle(this);
    }
}

abstract class state{
    abstract void handle(Context context);
}

class oper1 extends state{

    void handle(Context context) {
        System.out.println("oper1执行");
        context.setS(new oper2());
    }
}

class oper2 extends state{

    void handle(Context context) {
        System.out.println("oper2执行");
        context.setS(new oper1());
    }
}