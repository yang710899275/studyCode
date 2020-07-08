package testTryCatch;

public class test {
    public static void main(String[] args) {
        test t = new test();
        try{
            t.test1();
            System.out.println("222");
        }catch (Exception e){
            System.out.println("test catch");
            e.printStackTrace();
        }
    }

    private String test1(){
        try{
            int a = 3/0;
        }catch (Exception e){
            System.out.println("test1 catch");
            throw e;
        }
        System.out.println("333");
        return "";
    }

    private void test2(){
        test1();
    }
}
