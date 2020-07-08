package sheji;

import java.io.File;
import java.lang.reflect.*;
import java.util.Properties;

interface Service {
    public void help();
    public void hello(String str);
}

interface Item {
    void test();
}

class ServiceImpl implements Service, Item {

    public void help() {
        System.out.println("I want to buy some book");
    }

    public void hello(String str) {
        System.out.println("hello: " + str);
    }

    public void test() {
        System.out.println("Test dynamic proxy.");
    }
}

class DynamicProxy implements InvocationHandler {
    //这个就是我们要代理的真实对象
    private Object service;

    //构造方法，给我们要代理的真实对象赋初值
    public DynamicProxy(Object service) {
        this.service = service;
    }

    public Object invoke(Object object, Method method, Object[] args)
            throws Throwable {
        //在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before buy some book");

      //  System.out.println("object:"+object);
        System.out.println("Method:" + method);
        System.out.println("对象："+service);

        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(service, args);

        //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after buy some book");

        return null;
    }
}

public class jdkDymaticPorxy {
    public static void main(String[] args) {
        jdkDymaticPorxy p = new jdkDymaticPorxy();
        p.test1();

    }

    public void test1(){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);

        //要代理的真实对象
        Service service = new ServiceImpl();

        //要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法
        InvocationHandler handler = new DynamicProxy(service);

        //添加以下的几段代码, 就可以将代理生成的字节码保存起来
        try {
            Field field = System.class.getDeclaredField("props");
            field.setAccessible(true);
            Properties props = (Properties) field.get(null);
            props.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

            Package pkg = jdkDymaticPorxy.class.getPackage();
            if (pkg != null) {
                String packagePath = pkg.getName().replace(".", File.pathSeparator);
                System.out.println(packagePath);
                new File(packagePath).mkdirs();
            }

            Service serviceProxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                    service.getClass().getInterfaces(), handler);
            System.out.println(service.getClass().getClassLoader());
            System.out.println(service.getClass().getInterfaces());
            System.out.println(serviceProxy.getClass().getName());
            String[] interfaceNames = new String[service.getClass().getInterfaces().length];
            System.out.println("---");
            for (String i : interfaceNames) {
                System.out.println(i);
            }
            System.out.println("---");
            serviceProxy.help();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到ZhangSanXiangQinInterfaceImpl这个类的一个代理类，同时为代理类绑定了一个处理类ReadyInvocationHandler。
     * 听着很绕口，其实就是每次调用ZhangSanXiangQinInterfaceImpl这个子类的xiangQin方法时，
     * 不是zhangSan这个ZhangSanXiangQinInterfaceImpl类的实例去调用，
     * 而是这个ZhangSanXiangQinInterfaceImpl的代理类ReadyInvocationHandler去调用它自己的invoke方法,
     * 这个invoke方法里呢可以调用zhangSan这个实例的xiangQin方法
     */
    /**
     * 在java种怎样实现动态代理呢
     * 第一步，我们要有一个接口，还要有一个接口的实现类，而这个实现类呢就是我们要代理的对象，
     * 所谓代理呢也就是在调用实现类的方法时，可以在方法执行前后做额外的工作，这个就是代理。
     * 第二步，我们要自己写一个在要代理类的方法执行时，能够做额外工作的类，而这个类必须继承InvocationHandler接口，
     * 为什么要继承它呢？因为代理类的实例在调用实现类的方法的时候，不会调真正的实现类的这个方法，
     * 而是转而调用这个类的invoke方法（继承时必须实现的方法），在这个方法中你可以调用真正的实现类的这个方法。
     * 第三步，在要用代理类的实例去调用实现类的方法的时候，写出下面两段代码。
     */
//    XiangQinInterface proxy = (XiangQinInterface) Proxy.newProxyInstance(
//            zhangSan.getClass().getClassLoader(),
//            zhangSan.getClass().getInterfaces(),
//            new ReadyInvocationHandler(zhangSan));
//        proxy.xiangQin();
    /**
     * 这里要解释下中部那段长长的代码的意思，以及具体做了哪些工作？
     * 第一，根据zhangSan.getClass().getClassLoader()这个要代理类的类加载器和
     * zhangSan.getClass().getInterfaces()要代理类所实现的所有的接口
     * 作为参数调用Proxy.getProxyClass(ClassLoader loader, Class<?>... interfaces)
     * 的方法返回代理类的java.lang.Class对象，也就是得到了java动态生成的代理类$Proxy0的Class对象。
     * 同时，java还让这个动态生成的$Proxy0类实现了要代理类的实现的所有接口，并继承了Proxy接口。
     * 第二，实例化这个动态生成的$Proxy0类的一个实例，实例化代理类的构造函数为Proxy(InvocationHandler h)，
     * 也就是说要实例化这个动态生成的$Proxy0类，必须给它一个InvocationHandler参数，也就是我们自己实现的用来在代理类
     * 方法执行前后做额外工作的类ReadyInvocationHandler。
     * 这段代码Proxy.newProxyInstance(zhangSan.getClass().getClassLoader(),zhangSan.getClass().getInterfaces(),new ReadyInvocationHandler(zhangSan))
     * 得到的其实是一个类名叫$Proxy0 extends Proxy implements XiangQinInterface的类。
     * 第三，将这个$Proxy0类强制转型成XiangQinInterface类型，调用xiangQin方法。
     */

}

final class jdkDymaticProxy$ extends Proxy implements Service, Item {

    private static Method m1;
    private static Method m5;
    private static Method m4;
    private static Method m0;
    private static Method m3;
    private static Method m2;

    public jdkDymaticProxy$(InvocationHandler var1)   {
        super(var1);
    }

    public final boolean equals(Object var1)   {
        try {
            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final void test()   {
        try {
            super.h.invoke(this, m5, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final void hello(String var1)   {
        try {
            super.h.invoke(this, m4, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final int hashCode()   {
        try {
            return (Integer)super.h.invoke(this, m0, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final void help() {
        try {
            super.h.invoke(this, m3, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final String toString()  {
        try {
            return (String)super.h.invoke(this, m2, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m5 = Class.forName("sheji.Item").getMethod("test");
            m4 = Class.forName("sheji.Service").getMethod("hello", Class.forName("java.lang.String"));
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
            m3 = Class.forName("sheji.Service").getMethod("help");
            m2 = Class.forName("java.lang.Object").getMethod("toString");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }

}



