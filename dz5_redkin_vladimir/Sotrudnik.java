package ru.geekbrains.java1.dz.dz5_redkin_vladimir;

public class Sotrudnik {
    private String fio;
    private String position;
    private String email;
    private String phoneNo;
    private int salary;
    private int age;

    public void printSotrudnik(){
        System.out.printf("Информация по сотруднику ФИО- %-15S Должность- %-10S Email- %-15s Т.номер: %-15S ЗП руб.-%-5d  Возраст-%-10d%n",
                fio,position,email,phoneNo,salary,age);
    }

    public Sotrudnik(String fio, String position, String email, String phoneNo, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phoneNo = phoneNo;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
