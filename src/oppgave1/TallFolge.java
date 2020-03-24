package oppgave1;

public class TallFolge {
    public TallFolge() {
    }

    public static void main(String[] args) {
        int ledd = 10;

        for(int i = 0; i <= ledd; ++i) {
            System.out.println(tallFolge(i));
        }

        System.out.println();
        int ans = tallFolge(ledd);
        System.out.println(ans);
    }

    private static int tallFolge(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 5;
        } else {
            int ans = 5 * tallFolge(n - 1) - 6 * tallFolge(n - 2) + 2;
            return ans;
        }
    }
}
