package com.monkey1024.alist;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList01 {


    /**
     * java.util.ArrayList与java.util.Arrays.ArrayList
     * 辨别ArrayList真假李逵
     */
    @Test
    public void fakeArrayList(){
        Integer[] i = {128,12,1};
        List<Integer> arrayLIst = Arrays.asList(i);
        ArrayList<Integer> list = new ArrayList<>(arrayLIst);
        list.add(123);
        System.out.println(list);
    }
}
