package oppgave4.sort;

public class InsertionSort {
    public static void sort(Integer[] list){
        for(int j, i = 1; i<list.length;i++){
            Integer insert = list[i];
            for(j = i-1; j>=0 && insert<list[j]; j--)
                list[j+1]=list[j];
            list[j+1]=insert;
        }
    }
}
