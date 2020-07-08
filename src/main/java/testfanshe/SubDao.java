package testfanshe;

public class SubDao extends Dao<Student> {

        public void shuchu(Student s){
            System.out.println(s);
        }

        public interface  ccc{
            public void aaaa();
            public  void bbbb();
    }

    public static void  staShuchu(Student s){
        System.out.println("静态方法:" + s);
    }

    private static void  staShuchuPrivate(Student s){
        System.out.println("静态私有方法:" + s);
    }
}
