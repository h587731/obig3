package oppgave4.sort;

public class RadixSort {

    public static void sort(Integer[]array){
        sort(array,array.length);
    }

    public static void sort(Integer[]array, int n){
        int maxVal= array[0];
        Integer[] output = new Integer[n];
            for(int i = 0; i < n; i++){
                if(array[i] > maxVal)
                    maxVal = array[i];
            }
        for (int exp = 1; maxVal/exp > 0; exp *= 10)
            countSort(array, n, exp, output);
    }


    public static void countSort(Integer[] array, int n, int exp,Integer[] output )    {
        int[] count = new int[11];
        for (int i = 0; i < n; i++)
            count[(array[i]/exp)%10+1]++;
        for (int i = 0; i < 10; i++)
            count[i+1] += count[i];
        for (int i = 0; i < n; i++)
            output[count[((array[i]/exp)%10)]++] = array[i];
        System.arraycopy(output, 0, array, 0, n);
    }

}
