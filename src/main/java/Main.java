package main.java;

public class Main {

    public static void main(String[] args) {
        int dim = 18;
        int tmax = 10;
        Etat E = new Etat(dim, tmax);
        int N = 10;
        int n = 0;
        System.out.println(E);
//        while (n < N) {
//            E = E.evol();
//            System.out.println(E);
//            n++;
//        }
    }
}
