package DataStructure;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * leetcode 数据结构217，存在重复元素
 */
public class containsDuplicate {

    //排序法
    @Test
    public void testContainsDuplicate(){
        int[] num = {1,2,3,1};
        boolean b = containsDuplicate1(num);
        System.out.println(b);
    }

    //HashSet法
    @Test
    public void testContainsDuplicate2(){
        int[] num = {1,2,3,1};
        boolean b = containsDuplicate2(num);
        System.out.println(b);
    }

    // 先排序再比较是否有重复数据
    public boolean containsDuplicate1(int[] nums){
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
            return false;
        }

    //对于数组中每个元素，我们将它插入到哈希表中。如果插入一个元素时发现该元素已经存在于哈希表中，则说明存在重复的元素。
    public boolean containsDuplicate2(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums){
            if (!set.add(x)){
                return true;
            }
        }
        return false;
    }
}
