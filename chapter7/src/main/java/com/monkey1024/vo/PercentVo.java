package com.monkey1024.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PercentVo {
    /**
     * 数量
     */
    private int number;
    /**
     * 百分比
     */
    private int percent;
    /**
     * 小数点后的余额，不需要返回给前端
     */
    private Double point;
    /**
     * 组名
     */
    private String name;
 
    public PercentVo(int number, String name) {
        this.number = number;
        this.name = name;
    }
}