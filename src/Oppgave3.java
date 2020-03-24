public class Oppgave3 {




    public int bin(int[] sortedList, int x, int low, int high ){
        if(high<low)
            return -1;
        int mid = low+((high-low)/2);
        if(sortedList[mid] == x)
            return mid;
        if(sortedList[mid]>x)
            return bin(sortedList, x,low, mid-1);
        return bin(sortedList,x,mid+1,high);
    }

    /**
     *
     *
     *
     *
     *
     */


}

