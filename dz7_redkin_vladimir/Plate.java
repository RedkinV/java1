package ru.geekbrains.java1.dz.dz7_redkin_vladimir;

public class Plate {
    private int food;
    private int maxFood;


    public Plate(int food) {
        this.food = food;
    }

    public Plate(int food, int maxFood) {
        this(food);
        this.maxFood = maxFood;
    }

    public boolean decreaseFood(int n) {
        if (n<food) {food -= n; return true;}
        else return false;
    }
    public void info() {
        System.out.printf("plate:%-9d Plate capacity %d%n",food,maxFood);
    }
    public void addFood(int addFood){
        if((food+addFood)>maxFood) food=maxFood;
        else food+=addFood;
    }

    public int getFood() {
        return food;
    }
}
