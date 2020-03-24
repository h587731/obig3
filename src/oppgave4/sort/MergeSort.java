package oppgave4.sort;

public class MergeSort {

    public static void sort(Integer[] array){
        sort(array, new Integer[array.length]);
    }

    public static void sort(Integer[] array,Integer[] temp){
        int split = array.length/2;
        sort(array, temp, 0, split);
        sort(array, temp, split+1, array.length-1);
        merge(array, temp, 0, array.length -1);
    }

    public static void sort(Integer[] array, Integer[] temp,int left, int right){
        if(left>=right)
            return;
        int split = (left+right)/2;
        sort(array, temp, left, split);
        sort(array, temp, split+1, right);
        merge(array, temp, left, right );
    }

    public  static void merge(Integer[] array, Integer[] temp, int leftStart, int rightEnd){
        int index, left = index = leftStart;
        int leftEnd = (left + rightEnd)/2;
        int right = leftEnd + 1;

        for(;left <= leftEnd && right <= rightEnd; index++) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
        }
        System.arraycopy(array,left,temp,index,leftEnd-left+1);
        System.arraycopy(array, right,temp,index,rightEnd-right+1);
        System.arraycopy(temp,leftStart,array,leftStart,rightEnd-leftStart+1);
    }
}
