package Exponentiation;

import java.util.Scanner;
import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, l, last;
        n = in.nextInt();
        String zastepcza;
        int[][] tab = new int[n][2];
        String[] tabstring = new String [n];
        for(int i=0; i<n; i++){
                tab[i][0] = in.nextInt();
                tab[i][1] = in.nextInt();
            tabstring[i]=Integer.toString((int)(pow(tab[i][0],tab[i][1])));
        }
        for(int i=0; i<n; i++){
            zastepcza = tabstring[i];
            l = zastepcza.length();
            last = zastepcza.charAt(l-1) - 48;
            System.out.println(last);
        }
    }
}
