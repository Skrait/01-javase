package com.jg.lambda;

import org.junit.Test;

public class LambdaStudy1 {
    public static void main(String[] args) {
        //开启普通线程,通过实现Runnable接口方式
        Runnable runnable = new Runnable(){
            @Override
            public void  run(){
                for (int i = 0; i < 10; i++){
                    System.out.println("1号线程开启了" + i);
                }
            }
        };

        //开启普通线程,通过实现Runnable接口方式
        Runnable runnable2 = new Runnable(){
            public void  run(){
                for (int i = 0; i < 10; i++){
                    System.out.println("2号线程开启了" + i);
                }
            }
        };

        //开启普通线程,通过实现Runnable接口方式
        Runnable runnable3 = new Runnable(){
            public void  run(){
                for (int i = 0; i < 10; i++){
                    System.out.println("3号线程开启了" + i);
                }
            }
        };
        new Thread(runnable).start();
        new Thread(runnable2).start();
        new Thread(runnable3).start();
    }

    @Test
    public void testThreadLambda() {
        /**
         * Lambda的思想,只关注做什么不关注怎么做
         * (参数列表)->(方法体)
         */

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Lambda" + i);
            }
        }).start();
    }
}
