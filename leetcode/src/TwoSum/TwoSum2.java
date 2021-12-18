package TwoSum;

import java.util.HashMap;

public class TwoSum2 {

    //LeetCode01，两数之和，Map法,时间复杂度o(n),空间复杂度O(n)
    public static void twoSum2(){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] nums = {1, 5, 6, 7,15};
        int target = 12;
        for (int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        System.out.println("存取的Map" + map);

        for (int i = 0;i<nums.length;i++){
            int value = target-nums[i];//迭代存取12减去每个数组值后的值。
            //这个判断当目标数减去数组里的数时，有可能在数组中不存在，也就是没有对应的建
            if (map.containsKey ( value ) && map.get(value) > i){
                System.out.println("数组序号为：["+i+","+map.get ( value )+"]");
                System.out.println("对应数值分别为：["+nums[i]+","+nums[map.get ( value )]+"]");
            }
        }
    }

    public static void main(String[] args) {
        twoSum2();

    }

}
