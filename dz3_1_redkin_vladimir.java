package ru.geekbrains.java1.dz;

import java.util.Random;
import java.util.Scanner;

public class dz3_1_redkin_vladimir {
    public static void main(String[] args) {
//1 Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
//попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
//указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
//выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)
        Scanner scanner= new Scanner(System.in);
        Random random=new Random();
        int num=random.nextInt(9);
        int guess, cont;

        do {
            for (int i = 0; i < 3; i++) {
                System.out.println("Угадайте число от 0 до 9. Попытка №" + (i + 1));
                guess = scanner.nextInt();
                if (guess == num) {
                    System.out.println("Угадали!");
                    break;
                } else {
                    if (i<2) System.out.println("ваше число " + ((guess > num) ? "больше" : "меньше") + " загаданного");
                    else System.out.println("Вы проиграли.");
                }
            }
            do {
                System.out.println(" Продолжить? 1-да/0-нет");
                cont=scanner.nextInt();
            }while (cont!=1&&cont!=0);
        } while (cont!=0);


    }//end main

}//end class
