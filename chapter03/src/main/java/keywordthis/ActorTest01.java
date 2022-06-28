package keywordthis;

/**
 * @Author Peekaboo
 * Date 2022/6/24 14:30
 */
public class ActorTest01 {
    public static void main(String[] args) {

        Actor a = new Actor();
        a.setName("范冰冰");
        a.act1();
        a.act2();
    }
}


class Actor{

    private String name;

    public void act1(){
        //定义一个局部变量name
        String name = "周润发";
        System.out.println("name=" + name);
        System.out.println("this.name:" + this.name);
    }

    public void act2(){
        System.out.println("name=" + name);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
