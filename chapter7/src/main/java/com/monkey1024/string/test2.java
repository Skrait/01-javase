package com.monkey1024.string;

/**
 * @author Peekaboo
 * @date 2022年09月23日 21:03
 */
public class test2 {

    public static void main(String[] args) {
        int i = compareVersion("1.0", "1.0.0");
        System.out.println(i);
    }
    public static int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int n1 = str1.length;
        int n2 = str2.length;
        for(int i=0, j=0; i<n1 || j<n2; i++, j++){
            int num1 = i >= n1 ? 0 : Integer.parseInt(str1[i]);
            int num2 = j >= n2 ? 0 : Integer.parseInt(str2[j]);
            if(num1 < num2){
                return -1;
            }else if(num1 > num2){
                return 1;
            }
        }
        return 0;
    }
}
