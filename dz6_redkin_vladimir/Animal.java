package ru.geekbrains.java1.dz.dz6_redkin_vladimir;

public class Animal {
    private String name;
    private float limitRun;
    private float limitSwim;
    private float limitJump;

    public Animal(String name, float limitRun, float limitSwim, float limitJump) {
        this.name = name;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        this.limitJump = limitJump;
    }

    public String run(float a){
        if (a< limitRun) return "run:true";
        else return "run:false";
    }
    public String swim(float a){
        if (a< limitSwim) return "swim:true";
        else return "swim:false";
    }
    public String jump(float a){
        if (a< limitJump) return "jump:true";
        else return "jump:false";
    }
    public String getName() {
        return name;
    }

    public float getLimitRun() {
        return limitRun;
    }

    public float getLimitSwim() {
        return limitSwim;
    }

    public float getLimitJump() {
        return limitJump;
    }

}
