package ru.geekbrains.java1.dz;

public class dz1_redkin_vladimir {
    public static void main(String[] args) {
        byte a0=1;
        short a1=2;
        int a2=-3;
        long a3=200L;
        float a4=45.45f;
        double a5=53.53d;
        boolean bool=true;
        char ch='a';

        float f, a=2,b=4,c=6,d=0;
        if (d!=0){
            f = getResult(a, b, c, d);
            System.out.println("a*(b+(c/d)))= " + f);
        } else {System.out.println("Ошибка. Деление на 0");}

        bool=evaluateNumber(a,b);
        System.out.println("10<=(a+b)>=20 ?  -> "+bool);
        isPositive(a2);
        isPositive(0);
        System.out.println("A>0  ->"+isNegative(a2));
        printString("Петя");
        int year=1600;
        System.out.println("Является ли високосным "+year+" год?  -> "+isLY(year));
    }
    public static boolean isLY (int a){
        if (a%4==0) {
            if (a%400==0) {return true;}
            else if (a%100==0) {return false;}
            else {return true;}
        } else {return false;}
    }
    public static void printString(String s){
        System.out.println("Привет, "+s+"!");
    }
    public static void isPositive(int a){
        if (a>=0) {
            System.out.println("А положительное");
        } else {
            System.out.println("А отрицательное");
        }
    }

    public static boolean isNegative(int a){
        if (a<0) {return true;}
        else {return false;}
    }
    public static float getResult(float a,float b,float c,float d){
        float res=a*(b+(c/d));
        return res;
    }
    public static boolean evaluateNumber(float a, float b){
        float c=a+b;
        if (c>20||c<10) {return false;}
        else {return true;}
    }
}
