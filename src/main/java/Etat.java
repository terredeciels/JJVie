package main.java;

import java.util.Random;

public class Etat {

    private int N;
    private int[] DIR = {N, N + 1, 1, 1 - N, -N, -N - 1, -1, -1 + N};
    private int[] tval;

    Etat(int N) {
        this.N = N;
        tval = new int[N * N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (i == 0 || i == N - 1 || j == 0 || j == N - 1)
                    tval[i + N * j] = 2;
    }

    public void randomInit() {
        Random R = new Random();
        for (int i = 1; i < N-1; i++)
            for (int j = 1; j < N - 1; j++)
                tval[i + N * j] = R.nextBoolean() ? 1 : 0;
    }

    public Etat evol() {
        Etat etat = new Etat(N);
        for (int k = 0; k < N * N; k++) {
            if (tval[k] != 2) {
                int S = 0;
                for (int d : DIR) {
                    S += tval[k + d];
                }
                etat.tval[k] = F(S);
            }
        }
        return etat;
    }

    private int F(int S) {
        if (S <= 3 || S >= 7) return 0;
        else return 1;

    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ret.append(tval[i + N * j]).append(" ");
            }
            ret.append('\n');
        }
        return ret.toString();
    }
}
