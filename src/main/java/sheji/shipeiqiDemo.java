package sheji;

public class shipeiqiDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //根据配置文件拿
        target t = (target) Class.forName("sheji.adapter").newInstance();
        t.request();

    }
}

interface target{
    void request();
}

class adptee{
    public void specificRequest(){
        System.out.println("适配器中的业务代码被调用");
    }
}

class adapter extends adptee implements target{

    public void request() {
        specificRequest();
    }
}

