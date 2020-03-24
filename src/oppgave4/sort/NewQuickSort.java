package oppgave4.sort;

public class NewQuickSort {

        private static final int MIN = 9;

        public static  void sort(Integer[] array) {
            sort(array, 0, array.length - 1);
            insort(array, 0, array.length);
        }

        public static  void sort(Integer[] array, int left, int right) {
            if (right - left + 1 < MIN)
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

    public static void insort(Integer[] array, int start, int end ){
        for(int j, i = start +1; i<end;i++){
            Integer insert = array[i];
            for(j = i-1; j>=0 && insert<array[j]; j--)
                array[j+1]=array[j];
            array[j+1]=insert;
        }
    }


}
