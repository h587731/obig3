package oppgave4.sort;

public class BubbleSort {

    public static void sort(Integer[] array){
        boolean sorted=true;
        for(int i = 0 ; i < array.length-1; i++ ,sorted=true){
            for(int j = 0 ; j < array.length-1 ;j++){
                if(array[j]>array[j+1]){
                    Integer temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    sorted=false;
                }
            }
            if(sorted)
                break;
        }



    }





}
