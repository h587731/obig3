package oppgave4.client2;

import oppgave4.random.RandomList;
import oppgave4.sort.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.function.Consumer;

public class ClientSort {
    public static void main(String[] args) {
        int nStartValue = 5000;
        int runs =  20;
        int range = 10000;


        String tableHeader =  String.format("  f(n) = n log(n)      range = 0 -> "+range+ "\n\n|%-10s|%-15s|%-13s|%-13s|%-13s|%-10s|", "n", "Times executed", "Total time", "Average Time", "T(n) = c*f(n)" , "c =");

        System.out.println("\nQuicksort: "+tableHeader);
        for(int i = 0, n = nStartValue; i < 6 ; n = n*2, i++)
            runAndPrint(QuickSort::sort, RandomList.make(n, range), runs ,n, n*(Math.log(n) / Math.log(2))  );

        System.out.println("\nInsortQuicksort: "+tableHeader);
        for(int i = 0, n = nStartValue; i < 6 ; n = n*2, i++)
            runAndPrint(NewQuickSort::sort, RandomList.make(n, range), runs ,n, n*(Math.log(n) / Math.log(2))  );


        System.out.println("\nMergesort:"+tableHeader);
        for(int i = 0, n = nStartValue ; i < 6 ; n=n*2, i++)
            runAndPrint(MergeSort::sort, RandomList.make(n, range), runs ,n, n*(Math.log(n) / Math.log(2))  );


        tableHeader =  String.format("  f(n) = k*n |k = log_b_(l) |l = largest value; b= base.      range = 0 -> "+range+ "\n\n|%-10s|%-15s|%-13s|%-13s|%-13s|%-10s|", "n", "Times executed", "Total time", "Average Time", "T(n) = c*f(n)" , "c =");

        System.out.println("\nRadixsort:"+tableHeader);
        for(int i = 0, n = nStartValue ; i < 6 ; n=n*2, i++)
            runAndPrint(RadixSort::sort, RandomList.make(n, range), runs ,n, n*(Math.log(range) / Math.log(10))  );


        tableHeader = String.format("     f(n) = n^2      range = 0 -> "+range+ "\n\n|%-10s|%-15s|%-13s|%-13s|%-13s|%-10s|", "n", "Times executed","Total time", "Average Time", "T(n) = c*f(n)" , "c =");

        System.out.println("\nSelectionSort:"+tableHeader);
        for(int i = 0, n = nStartValue/10; i < 6 ; n = n+n, i++)
            runAndPrint(SelectionSort::sort, RandomList.make(n, range), runs ,n,Math.pow(n,2)  );

        System.out.println("\nInsertionSort:"+tableHeader);
        for(int i = 0, n = nStartValue/10; i < 6 ; n = n+n, i++)
            runAndPrint(InsertionSort::sort, RandomList.make(n, range), runs ,n, Math.pow(n,2)  );

        System.out.println("\nBubbleSort:"+tableHeader);
        for(int i = 0, n = nStartValue/10; i < 6 ; n= n+n, i++)
            runAndPrint(BubbleSort::sort, RandomList.make(n, range), runs ,n, Math.pow(n,2)  );

    }


    public static void runAndPrint(Consumer<Integer[] > sortFunction, Integer[] array, int runs, int n, double fofn ){

        double average= 0;
        for(int i = 0 ; i<runs; i++){
            Instant start = Instant.now();
            sortFunction.accept(Arrays.copyOf(array, array.length));
            Instant finish = Instant.now();
            average = average + Duration.between(start, finish).toNanos();
        }

        System.out.println(String.format("|%10d|%15s|%11.4f s|%10.2f ms|c*%11.0f|%10.2f|", n, runs,average/1000000000 , (average/runs)/1000000,fofn ,(average/fofn) ));

    }



}
