package ru.geekbrains.java1.dz.dz8_redkin_vladimir;

public class Calculator {
    private int num1;
    private int num2;
    private int total;

    public Calculator() {
    }

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.total=this.num1+this.num2;
    }
    public double determinePercentage (){
        return (double)this.num1/(double)this.total;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getTotal() {
        return total;
    }
}
