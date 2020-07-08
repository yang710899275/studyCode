package sheji;

public class gongchangchouxiang {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        farm f;
        Animal a ;
        f = (farm) Class.forName("sheji.animalFarm").newInstance();
         a = (Animal) f.newAnimal();
        a.show();
    }
}

interface plant{
    void show();
}

class fruit implements plant{

    public void show() {
        System.out.println("水果");
    }
}

class shucai implements plant{
    public void show(){
        System.out.println("蔬菜");
    }
}

interface farm{
    Object newAnimal();
    Object newPlant();
}

class animalFarm implements farm{

    public Object newAnimal() {
        return new horse();
    }

    public Object newPlant() {
        return new fruit();
    }
}

class plantFarm implements farm{

    public Object newAnimal() {
        return new cattle();
    }

    public Object newPlant() {
        return new shucai();
    }
}