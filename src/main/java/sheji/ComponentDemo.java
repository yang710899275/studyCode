package sheji;

import java.util.ArrayList;

public class ComponentDemo {

    public static void main(String[] args) {
        float s=0;
               Bags BigBag,mediumBag,smallRedBag,smallWhiteBag;
                Goods sp;
                BigBag=new Bags("大袋子");
                mediumBag=new Bags("中袋子");
                smallRedBag=new Bags("红色小袋子");
                smallWhiteBag=new Bags("白色小袋子");
                sp=new Goods("婺源特产",2,7.9f);
                smallRedBag.add(sp);
                sp=new Goods("婺源地图",1,9.9f);
                smallRedBag.add(sp);
                sp=new Goods("韶关香菇",2,68);
                smallWhiteBag.add(sp);
                sp=new Goods("韶关红茶",3,180);
                smallWhiteBag.add(sp);
                sp=new Goods("景德镇瓷器",1,380);
                mediumBag.add(sp);
                mediumBag.add(smallRedBag);
                sp=new Goods("李宁牌运动鞋",1,198);
                BigBag.add(sp);
                BigBag.add(smallWhiteBag);
                BigBag.add(mediumBag);
                System.out.println("您选购的商品有：");
                BigBag.show();
                s=BigBag.caculation();
                System.out.println("要支付的总价是："+s+"元");

    }
}

interface Articles{
    //计算
    float caculation();
    //显示
    void show();

}

class Goods implements Articles{
    private String name;
    private int number;
    private float price;
    public Goods(String name,int number,float price){
        this.name = name;
        this.number = number;
        this.price = price;
    }
    public float caculation() {
        return number * price;
    }

    public void show() {
        System.out.println("商品为"+name+"，数量"+number+",价格"+price);
    }
}

class Bags implements Articles{
    
    private String name;
    private float s;
    private ArrayList<Articles> li = new ArrayList<Articles>();

    public Bags(String name){
        this.name =name;
    }
    public float caculation() {
        for (Object obj:li) {
            s += ((Articles)obj).caculation();
        }
        return s;
    }
    
    public void add(Articles a){
        li.add(a);
    }
    
    public void remove(Articles a){
        li.remove(a);
    }

    public void show() {
        for (Object obj:li) {
            ((Articles)obj).show();
        }
    }
}
