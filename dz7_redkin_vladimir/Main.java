package ru.geekbrains.java1.dz.dz7_redkin_vladimir;


public class Main {
    public static void main(String[] args) {
        Cat[] arrCat=new Cat[5];
        arrCat[0] = new Cat("Barsik", 15,false);
        arrCat[1] = new Cat("Mursic", 7,false);
        arrCat[2] = new Cat("Pushok", 14,false);
        arrCat[3] = new Cat("Vaska", 9,false);
        arrCat[4] = new Cat("Tishka", 17,false);
        Plate plate = new Plate(30,60);

        System.out.println("---Вариант 1, метод eat в классе Cat----------------------------------------------");
        plate.info();
        for (int i = 0; i <arrCat.length ; i++) {
            plate.addFood((i%2)*10);//добавление еды
            arrCat[i].eat(plate);
            System.out.printf("%-20S Сытость - %-15b Остаток еды в тарелке - %d %n",arrCat[i].getName(),arrCat[i].isFullness(),plate.getFood());
        }
        plate.info();
        System.out.println("---Вариант 2, метод eat в классе Plate---------------------------------------------");

        plate = new Plate(30,60);
        plate.info();
        for (int i = 0; i <arrCat.length ; i++) {
            plate.addFood((i%2)*10);//добавление еды
            plate.eat(arrCat[i]);
            System.out.printf("%-20S Сытость - %-15b Остаток еды в тарелке - %d %n",arrCat[i].getName(),arrCat[i].isFullness(),plate.getFood());
        }
        plate.info();
    }

}
