package sheji;

public class jianzaozheDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        builder b = (builder) Class.forName("sheji.build2").newInstance();
        Director d = new Director(b);
        product build = d.build();
        build.show();
    }
}

class product{
    private String a;
    private String b;
    private String c;

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void show(){
        System.out.println(a+b+c);
    }
}

abstract class builder{
    protected product p = new product();
    abstract void builda();
    abstract void buildb();
    abstract void buildc();

    public product getResult(){
        return p;
    }


}

class build extends builder{

    void builda() {
        p.setA("aa");
    }

    void buildb() {
        p.setB("bbb");
    }

    void buildc() {
        p.setC("ccc");
    }
}

class build2 extends builder{

    void builda() {
        p.setA("aa2");
    }

    void buildb() {
        p.setB("bbb2");
    }

    void buildc() {
        p.setC("ccc2");
    }
}

class Director{
    private builder b;
    public Director(builder b){
        this.b = b;
    }

    public product build(){
        b.builda();
        b.buildb();
        b.buildc();

        return b.getResult();
    }
}