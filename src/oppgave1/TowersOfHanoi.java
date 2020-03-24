package oppgave1;

public class TowersOfHanoi {
    private int totalDisks;
    public long antallFlyttinger = 0L;

    public TowersOfHanoi(int disks) {
        this.totalDisks = disks;
    }

    public void solve() {
        this.moveTower(this.totalDisks, 1, 3, 2);
    }

    private void moveTower(int numDisks, int start, int end, int temp) {
        if (numDisks != 1) {
            this.moveTower(numDisks - 1, start, temp, end);
            this.moveTower(numDisks - 1, temp, end, start);
        }

    }

    private void moveOneDisk(int start, int end) {
        this.tellFlyttinger();
    }

    private void tellFlyttinger() {
        ++this.antallFlyttinger;
    }

    public void setTotalDisks(int totalDisks) {
        this.totalDisks = totalDisks;
    }

    public int getTotalDisks() {
        return this.totalDisks;
    }
}
