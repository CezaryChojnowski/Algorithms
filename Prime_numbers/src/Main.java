import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        Liczba[] liczba = new Liczba[n];
        for(int i=0; i<liczba.length; i++){
            liczba[i] = new Liczba();
            liczba[i].setA(in.nextInt());
        }
        for(int i=0; i<liczba.length; i++){
            if((liczba[i].czyPierwsza(liczba[i].getA()))==true){
                System.out.println("TAK");
            }
            else{
                System.out.println("NIE");
            }

        }
    }
}
