package com.monkey1024.bother;

public class Args01 {
    public static void main(String[] args) {
        print(1,2,3,4);

    }

    public static void print(int ... arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
