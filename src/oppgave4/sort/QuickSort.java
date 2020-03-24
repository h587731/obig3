package oppgave4.sort;

public class QuickSort {

    public static void sort(Integer[] array){
        sort(array,0,array.length-1);
    }

    public static void sort(Integer[] array, int left, int right){
        if (array == null || array.length == 0 || left>=right)
            return;
        int pivot = array[left + (right - left) / 2], i = left, j = right;

        while (i <= j){
            while(array[i] < pivot) i++;
            while(array[j] > pivot) j--;
            if (i <= j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
            sort(array, left, j);
            sort(array, i, right);
    }
}
