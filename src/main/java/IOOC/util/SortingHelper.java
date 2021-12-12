package IOOC.util;
import IOOC.sort.InsertionSort;
import IOOC.sort.MergeSort;
import IOOC.sort.QuickSort;
import IOOC.sort.SelectionSort;
public class SortingHelper {
    private SortingHelper(){}

    public static<E extends Comparable<E>> boolean isSorted(E[]arr){

        for(int i=1;i< arr.length;i++){
            if(arr[i-1].compareTo(arr[i])>0){
                return false;
            }
        }
        return true;

    }

    public static<E extends Comparable<E>> void sortTest(String sortName,E[]arr){
        long startTime = System.nanoTime();

        //todo 用反射實現
        if(sortName.equals("SelectionSort")){
            SelectionSort.sort(arr);
        }

        if(sortName.equals("SelectionSortReverse")){
            SelectionSort.sortReverseWay(arr);
        }
        if(sortName.equals("InsertSort")){
            InsertionSort.sort(arr);
        }
        if(sortName.equals("InsertSortRevert")){
            InsertionSort.sortInReverseWay(arr);
        }
        if(sortName.equals("mergeSort")){
            MergeSort.sort(arr);
        }
        if(sortName.equals("mergeSort2")){
            MergeSort.sort2(arr);
        }
        if(sortName.equals("mergeSort3")){
            MergeSort.sort3(arr);
        }
        if(sortName.equals("mergeSort4")){
            MergeSort.sort4(arr);
        }
        if(sortName.equals("mergeSort4")){
            MergeSort.sort4(arr);
        }
        if(sortName.equals("quickSort")){
            QuickSort.sort(arr);
        }
        if(sortName.equals("quickSort2")){
            QuickSort.sort2(arr);
        }

        long endTime = System.nanoTime();

        double time = (endTime-startTime)/1000000000.0;

        if(!SortingHelper.isSorted(arr)){
            throw new RuntimeException("sorting fail");
        }
        System.out.println(time+ "s");




    }

    public static<E> void swap(E[]arr,int i,int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
