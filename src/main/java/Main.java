package main.java;

public class Main {

    public static void main(String[] args) {
        int N = 18;// (16x16)
        Etat E = new Etat(N);
        E.randomInit();
        System.out.println(E);

        int tmax=10;
        int t=0;
        while (t < tmax) {
            E = E.evol();
            System.out.println();
            System.out.println(E);
            t++;
        }
    }
}
