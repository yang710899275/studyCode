package sheji;

public class yuanxingDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student("张三");
        s1.show();
        Student s2 = (Student) s1.clone();
        s2.setName("cccc");
        s2.show();

    }

}

class Student implements Cloneable{

    private String name;
    public Student(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void  show(){
        System.out.println("名字为"+name);
    }

    public Object clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }
}