package TwoSum;

import java.util.Arrays;

public class TwoSum {

    //LeetCode01，两数之和，暴力法,时间复杂度o(n)2次方,空间复杂度O(1)
    public static int[] twoSum(int[] nums, int target){
        int n = nums.length;
        for (int i=0; i < n; i++ ){
            for (int j=i+1; j < n; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                    /*int[] array = new int[]{i,j};
                    return array;*/
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 7,15};
        int target = 12;
        int[] temp = twoSum(nums,target);
        System.out.println(Arrays.toString(temp));

    }

}
