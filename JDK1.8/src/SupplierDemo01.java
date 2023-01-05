import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author Peekaboo
 * @date 2023年01月04日 11:47
 * Supplier<T>接口被称为生产型接口，指定接口的泛型是什么类型，那么接口中的get方法
 * 就会产生什么类型的时间
 */
public class SupplierDemo01 {

    public static String getString(Supplier<String> supplier){
        return supplier.get();
    }

    @Test
    public void supplierTest01(){
        String s = getString(()->{
            return "张三";
        });
        System.out.println(s);
    }

    public static Integer getMax(Supplier<Integer> supplier){
        return supplier.get();
    }

    @Test
    public void getMaxTest(){
        int arr[] = {12,41,42,64,673,632,55};

        int value = getMax(()->{
            int max = 0;
            for (int i : arr) {
                if (i>max){
                    max = i;
                }
            }
            return max;
        });
        System.out.println(value);
    }

}
