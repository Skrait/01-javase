package Sort;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {-9,78,0,23,-567,70};
    }

    public static void quickSort(int[] arr, int left,int right){
        int l = left;//左下标
        int r = right;//右下标
        int pivot = arr[(left + right) / 2];//中轴值

        /*while循环目的是让比pivot值小的放到左边，
        * 比pivot大的放在右边*/
        while( l < r){
            //在pivot左边一直找到大于pivot的值，直至退出
            while( arr[l] < pivot){
                l += 1;
            }

            //在pivot右边一直找到小于或等于pivot的值，直至退出
            while( arr[r] > pivot){
                r -= 1;
            }
        }
    }
}
