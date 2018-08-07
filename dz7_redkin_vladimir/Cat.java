package ru.geekbrains.java1.dz.dz7_redkin_vladimir;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public Cat(String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }

    public void eat(Plate p) {
        if(p.decreaseFood(appetite)) fullness=true;
        else fullness=false;
    }

    public boolean isFullness() {
        return fullness;
    }

    public String getName() {
        return name;
    }
}
