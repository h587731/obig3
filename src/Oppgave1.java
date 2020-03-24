import java.time.*;
import java.math.BigInteger;



public class Oppgave1 {


    public static void main(String[] args) {




        System.out.println(sum1a(100));



        int n = 35;

        System.out.println("Starting 1b with An = A"+ n );
        Instant start = Instant.now();
        System.out.println("A"+n+"= " +sum1b(n));
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time for unmemorized a" + n+": " +timeElapsed + "ms\n\n");

        System.out.println("Starting 1b but memorized with An = A"+ n );
        start = Instant.now();
        System.out.println("A"+n+"= " +sum1b(n, new long[n+1]));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time for memorized a" + n+": " +timeElapsed + "ms\n\n");

        n =2000;
        System.out.println("Starting 1b memorized with Bigintegers when An = A"+ n );
        start = Instant.now();
        System.out.println("A"+n+"= " +sum1b(n, new BigInteger[n+1]));
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time used to compute for a" + n+": " +timeElapsed + "ms\n\n");



        for( int i = 0 ; i <= 10 ; i++)
            System.out.println("A"+i + " = " + sum1b(i) );


        System.out.println("\n\nTowers of hanoi:");
        TowersOfHanoi hanoi = new TowersOfHanoi(20);



        long average= 0;
        for(int i = 0 ; i<50; i++){


            average = average+hanoi.solve();


        }




    }

    // Oppgave 1a:
    public static int sum1a(int n){
        if(n==1)
            return n;
        return n + sum1a(n-1);
    }

    // Oppgave 1b:
    public static long sum1b(int n){
        if(n==1)
            return 5;
        if(n<=0)
            return 2;
        return 5 * sum1b(n-1)-6*sum1b(n-2)+2;
    }

    // Oppgave 1b, memorized:
    public static long sum1b(int n, long [] memorized){
        if(n==1)
            return 5;
        if(n<=0)
            return 2;
        if(memorized[n]==0)
            memorized[n] = 5 * sum1b(n-1, memorized)-6* sum1b(n-2, memorized)+2;
        return memorized[n];
    }
    // Oppgave 1b, memorized and beefy:
    public static BigInteger sum1b(int n, BigInteger [] memorized){
        if(n==1)
            return BigInteger.valueOf(5);
        if(n<=0)
            return BigInteger.valueOf(2);
        if(memorized[n]==null)
            memorized[n] = BigInteger.valueOf(5).multiply(sum1b(n-1, memorized)).subtract(BigInteger.valueOf(6).multiply(sum1b(n-2, memorized))).add(BigInteger.valueOf(2));
        return memorized[n];
    }




}


/**
 * TowersOfHanoi represents the classic Towers of Hanoi puzzle.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
class TowersOfHanoi
{
    private int totalDisks;
    private long moves;
    /**
     * Sets up the puzzle with the specified number of disks.
     *
     * @param disks the number of disks
     */
    public TowersOfHanoi(int disks)
    {
        totalDisks = disks;
        moves = 0;
    }
    /**
     * Performs the initial call to moveTower to solve the puzzle.
     * Moves the disks from tower 1 to tower 3 using tower 2.
     */
    public long solve()
    {

        Instant start = Instant.now();
        moveTower(totalDisks, 1, 3, 2);
        Instant finish = Instant.now();

         return Duration.between(start, finish).toMillis();


    }

    /**
     * Moves the specified number of disks from one tower to another
     * by moving a subtower of n-1 disks out of the way, moving one
     * disk, then moving the subtower back. Base case of 1 disk.
     *
     * @param numDisks the number of disks to move
     * @param start
    the starting tower
     * @param end
    the ending tower
     * @param temp
    the temporary tower
     */
    private void moveTower(int numDisks, int start, int end, int temp)
    {
            if(numDisks==1)
                return;
            moveTower(numDisks-1, start, temp, end);
            moveTower(numDisks-1, temp, end, start);

    }
    /**
     * Prints instructions to move one disk from the specified start
     * tower to the specified end tower.
     *
     * @param start the starting tower
     * @param end
    the ending tower
     */
    private void moveOneDisk(int start, int end)
    {
        System.out.println("Move one disk from " + start + " to " + end);
    }
}