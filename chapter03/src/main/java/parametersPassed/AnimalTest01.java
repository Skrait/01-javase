package parametersPassed;

/**
 * @Author Peekaboo
 * Date 2022/6/22 17:33
 * Animal测试类
 */
public class AnimalTest01 {

    /**
     * 方法传递参数是引用数据类型Animal
     */
    public static void m1(Animal a){
        a.setAge(66);
        System.out.println("m1中的age=" + a.getAge());
    }

    public static void main(String[] args) {
        //创建Animal对象
        Animal a = new Animal();
        a.setAge(10);
        m1(a);

        System.out.println("main中的age:" + a.getAge());
    }
}
