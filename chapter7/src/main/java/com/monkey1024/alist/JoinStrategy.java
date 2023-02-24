package com.monkey1024.alist;

public enum JoinStrategy {
    INNER_JOIN,//内连接
    LEFT_JOIN,//左连接
    RIGHT_JOIN,//右连接
    LEFT_SEMI_JOIN,//左半连接，结果只取左表，连接条件是左表和右表的交集
    LEFT_ANTI_JOIN,//左半连接，结果只取左表，连接条件是左表与右表的差集
    FULL_JOIN;//全连接
}