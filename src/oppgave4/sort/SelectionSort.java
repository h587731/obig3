package oppgave4.sort;

public class SelectionSort {
    public static void sort(Integer[] array){
        for(int i=0 ; i < array.length; i++ ) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j]<array[min])
                    min=j;
            }
            Integer temp = array[i];
            array[i] = array[min];
            array[min]=temp;
        }
    }
}
