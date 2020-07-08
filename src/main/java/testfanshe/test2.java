package testfanshe;

import java.lang.reflect.Method;

/**
 * 通过反射执行类方法
 */
public class test2 extends SubDao{
    public static void main(String[] args) {
           test2 t = new test2();
           t.fs();
           //t.fs2();
    }

    /**
     * 第一种，直接获取对应的方法
     *
     */
    public void fs(){
        Dao d = new Dao();
        try {
            Class<?> aClass = Class.forName("testfanshe.SubDao");
            //如果需要反射的方法是要传参的，那么后面要加上对应参数的class。
              Method shuchu = aClass.getMethod("shuchu", Student.class);
          //  Method shuchu = aClass.getMethod("shuchu");

            //参数
            Student s = new Student();
            s.setAge("16");
            s.setName("ceshi");

            //有两种方式，一种是传递反射class的实例 一种是传递当前类的this(但是这个this必须是继承反射的类)
            //this必须是反射类的实例对象
            shuchu.invoke(aClass.newInstance(),s) ;
            System.out.println(this);
            shuchu.invoke(this,s);
            //不行的，不能传递父类的对象。
           // shuchu.invoke(d,s);

            //疑问？调用静态方法时，不需要初始化实例,初始化了也可以调用
            System.out.println("调用静态方法");
            Method staShuchu = aClass.getMethod("staShuchu", Student.class);
            staShuchu.invoke(aClass,s);
            staShuchu.invoke(aClass.newInstance(),s);
            staShuchu.invoke(test2.class,s);
            staShuchu.invoke(this,s);

            //调用私有时 要使用declared来获取，并设置可访问
            System.out.println("调用静态私有方法");
            Object o = aClass.newInstance();
            Method staShuchuPrivate = aClass.getDeclaredMethod("staShuchuPrivate", Student.class);
            staShuchuPrivate.setAccessible(true);
            staShuchuPrivate.invoke(aClass,s);
            staShuchuPrivate.invoke(aClass.newInstance(),s);
            staShuchuPrivate.invoke(test2.class,s);
            staShuchuPrivate.invoke(this,s);

            //遍历方法执行
          //  Method[] methods = aClass.getMethods();
//            for (Method m:methods) {
//                System.out.println("方法名：" + m.getName());
//                Student s1 = new Student();
//                s1.setAge("16");
//                s1.setName("ceshi");
//                m.invoke(aClass.newInstance(),s1);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 第二种，通过强制转换为Dao ，Dao必须为SubDao的父类或者是接口
     * 如果是父类，那么父类也有有对应的子类方法才可以
     * 如果是接口，那么该类必须实现接口的方法
     */
    public void fs2(){
        try {
            Dao d = (Dao)Class.forName("testfanshe.SubDao").newInstance();

            //参数
            Student s = new Student();
            s.setAge("16");
            s.setName("ceshi");

            d.shuchu(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
