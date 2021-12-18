package Sort;

/**
 * Since 2021/11/16
 * @Author Peekaboo
 */

/**
 * 算法流程
 * 1、设定左右两端元素以及指向它的"指针"，取左端元素基准元素
 * 2、首先将基准元素与右端指针指向的元素相比较,若比基准元素大则右指针左移1位,相反则将元素放入左指针指向的位置中
 * 3、然后将基准元素与左端指针指向元素相比较,若比基准元素小则左指针右移1位,相反则将元素放入有指针位置中
 * 4、继续重复2、3步骤直到左、右端指针相碰,即不满足left<right条件。
 */
public class QuickSort1 {
    public static void main(String[] args) {
        int[] ins = {4, 7, 6, 5, 3, 2, 8, 1};
        int[] ins2 = sort(ins, 0, ins.length - 1);
        for (int in : ins2) {
            System.out.println(in);
        }
    }

    public static int[] sort(int[] ins, int start, int end) {
        if (start >= end) {
            return ins;//这个返回值并没有影响，因为这个返回值没有使用到。
        }
        int mid = ins[start];
        int left = start;//左"指针"
        int right = end;//右"指针"
        while (left < right) {
            while (left < right && ins[right] >= mid) {
                right -= 1;
            }
            ins[left] = ins[right];//右边值比基准元素要小则填入左边坑中

            while (left < right && ins[left] < mid) {
                left += 1;
            }
            ins[right] = ins[left];//
        }
        //继续重新开始下一次递归
        ins[left] = mid;
        sort(ins, start, left-1);
        sort(ins, left+1, end);
        return ins;
    }
}

