package com.monkey1024.cset;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSet04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //将输入的字符串转成字符数组
        char[] chars = str.toCharArray();

        TreeSet<Character> set = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                int num = c1.compareTo(c2);
                return num == 0 ? -1 : num;
            }
        });

        for (int i = 0; i < chars.length; i++){
            set.add(chars[i]);
        }

        System.out.println(set);
    }
}
