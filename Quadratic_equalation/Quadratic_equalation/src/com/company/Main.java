package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        QuadraticEquation[] r = new QuadraticEquation[n];
        for(int i=0; i<r.length; i++){
            r[i] = new QuadraticEquation();
            r[i].setA(in.nextDouble());
            r[i].setB(in.nextDouble());
            r[i].setC(in.nextDouble());
        }
        for(int i=0; i<r.length; i++){

        }
    }
}
