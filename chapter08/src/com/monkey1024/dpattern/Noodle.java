package com.monkey1024.dpattern;

/**
 * Author Peekaboo
 * Date 2022/2/6 19:02
 * 拉面类
 */
public class Noodle implements NoodleDecorate{

    /**
     * 普通拉面做好之后，会向里面添加一些食材
     */
    @Override
    public void addThings() {
        System.out.println("加两片肉");
        System.out.println("加一片萝卜");
    }
}
