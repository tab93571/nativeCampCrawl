package IOOC.sort;

import IOOC.util.ArrayGenerator;
import IOOC.util.SortingHelper;

public class InsertionSort {

    private InsertionSort(){}

    public static void main(String[] args) {

        int[] dataSize = {1000};
        for(int n:dataSize){

            Integer[] arr = ArrayGenerator.generateRandomArray(n,n);

//            SortingHelper.sortTest("InsertSort",arr);
            SortingHelper.sortTest("InsertSortRevert",arr);

        }

    }
// 想想三種不同的logic

    /**
     * 原先的邏輯
     * @param arr
     * @param <E>
     */

    public static <E extends Comparable> void oldSort(E [] arr){

        for(int i =1 ;i<arr.length;i++){
            int count =0;
            E compare = arr[i];
            for(int j=i-1;j>=0;j--){

                if(compare.compareTo(arr[j])<0){
                    SortingHelper.swap(arr,i-count,j);
                    count++;
                }
            }

        }





    }

    public static <E extends Comparable> void sortBeforeRefine(E [] arr){

        for(int i =0 ;i<arr.length;i++){

//            for(int j=i;j>=1;j--){
//                if(arr[j].compareTo(arr[j-1])<0){
//                    SortingHelper.swap(arr,j-1,j);
//                }else break;
//            }

            for(int j=i;j>=1 && arr[j].compareTo(arr[j-1])<0 ;j--){
                SortingHelper.swap(arr,j-1,j);
            }

        }
    }

    public static <E extends Comparable> void sort(E [] arr){

        for(int i =0 ;i<arr.length;i++){

            E temp = arr[i];

//            for(int j=i;j>=1;j--){
//                if(temp.compareTo(arr[j-1])<0){
//                    arr[j] = arr[j-1];
//                }else {
//                    arr[j] = temp;
//                    break;
//                }
//            }
            int j;
            for( j=i;j>=1 && temp.compareTo(arr[j-1])<0 ;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;



        }
    }



    public static <E extends Comparable> void sort(E [] arr,int l,int r){

        for(int i = l ;i <= r; i++){

            E temp = arr[i];
            int j;
            for( j = i; j - 1 >= l && temp.compareTo(arr[j-1])<0 ;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }




    public static <E extends Comparable> void sortInReverseWay(E [] arr){

        for(int i = arr.length-1; i>=0;i--){

            E temp = arr[i];

//            for(int j=i;j>=1;j--){
//                if(temp.compareTo(arr[j-1])<0){
//                    arr[j] = arr[j-1];
//                }else {
//                    arr[j] = temp;
//                    break;
//                }
//            }
            int j;
            for( j=i;j<arr.length-1 && temp.compareTo(arr[j+1])>0 ;j++){
                arr[j] = arr[j+1];
            }
            arr[j] = temp;



        }
    }


}
