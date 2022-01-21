package IOOC.sort;

import IOOC.util.ArrayGenerator;
import IOOC.util.SortingHelper;

public class QuickSort {


    public static void main(String[] args) {
//        Integer[] arr = {4,6,5,2,3,8,4,1};
//        QuickSort s = new QuickSort();
//        s.sort(arr);
//        for(Integer one : arr){
//            System.out.println(one);
//        }
        int n = 10000;

//        Integer [] arr3 = ArrayGenerator.generateRandomArray(n,n);
//        SortingHelper.sortTest("quickSort",arr3);
//
//        Integer [] arr5 = ArrayGenerator.generateRandomArray(n,n);
//        SortingHelper.sortTest("quickSort2",arr5);
////
//        Integer [] arr4 = ArrayGenerator.generateRandomArray(n,n);
//        SortingHelper.sortTest("mergeSort4",arr4);


        Integer [] arr5 = ArrayGenerator.generateOrderedArray(n);
        SortingHelper.sortTest("quickSort2",arr5);
//
        Integer [] arr4 = ArrayGenerator.generateOrderedArray(n);
        SortingHelper.sortTest("mergeSort4",arr4);
    }

    public  static <E extends Comparable> void sort(E[] arr){
        sort(arr,0,arr.length-1);

    }
    public  static <E extends Comparable> void sort2(E[] arr){
        sort2(arr,0,arr.length-1);

    }

    public  static <E extends Comparable> void sort(E[] arr, int l, int r){

        if(l >= r){
            return;
        }
        int p = partition(arr, l, r);

        sort(arr,l, p - 1);
        sort(arr, p + 1 ,r);
    }

    public  static <E extends Comparable> void sort2(E[] arr, int l, int r){

        if(r-l <= 15){
            InsertionSort.sort(arr,l,r);
            return;
        }

        int p = partition(arr, l, r);

        sort(arr,l, p - 1);
        sort(arr, p + 1 ,r);
    }

    //如果partition可以開額外的空間的話

    private static <E extends Comparable> int partition(E[] arr, int l, int r){

        E value = arr[l];

        int j = l;

        // arr[l + 1 .... j] < v 開區間
        //arr[j + 1 ... i-1 ] >=v
        //跑完下面的迴圈會的到上面的結果
        for(int i = l + 1 ; i <= r ; i++){
            if(arr[i].compareTo(value) < 0){
                j++;
                swap(arr,i,j);
            }

        }
        swap(arr,l,j);
        return j;

    }

    private static <E extends Comparable> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }





}
