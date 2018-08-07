package ru.geekbrains.java1.dz.dz6_redkin_vladimir;

public class Cat extends Animal {

    public Cat(String name, float limitRun, float limitSwim, float limitJump) {
        super(name, limitRun, limitSwim, limitJump);
    }

    @Override
    public String swim(float a) {
        return "cats do not swim!";
    }
}
