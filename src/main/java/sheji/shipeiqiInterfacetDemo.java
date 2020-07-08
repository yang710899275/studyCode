package sheji;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class shipeiqiInterfacetDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //根据配置文件
        adaptee a = new child3();
        //根据配置文件选择适配器
        Class<?> aClass = Class.forName("sheji.Adapter3");
        Constructor<?> constructor = aClass.getConstructor(adaptee.class);
        target t = (target) constructor.newInstance(a);
        t.request();
    }
}

interface adaptee{
    void specificRequest();
}
class child3 implements adaptee{
    public void specificRequest(){
        System.out.println("实现对象3适配器中的业务代码被调用");
    }
}
class child4 implements adaptee{
    public void specificRequest(){
        System.out.println("实现对象4适配器中的业务代码被调用");
    }
}

class Adapter3 implements target{
    private adaptee a;

    public Adapter3(adaptee a){
        this.a = a;
    }
    public void request() {
        a.specificRequest();
    }
}
