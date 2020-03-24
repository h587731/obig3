package oppgave4.random;
import java.util.Random;

public class RandomList {
    static Random rand = new Random();
    public static Integer[] make(int n, int range){
        Integer[] temp = new Integer[n];

        for (int i = 0; i < n;i++)
            temp[i] = rand.nextInt(range);
        return temp;
    }





}
