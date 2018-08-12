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
    public void addFood(int addFood){
        if((food+addFood)>maxFood) food=maxFood;
        else food+=addFood;
    }
    public void info() {
        System.out.printf("Еды в тарелке: %-5d Емкость тарелки: %d%n",food,maxFood);
    }
    public int getFood() {
        return food;
    }

//метод для варианта №2
    public void eat(Object o){
        if (o == null) {System.out.println("передан нулевой объект"); return;}
        if (o instanceof Cat) {
            Cat c = (Cat) o;
            if (c.getAppetite() < food) {
                food -= c.getAppetite();
                c.setFullness(true);
            } else c.setFullness(false);
        } else System.out.println("Только Кошки едят из этой тарелки");

    }
}
