package structure;

/**
 * @Author Peekaboo
 * Date 2022/6/24 10:58
 */
public class User {

    private String name;
    private Integer age;

    /**
     * 定义无参构造方法
     */
    User(){
        System.out.println("User的无参构造方法");

    }

    /**
     * 构造方法是可以构成重载的，可以写个有参数的构造方法为对象进行数据初始化
     */
    User(String _name,int _age){
        name = _name;
        age = _age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}
