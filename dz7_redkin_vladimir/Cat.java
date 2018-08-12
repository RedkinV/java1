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
        this(name,appetite);
        this.fullness = fullness;
    }

    public void eat(Object o) {//            методя для варианта №1
        if (o == null) {System.out.println("передан нулевой объект"); return;}
        if (o instanceof Plate) {
            Plate p=(Plate)o;
            if (p.decreaseFood(appetite)) fullness = true;
            else fullness = false;
        } else System.out.println("Кошки могут есть только из Тарелки");
    }

    public boolean isFullness() {
        return fullness;
    }

    public void setFullness(boolean fullness) {
        this.fullness = fullness;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }
}
