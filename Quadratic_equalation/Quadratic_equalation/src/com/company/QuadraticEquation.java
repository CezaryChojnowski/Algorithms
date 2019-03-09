package com.company;
import static java.lang.Math.*;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    private double delta;
    private double x1;
    private double x2;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDelta() {
        return delta;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }


    public void CheckAIfDifferentFromZero(double a){
        if(a==0){
            System.out.println("Współczynnik a wynosi 0");
        }
        else{
            CountDelta(a,b,c);
        }
    }
    public double CountDelta(double a, double b, double c){
            return delta = pow(b,2) - 4 * a * c;
        }
    private int CheckTheNumberOfSolutions(double delta){
        if(delta>0){
            return 2;
        }
        else if(delta==0){
            return 1;
        }
        else{
            return 0;
        }
    }
    public void CoutSolutions(double a, double b, double delta){
        x1=(-b-sqrt(delta))/2*a;
        x2=(-b+sqrt(delta))/2*a;
    }
    public void CoutSolutions(double a, double b){

        x1=(-b)/(a*2);
    }
}
