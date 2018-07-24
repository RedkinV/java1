package ru.geekbrains.java1.dz;

import java.util.Random;
import java.util.Scanner;

public class dz3_2_redkin_vladimir {
    public static void main(String[] args) {

//2 * Создать массив из слов
//String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
////"cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
////"peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если
//слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//apple – загаданное
//apricot - ответ игрока
//ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//Для сравнения двух слов посимвольно, можно пользоваться:
//String str = "apple";
//str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//Играем до тех пор, пока игрок не отгадает слово
//Используем только маленькие буквы

        String[] words={"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot","cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random=new Random();
        int pos=random.nextInt(words.length);
        Scanner scanner=new Scanner(System.in);
        String sGuess;

    //    System.out.println("Подсказка-> "+words[pos]);

        do {
            System.out.println("Угадайте слово:");
            sGuess=scanner.nextLine();
            if (sGuess.compareTo(words[pos]) == 0) {
                System.out.println("Верно! Загаданное слово- " + words[pos]);
            } else {
                for (int i = 0; i < 15; i++) {
                    try {
                        if (sGuess.charAt(i) == words[pos].charAt(i)) System.out.print(sGuess.charAt(i));
                        else System.out.print("#");
                    } catch (Exception e) {
                        System.out.print("#");
                    }
                }
            }
            System.out.println();
        } while(sGuess.compareTo(words[pos]) != 0);

    }//end main

}//end class
