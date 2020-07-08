package sheji.cglib;


import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

class Biz {
    public void add() {
        System.out.println("这是一个普通方法...加法。");
    }

    public final void minus() {
        System.out.println("这是一个普通方法...减法。");
    }
}

class BizInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("BizInterceptor, 调用开始 method: " + method +
                ", methodProxy: " + methodProxy);
        methodProxy.invokeSuper(o, objects);
        System.out.println("BizInterceptor, 调用结束");
        return null;
    }
}

public class cglibproxy {
    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        /*Class<?> clazz[] = {Service.class};
        enhancer.setInterfaces(clazz);*/
        //回调方法
        Callback[] obj = {new BizInterceptor(), new BizInterceptor2()};
        enhancer.setCallbacks(obj);
        enhancer.setCallbackFilter(new BizClassFilter());
        //创建代理对象
        return enhancer.create();
    }

    public static void main(String[] args) {
       /* try {
            Field field = System.class.getDeclaredField("props");
            field.setAccessible(true);
            Properties props = (Properties) field.get(null);
            props.put(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/lanhongzhong/Workspace/LuceneTest");

            Package pkg = Client.class.getPackage();
            if (pkg != null) {
                String packagePath = pkg.getName().replace(".", File.pathSeparator);
                new File(packagePath).mkdirs();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

        cglibproxy cglib = new cglibproxy();
        Biz bizCglib = (Biz) cglib.getInstance(new Biz());
        bizCglib.add();

        bizCglib.minus();
    }
}

class BizInterceptor2 implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("BizInterceptor2, 调用开始 method: " + method +
                ", methodProxy: " + methodProxy);
        methodProxy.invokeSuper(o, objects);
        System.out.println("BizInterceptor2, 调用结束");
        return null;
    }
}

class BizClassFilter implements CallbackFilter {

    public int accept(Method method) {
        if (method.getName().equals("minus")) {
            return 1;
        }

        return 0;
    }
}
