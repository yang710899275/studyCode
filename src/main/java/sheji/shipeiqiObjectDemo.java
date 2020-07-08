package sheji;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class shipeiqiObjectDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        adptee a = new child();
        Class<?> aClass = Class.forName("sheji.Adapter2");
        Constructor<?> constructor = aClass.getConstructor(adptee.class);
        target t = (target) constructor.newInstance(a);
        t.request();
    }
}

class child extends adptee{
    public void specificRequest(){
        System.out.println("子对象1适配器中的业务代码被调用");
    }
}
class child2 extends adptee{
    public void specificRequest(){
        System.out.println("子对象2适配器中的业务代码被调用");
    }
}

class Adapter2 implements target{
    private adptee a;

    public Adapter2(adptee a){
        this.a = a;
    }
    public void request() {
        a.specificRequest();
    }
}
