package oppgave4.client2;

import oppgave4.random.RandomList;
import oppgave4.sort.MergeSort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.function.Consumer;

public class ClientSort {
    public static void main(String[] args) {
        Integer[] copy, array = RandomList.make(2550, 10000);

        runAndPrint(MergeSort::sort, array, 20 );

//        System.out.print("Random             : "+Arrays.toString(array)+"\n");
//
//        System.out.print("QuickSort          : ");
//        copy = Arrays.copyOf(array, array.length);
//        QuickSort.sort(copy);
//        System.out.println(Arrays.toString(copy));
//
//        System.out.print("MergeSort          : ");
//        copy = Arrays.copyOf(array, array.length);
//        MergeSort.sort(copy);
//        System.out.println(Arrays.toString(copy));
//
//        System.out.print("BubbleSort         : ");
//        copy = Arrays.copyOf(array, array.length);
//        BubbleSort.sort(copy);
//        System.out.println(Arrays.toString(copy));
//
//        System.out.print("InsertionSort      : ");
//        copy = Arrays.copyOf(array, array.length);
//        InsertionSort.sort(copy);
//        System.out.println(Arrays.toString(copy));
//
//        System.out.print("SelectionSort      : ");
//        copy = Arrays.copyOf(array, array.length);
//        SelectionSort.sort(copy);
//        System.out.println(Arrays.toString(copy));

    }


    public static void runAndPrint(Consumer<Integer[] > sortFunction, Integer[] array, int runs){
        Integer[] copy = array;
        long average= 0;

        for(int i = 0 ; i<runs; i++){
            copy = Arrays.copyOf(array, array.length);
            Instant start = Instant.now();
            sortFunction.accept(copy);
            Instant finish = Instant.now();

            long time =  Duration.between(start, finish).toNanos();
            System.out.println(time+" ns run #"+ runs);
            average = average + time;

        }

        Object[][] table = new String[4][];
        table[0] = new String[] { "n", "Iterations", "Average", "Theoretical time c*f(n) " };
        table[1] = new String[] { "bar2", "foo2", "baz2" };
        table[2] = new String[] { "baz3", "bar3", "foo3" };
        table[3] = new String[] { "foo4", "bar4", "baz4" };

        for (final Object[] row : table) {
            System.out.format("%-15s%-15s%-15s\n", row);
        }


        System.out.print("Sorted            : "+Arrays.toString(copy)+"\n");
        System.out.println((average/runs)+"ns Average");






        System.out.print("Sorted            : "+Arrays.toString(array)+"\n");


    }



}
