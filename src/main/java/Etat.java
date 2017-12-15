package main.java;

import java.util.Random;

public class Etat {

    private int t;
    private int tmax;
    private int N;
    private int[] DIR = {N, N + 1, 1, 1 - N, -N, -N - 1, -1, -1 + N};
    private int[][] tval;

    Etat(int N, int tmax) {
        this.N = N;
        this.tmax = tmax;

        tval = new int[N * N][tmax];
        Random R = new Random();
        for (int k = 0; k < N * N; k++) {
            boolean b = R.nextBoolean();
            tval[k][t] = b ? 1 : 0;
        }
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (i == 0 || i == N - 1 || j == 0 || j == N - 1)
                    tval[i + N * j][t] = 2;
    }

    public Etat evol() {

        for (int k = 0; k < N * N; k++) {
            if (tval[k][t] != 2) {
                int S = 0;
                for (int d : DIR) {
                    S += tval[k + d][t];
                }
                tval[k][t + 1] = F(tval[k][t], S);
            }
        }
        Etat etat = new Etat(N, tmax);
        etat.tval = tval;
        return etat;
    }

    private int F(int O, int S) {
        if (S <= 3 || S >= 7) return 0;
        else return 1;

    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ret.append(tval[i + N * j][t]).append(" ");
            }
            ret.append('\n');
        }
        return ret.toString();
    }
}
