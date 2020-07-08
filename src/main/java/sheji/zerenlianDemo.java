package sheji;

public class zerenlianDemo {
    public static void main(String[] args) {
        Leader jingli = new jingli();
        Leader gaoji = new gaoji();
        jingli.setLeader(gaoji);
        jingli.handle("sdfsdf");
    }
}

abstract class Leader{
    private Leader leader;

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    abstract void handle(String req);
}

class jingli extends Leader{

    void handle(String req) {
        System.out.println("jingli"+req);

        if (getLeader() !=null){
            getLeader().handle(req);
        }else{
            System.out.println("无下一人处理");
        }
    }

}

class gaoji extends Leader{

    void handle(String req) {
        System.out.println("gaoji"+req);

        if (getLeader() !=null){
            getLeader().handle(req);
        }else{
            System.out.println("无下一人处理");
        }
    }

}