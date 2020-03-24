package oppgave1;

import java.io.PrintStream;

public class TowersDemo {
    static TowersOfHanoi towersOfHanoi2 = new TowersOfHanoi(2);
    static TowersOfHanoi towersOfHanoi3 = new TowersOfHanoi(3);
    static TowersOfHanoi towersOfHanoi4 = new TowersOfHanoi(4);
    static TowersOfHanoi towersOfHanoiTest = new TowersOfHanoi(16);
    static long startTime;
    static long endTime;

    public TowersDemo() {
    }

    public static void main(String[] args) {
        towersOfHanoi2.setTotalDisks(28);
        towersOfHanoi3.setTotalDisks(30);
        towersOfHanoi4.setTotalDisks(32);
        tidsbruk(towersOfHanoi2);
        tidsbruk(towersOfHanoi3);
        tidsbruk(towersOfHanoi4);
    }

    public static void tidsbruk(TowersOfHanoi n) {
        startTime = System.currentTimeMillis();
        n.solve();
        endTime = System.currentTimeMillis();
        long x = (long)Math.pow(2.0D, (double)n.getTotalDisks());
        PrintStream var10000 = System.out;
        int var10001 = n.getTotalDisks();
        var10000.println("AA loese Towers of Hanoi for " + var10001 + " ringer,\nmed " + (x - 1L) + " flyttinger, krevde\n" + (endTime - startTime) + " millisekunder\n\n");
        endTime = 0L;
        startTime = 0L;
    }

    public static void tidsbrukGjennomsnitt(TowersOfHanoi n, int ganger) {
        long avg = 0L;

        for(int i = 0; i <= ganger; ++i) {
            startTime = System.currentTimeMillis();
            n.solve();
            endTime = System.currentTimeMillis();
            avg += endTime - startTime;
            endTime = 0L;
            startTime = 0L;
        }

        avg /= (long)ganger;
        System.out.println("AA loese Towers of Hanoi for " + n.getTotalDisks() + " ringer,\nmed " + n.antallFlyttinger + " flyttinger,\nkrevde i gjennomsnitt ut av " + ganger + " utførelser, " + avg + " millisekunder\n\n");
    }
}
