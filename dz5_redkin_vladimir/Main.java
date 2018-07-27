package ru.geekbrains.java1.dz.dz5_redkin_vladimir;

public class Main {
    public static void main(String[] args) {
        Sotrudnik[] sArray=new Sotrudnik[5];
        sArray[0]=new Sotrudnik("Петров ВВ","Dir","qaz@mail.com","+7911212121",500,50);
        sArray[1]=new Sotrudnik("Сидоров АИ","sales","wsx@mail.com","+7903454446",100,30);
        sArray[2]=new Sotrudnik("Прокофьев АП","buyer","edc@mail.com","+7912345543",100,30);
        sArray[3]=new Sotrudnik("Гончаров ВУ","hr","rfv@mail.com","+7910994434",150,45);
        sArray[4]=new Sotrudnik("Сотовичук ВА","fin.dir","tgb@mail.com","+7915773854",150,41);

        for (int i = 0; i <sArray.length ; i++) {
            if(sArray[i].getAge()>40) sArray[i].printSotrudnik();
        }

    }
}
