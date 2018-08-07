package ru.geekbrains.java1.dz.dz6_redkin_vladimir;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Animal[] a=new Animal[5];
        a[0]=new Cat("Cat1", 200,0,2);//метод swim для класса Cat переопредлен
        a[1]=new Cat("Cat2",250,0,3);//метод swim для класса Cat переопредлен
        a[2]=new Dog("Dog1",500,10,0.5f);
        a[3]=new Dog("Dog2",400,15,0.9f);
        a[4]=new Dog("Dog3",600,20,1);

        int r=500;
        int s=12;
        float j=0.5f;

        System.out.printf("%-15s %-15s %-20s %-15s%n", "Name","Run","Swim","Jump" );
        System.out.println("---------------------------------------------------------");

        System.out.printf("%-15s %-15d %-20d %-15.1f%n","inputs",r,s,j);

        for (int i = 0; i <a.length ; i++) {

            System.out.printf("%-15s %-15s %-20s %-15s%n",a[i].getName(),a[i].run(r),a[i].swim(s),a[i].jump(j));

        }
    }
}
