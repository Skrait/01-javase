package com.jg.test;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;

/**
 * Author Peekaboo
 * Date 2022/4/17 23:16
 */
public class DateTest {

    @Test
    public void testInstant(){
        //Instant instant = Instant.ofEpochMilli(new Date().getTime());
    //Instant.now()
        System.out.println("LocalDate.now() = " + LocalDate.now());
    }
}
