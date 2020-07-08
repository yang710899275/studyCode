package sheji;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxyDymaticDemo {

    public static void main(String[] args) {
        subject s = new realSubject();
        InvocationHandler handler = new proxySubject2(s);
        subject o = (subject) Proxy.newProxyInstance(s.getClass().getClassLoader(), s.getClass().getInterfaces(), handler);
        o.show();
    }

}


class proxySubject2 implements InvocationHandler {
    private Object service;

    public proxySubject2(Object service){
        this.service = service;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前");
        method.invoke(service,args);
        return null;
    }
}
