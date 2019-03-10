package com.company;

import java.util.*;

/* pojedynczy element */
class Elem {
    int wartosc;
    Elem next;

    /* konstruktor */
    public Elem(int x, Elem n){
        next=n;
        wartosc=x;
    }

    /* zwracam wskzaznik na nastepny obiekt */
    public Elem getNext(){
        return next;
    }

    /* zwracam przechowywana wartosc */
    public int getWartosc(){
        return wartosc;
    }
}


class Stos {

    /* wierzcholek stosu */
    Elem start;

    Stos(){
        start=null;
    }

    /* zwracam wartosc wierzcholka */
    public Elem getStart(){
        return start;
    }

    /* dodaje element do stosu */
    public void push(int x){
        Elem temp = new Elem(x,start);
        start=temp;
    }

    /* sciagam element ze stosu */
    public void pop(){
        if(start!=null){
            start = start.getNext();
        } else {
            System.out.println("Stos jest pusty");
        }

    }

    /* wyswietlam zawartosc stosu */
    public void show(){
        if(start!=null){
            Elem temp = start;
            while(temp!=null){
                System.out.print(temp.getWartosc() + " ");
                temp=temp.getNext();
            }
            System.out.println();
        } else {
            System.out.println("Stos jest pusty");
        }
    }

    /* zwracam ile elementow jest na stosie */
    public int zlicz(){
        if(start!=null){
            Elem temp = start;
            int licznik=0;
            while(temp!=null){
                licznik++;
                temp = temp.getNext();
            }
            return licznik;
        }
        else return 0;
    }

    /*
     * odwracam kolejnosc elemetow na stosie
     * wspomagajac sie dodatkowymi dwoma stosami
     */
    public void reverse(Stos stos2, Stos stos3){
        if(start!=null){
            Elem temp = start;
            while(temp!=null){
                stos2.push(temp.getWartosc());
                this.pop();
                temp=temp.getNext();
            }
            while(stos2.getStart()!=null){
                stos3.push(stos2.getStart().getWartosc());
                stos2.pop();
            }
            while(stos3.getStart()!=null){
                this.push(stos3.getStart().getWartosc());
                stos3.pop();
            }
        }
    }

    /*
     * porzadkuje kolejnosc elementow na
     * stosie (od min do max)
     *
     */
    public void sort(Stos stos2){
        if(start!=null){
            int licznik = this.zlicz();
            int max, licznik2=0;

            while(licznik!=0){

                Elem temp = start;
                max = temp.getWartosc();
                while(temp!=null){
                    if(max>temp.getWartosc()){
                        max = temp.getWartosc();
                    }
                    temp = temp.getNext();
                }

                while(start!=null){
                    if(start.getWartosc()!=max){
                        stos2.push(start.getWartosc());
                        this.pop();
                        licznik2++;
                    } else {
                        this.pop();
                        while(licznik2!=0){
                            this.push(stos2.getStart().getWartosc());
                            stos2.pop();
                            licznik2--;
                        }
                        stos2.push(max);
                        break;
                    }
                }
                licznik--;
            }

            while(stos2.getStart()!=null){
                this.push(stos2.getStart().getWartosc());
                stos2.pop();
            }
        } else {
            System.out.println("Stos jest pusty");
        }
    }

    public static void menu(){
        System.out.println("(0) Menu\n(1) PUSH\n(2) POP\n(3) SHOW");
        System.out.println("(4) ZLICZ\n(5) REVERSE\n(6) SORT\n(7) EXIT");
    }

    /* main */
    public static void main(String[]args){
        Stos stos1 = new Stos();
        Stos stos2 = new Stos();
        Stos stos3 = new Stos();

        Scanner in = new Scanner(System.in);

        int t;

        while(in.hasNext()){
            t=in.nextInt();
            switch(t){
                case 0: Stos.menu();break;
                case 1: t=in.nextInt();stos1.push(t);break;
                case 2: stos1.pop();break;
                case 3:stos1.show();break;
                case 4:System.out.println(stos1.zlicz());break;
                case 5:stos1.reverse(stos2, stos3);break;
                case 6:stos1.sort(stos2);break;
                case 7:System.exit(0);
                default:;
            }
        }


    }
}