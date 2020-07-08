package testfanshe;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        SubDao subDao = new SubDao();
        System.out.println(subDao.getClass().getCanonicalName());
        System.out.println(subDao.getClass().getName());
        System.out.println(subDao.getClass().getGenericSuperclass());
        Type genericSuperclass = subDao.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType){
            System.out.println("1");
        }
        Student s = new Student();
        Type t2 = s.getClass().getGenericSuperclass();
        if (t2 instanceof ParameterizedType){
            System.out.println("t2");
        }
        ParameterizedType p=(ParameterizedType)genericSuperclass;

        Type[] t = p.getActualTypeArguments();
        System.out.println(t.length);
        Class  c = (Class)t[0];
      /*  System.out.println(c.getDeclaredFields().length);
        Field name = c.getDeclaredField("name");
        Object o = c.newInstance();
        name.setAccessible(true);
        name.set(o,"sdfsdf");
        System.out.println(name.get(o));*/
       /* System.out.println(c.toString());*/

        Class<? extends Dao> clazz = null;
        try {
            clazz =  (Class<? extends Dao>)Class.forName(c.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (clazz != null) {
            System.out.println("Aaaaaaa");
            System.out.println(clazz.getName());
        }
        System.out.println();


    }
}
