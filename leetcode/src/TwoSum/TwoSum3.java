package TwoSum;

import java.util.Arrays;
import java.util.HashMap;

class TwoSum3 {
    //LeetCode01，两数之和,单循环map匹配。
    public static int[] twoSum(int[] nums, int target) {

        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表

        HashMap<Integer,Integer> hash = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            if(hash.containsKey(nums[i])){

                indexs[0] = i;

                indexs[1] = hash.get(nums[i]);

            }

            // 将数据存入 key为补数 ，value为下标

            hash.put(target-nums[i],i);

        }

        return indexs;

    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 7,15};
        int target = 12;
        int[] temp = twoSum(nums,target);
        System.out.println(Arrays.toString(temp));

    }

}
