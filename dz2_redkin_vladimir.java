package ru.geekbrains.java1.dz;

import java.util.Arrays;

public class dz2_redkin_vladimir {
    public static void main(String[] args) {
// 1 Задать целочисленный массив, состоящий из элементов 0 и 1. С помощью цикла и условия заменить 0 на 1, 1 на 0;
      int[] arr1={1,1,0,0,1,0,1,1,0,0,0};
        System.out.println(Arrays.toString(arr1)+" было");
        for (int i=0;i<arr1.length;i++){
            if (arr1[i]==0) arr1[i]=1;
            else arr1[i]=0;
        }
        System.out.println(Arrays.toString(arr1)+" стало");

// 2 Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        int[] arr2= new int[8];
        for (int i=0;i<arr2.length;i++){
            arr2[i]=i*3;
        }
        System.out.println(Arrays.toString(arr2));

//3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arr3={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3)+" было");
        for(int i=0;i<arr3.length;i++){
            if (arr3[i]<6) arr3[i]*=2;
        }
        System.out.println(Arrays.toString(arr3)+" стало");
//Создать квадратный двумерный целочисленный массив (количество строк и столбцов
// одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] arr4=new int[5][5];
        for(int i=0;i<arr4.length;i++){
            for(int j=0;j<arr4[i].length;j++){
                if(i==j) arr4[i][j]=1;
                System.out.print(arr4[i][j]);
            }
            System.out.println();
        }
//5 ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (безпомощи интернета);

        int[] arr5={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max,min;
        max=min=arr5[0];
        for (int i=0;i<arr5.length;i++){
            if (arr5[i]<min) min=arr5[i];
            if (arr5[i]>max) max=arr5[i];
        }
        System.out.println(Arrays.toString(arr5)+"<- анализируемый массив");
        System.out.println("max="+max+"; min="+min);
//6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части
//массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) →
//false, checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не
//входят

        int[] arr6= {13,1,4,3,5};    //{1, 5, 3, 2, 11, 4, 4, 11, 2, 3, 5, 1};
        System.out.println("checkBalace"+ Arrays.toString(arr6)+" ->"+checkBalance(arr6));
// **** Написать метод, которому на вход подаётся одномерный массив и число n (может быть
//положительным, или отрицательным), при этом метод должен сместить все элементы
//массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными
//массивами.

        int[] arr7={1,2,3,4,5,6,7,8,9,10};
        int n1=7,n;
        if (n1<0) n=Math.abs(n1);
        else n=arr7.length-n1;

        System.out.println(Arrays.toString(arr7)+"изначальный массив");
        int j=0;
        for (int i=0;i<n;i++){
            arr7=firstToTheEnd(arr7);
            j++;
            }
        System.out.println(Arrays.toString(arr7)+"сдвинутый на "+n1+" позиций");

        //end main
    }
    public static int[]firstToTheEnd(int[] arr){
        int temp;
        for (int i=0;i<arr.length-1;i++){
            temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
        return arr;
    }
public static boolean checkBalance(int[] arr){
      int sum1,sum2,flag=0;
      for (int i:arr){
          if (i!=0) flag=1;
      }
      if (flag==0) {
          System.out.println("empty array!!!");return false;
      }
      sum1=0;
      for (int i=0;i<arr.length;i++){
          sum1=sum1+arr[i];
          sum2=0;
          for(int j=i+1;j<arr.length;j++){
              sum2=sum2+arr[j];
          }
          if (sum1==sum2) {return true;}
      }
return false;
}
//end class
}
