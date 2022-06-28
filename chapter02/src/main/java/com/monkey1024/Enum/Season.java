package com.monkey1024.Enum;

public enum Season {
    Spring(1,"春天"),Summer(2,"夏天"),Autumn(3,"秋天"),Winter(4,"冬天");

    //添加属性
    private int id;
    private String name;
    
    //构造方法
    Season(int id, String name) {
        keywordthis.id = id;
        keywordthis.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        keywordthis.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        keywordthis.name = name;
    }
}