package com.monkey1024.cset;

import java.util.HashSet;
import java.util.Set;

public class HashSet01 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        hs.add("b");
        hs.add("c");
        hs.add("d");

    for(String s : hs){
        System.out.println(s);
    }
    }
        
}
