package ru.geekbrains.java1.dz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class dz4_redkin_vladimir {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
//    public static char[][] map={{'X','O','*','O','X'},
//                                {'X','X','O','*','X'},
//                                {'O','O','*','*','*'},
//                                {'O','O','X','*','*'},
//                                {'*','*','*','X','X'}};
    public static char[][] map= new char[SIZE][SIZE];
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {//main
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    } //end main

    public static boolean checkWin(char symb) {

        int chH, chV;//переменные для определения кол-ва символов  в стоках/столбцах
        int chD1,chD2; //переменные для определения кол-ва символов  в диагоналях
        int chD1L,chD1R,chD2L,chD2R;//переменные для определения кол-ва символов  в линиях параллельных диагоналям слева и справа
        chD1=chD2=chD1L=chD1R=chD2L=chD2R=0;
        for (int i = 0; i <SIZE; i++) {
            chH=chV=0;
            for (int j = 0; j <SIZE; j++) {
                if(map[i][j]==symb) chH++;//считаем кол-во symbol в строке
                if(map[j][i]==symb) chV++; //считаем кол-во symbol в столбце
                if (i==j&&map[i][j]==symb) chD1++; //считаем кол-во symbol в гл.диагонали
                if (i-j==-1 && map[i][j]==symb) chD1L++;//считаем кол-во symbol в линии слева от гл.диагонали
                if (i-j==1 && map[i][j]==symb) chD1R++;//считаем кол-во symbol в линии справа от гл.диагонали

                if ( (i+j==SIZE-1)&&map[i][j]==symb) chD2++; //считаем кол-во symbol во второстепенной диагонали
                if ( (i+j==SIZE-2) && map[i][j]==symb) chD2L++;//считаем кол-во symbol в линии слева от второст.диагонали
                if ( (i+j==SIZE) && map[i][j]==symb) chD2R++;//считаем кол-во symbol в линии справа от второст.диагонали

            }
            if (chH==DOTS_TO_WIN && (map[i][0]!=map[i][SIZE-1])) {return true;} // проверяем строку на выигрыш
            if (chV==DOTS_TO_WIN&& (map[0][i]!=map[SIZE-1][i])) {return true;}// проверяем столбец на выигрыш
            if (chV==SIZE||chH==SIZE) return true;//на случай, если все символы в строках/столбцах  =symbol
         }
        if (chD1==DOTS_TO_WIN) {return true;} //проверяем диагонали на выигрыш
        if (chD2==DOTS_TO_WIN) {return true;}
        if (chD1==SIZE||chD2==SIZE) return true; //на случай, если все символы в диагоналях =symbol

        if (chD1L==DOTS_TO_WIN ||chD1R==DOTS_TO_WIN ||chD2L==DOTS_TO_WIN ||chD2R==DOTS_TO_WIN ) {
            return true; //проверяем линии параллельные диагоналям диагонали на выигрыш
        }


        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        int[] arr=new int[2];
        arr=aiBestMove();//запрашиваем координаты "лучшего хода"
        do {
            if (arr!=null) {
             x=arr[0];
             y=arr[1];
                System.out.println("aiBestMove="+Arrays.toString(arr));
            }
            else {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            }
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static int[] aiBestMove(){ //вычисляет координаты лучшего кода
        int chH, chV; //переменные для определения кол-ва символов  в стоках/столбцах
        int chV8,chH8; //переменные для подсчета  * в стоках и столбцах
        int[] arr= new int[2];

        for (int i = 0; i <SIZE; i++) {
            chH=chV=chV8=chH8=0;
            for (int j = 0; j <SIZE; j++) {//определяем строчки/стоолбцы, где больше Х
                if(map[i][j]==DOT_X) chH++;
                if(map[j][i]==DOT_X) chV++;
                if(map[i][j]==DOT_EMPTY) chH8++;//считаем сколько * в стоке/столбце
                if(map[j][i]==DOT_EMPTY) chV8++;

            }
            if (chH>=chV&&chH>0&&isValidEmpty(i,-1)) {//для строчки проверяем имеет ли смысл в ней ствить О
                for (int j = 0; j <SIZE; j++) {
                    if (map[i][j]==DOT_EMPTY) {
                        if (j==0&&chH8>1) continue;//чтобы ai не ставил О в самом начале строчки
                        arr[0]=j;
                        arr[1]=i;
                        return arr; // если смысл есть, возвращаем координаты
                    }
                }
            }
            else if (chV>=chH&&chV>0&&isValidEmpty(-1,i)) {//для столбцы проверяем имеет ли смысл в нем ствить О
                for (int j = 0; j <SIZE; j++) {
                    if (map[j][i]==DOT_EMPTY) {
                        if (j==0&&chV8>1) continue;//чтобы ai не ставил О в самом начале столбца
                        arr[0]=i;
                        arr[1]=j;
                        return arr; // если смысл есть, возвращаем координаты
                    }
                }
            }
        }
        return arr=null; //если не нашли "подозрительные"сточки/столбцыб возвращаем null
    }
    public static boolean isValidEmpty(int y,int x){// проверяет на наличие * и отсутвие О на позициях 2-4
        boolean isEmp,isO;
        isEmp=isO=false;
        if (y==-1) {
            for (int j = 0; j <SIZE; j++) { // проверка на * и наличие О  на позициях 2-4.  Это для столбцов
                if (map[j][x] == DOT_EMPTY) isEmp=true;
                if (map[j][x] == DOT_O&&j>0&&j<SIZE-1) isO=true;
            }
            if (isEmp==true && isO==false) return true;
            else return false;
        }
        if (x==-1) {
            for (int i = 0; i <SIZE; i++) { // проверка на * и наличие О  на позициях 2-4.  Это для строк
                if (map[y][i] == DOT_EMPTY) isEmp=true;
                if (map[y][i] == DOT_O&&i>0&&i<SIZE-1) isO=true;
            }
            if (isEmp==true && isO==false) return true;
            else return false;
        }
        return false;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}// end class
