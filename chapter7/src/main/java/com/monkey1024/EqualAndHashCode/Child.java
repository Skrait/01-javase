package com.monkey1024.EqualAndHashCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author Peekaboo
 * Date 2022/2/17 16:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Child extends Parent{

    private String name;



}
