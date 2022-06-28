package com.monkey1024.dpattern;

/**
 * Author Peekaboo
 * Date 2022/2/6 19:08
 * 加辣椒的拉面
 */
public class ChiliNoodle implements NoodleDecorate{

    //普通拉面成员变量
    private Noodle noodle;

    public ChiliNoodle(Noodle noodle) {
        keywordthis.noodle = noodle;
    }

    /**
     *
     */
    @Override
    public void addThings() {
        noodle.addThings();
        System.out.println("三勺辣椒");
    }
}
