package oppgave1;
public class SumTall {
    public SumTall() {
    }

    public static void main(String[] args) {
        int tall = 100;
        int ans = sumN(tall);
        System.out.println(ans);
    }

    private static int sumN(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n == 1 ? 1 : n + sumN(n - 1);
        }
    }
}
