package codeBlocks;

/**
 * @Author Peekaboo
 * Date 2022/6/24 15:25
 */
public class BlockTest01 {

    public static void main(String[] args) {
        //局部代码块,限定变量的生命周期
        {
            int x = 10;
            System.out.println(x);
        }

        Student s1 = new Student();
        System.out.println("------------");
        Student s2 = new Student();
    }

    static {
        System.out.println("main方法中的静态代码块");
    }


}
class Student{

    public Student(){
        System.out.println("构造方法");
    }

    //构造代码块:类中方法外用{}包裹,每创建一次对象都会执行一次，先于构造方法执行
    {
        System.out.println("构造代码块");
    }

    static {
        System.out.println("静态代码块");
    }

}
