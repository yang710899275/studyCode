package sheji;

public class gongchangfangfa {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        AnimalFarm a;
        Animal c;
        a = (AnimalFarm) Class.forName("sheji.cattleFarm").newInstance();
        c = (Animal) a.newAnimal();
        c.show();
        System.out.println();
        System.out.println(a.getClass().getName());
    }
}

interface Animal{
    void show();
}

class cattle implements Animal{

    public void show() {
        System.out.println("牛ccc");
    }
}

class horse implements Animal{
    public void show(){
        System.out.println("马11");
    }
}

interface AnimalFarm{
    Object newAnimal();
}

class cattleFarm implements AnimalFarm{

    public Object newAnimal() {
        return new cattle();
    }
}

class horseFarm implements AnimalFarm{
    public Object newAnimal(){
        return new horse();
    }
}
