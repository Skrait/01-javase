package com.monkey1024.overload_26;


public class MethodTest{
    
    public static void main(String[] args){
        
        System.out.println(sumInt(10,20));
        
        System.out.println(sumDouble(1.0,2.0));
        
        System.out.println(sumLong(10L,20L));

        System.out.println(sumFloat(1.0F,2.0F));
        
    }

    public static int sumInt(int a,int b){
    
        return a + b;
    
    }

    public static double sumDouble(double a,double b){
        
        return a + b;
        
    }
    
    public static long sumLong(long a,long b){
        
        return a + b;
        
    }
    
    public static float sumFloat(float a,float b){
        
        return a + b;
        
    }
    
}