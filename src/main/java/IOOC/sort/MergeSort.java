package IOOC.sort;

import IOOC.util.ArrayGenerator;
import IOOC.util.SortingHelper;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int n = 2000000;
//        Integer [] arr = ArrayGenerator.generateRandomArray(n,n);
//        SortingHelper.sortTest("mergeSort",arr);

        Integer [] arr2 = ArrayGenerator.generateRandomArray(n,n);
        SortingHelper.sortTest("mergeSort2",arr2);

//        Integer [] arr3 = ArrayGenerator.generateRandomArray(n,n);
//        SortingHelper.sortTest("mergeSort3",arr3);

        Integer [] arr4 = ArrayGenerator.generateRandomArray(n,n);
        SortingHelper.sortTest("mergeSort4",arr4);



    }

    public static <E extends Comparable> void sort(E[] arr){

        sort(arr,0, arr.length - 1);
    }


    private static <E extends Comparable> void sort(E[] arr,int l,int r){
        if(l >= r){
            return;
        }

//        int mid = (l+r)/2;

        int mid = l+(r-l)/2; // 防止越界

        sort(arr,l,mid);
        sort(arr,mid+1,r);

        merge(arr,l,mid,r);


    }

    public static <E extends Comparable> void sort2(E[] arr){

        sort2(arr,0, arr.length - 1);
    }


    private static <E extends Comparable> void sort2(E[] arr,int l,int r){
        if(l >= r){
            return;
        }
        int mid = l+(r-l)/2; // 防止越界

        sort2(arr,l,mid);
        sort2(arr,mid+1,r);

        if(arr[mid].compareTo(arr[mid +1])> 0){
            merge(arr,l,mid,r);
        }
    }

    public static <E extends Comparable> void sort3(E[] arr){

        sort3(arr,0, arr.length - 1);
    }


    private static <E extends Comparable> void sort3(E[] arr,int l,int r){

        //歸併排序在merge中要執行比較多東西，所以在數量比較少的時候不一定比較快
        //可以再一定數量以下用插入排序

        if(r-l <= 15){
            InsertionSort.sort(arr,l,r);
            return;
        }
        int mid = l+(r-l)/2; // 防止越界

        sort3(arr,l,mid);
        sort3(arr,mid+1,r);

        if(arr[mid].compareTo(arr[mid +1])> 0){
            merge(arr,l,mid,r);
        }
    }


    public static <E extends Comparable> void sort4(E[] arr){
        E[] tempArray = Arrays.copyOf(arr,arr.length);
        sort4(arr,0, arr.length - 1,tempArray);
    }


    private static <E extends Comparable> void sort4(E[] arr,int l,int r,E[] temp){

        if(l >= r){
            return;
        }
        int mid = l+(r-l)/2; // 防止越界

        sort4(arr,l,mid,temp);
        sort4(arr,mid+1,r,temp);

        if(arr[mid].compareTo(arr[mid +1])> 0){
            merge2(arr,l,mid,r,temp);
        }
    }





    private  static <E extends Comparable> void merge(E[] arr,int l,int mid,int r) {

        E[] tempArray = Arrays.copyOfRange(arr,l,r+1);

//        int p = 0;
//
//        int initIndex = l;
//
//        int q = (mid + 1) - initIndex;
//
//        while (p != (mid - initIndex) + 1 || q != (r - initIndex) + 1) {
//
//            if ((q > r - initIndex || p != (mid - initIndex) + 1 && tempArray[p].compareTo(tempArray[q]) <= 0)) {
//                arr[l] = tempArray[p];
//                p++;
//            } else if ((p > mid - initIndex || q != (r - initIndex) + 1 && tempArray[p].compareTo(tempArray[q]) > 0)) {
//                arr[l] = tempArray[q];
//                q++;
//            }
//            l++;
//        }

        int i = l ,j= mid +1;

        for(int k = l ; k <= r ; k ++){
            if(i > mid){
                arr[k] = tempArray[j - l];
                j++;
            }else if(j > r){
                arr[k] = tempArray[i - l];
                i++;
            }else if(tempArray[i-l] .compareTo(tempArray[j-l]) <= 0){
                arr[k] = tempArray[i - l];
                i++;
            }else{
                arr[k] = tempArray[j - l];
                j++;
            }
        }
    }

    private  static <E extends Comparable> void merge2(E[] arr,int l,int mid,int r,E[] tempArray) {

        System.arraycopy(arr,l,tempArray,l,r-l+1);

        int i = l ,j= mid + 1;

        for(int k = l ; k <= r ; k ++){
            if(i > mid){
                arr[k] = tempArray[j];
                j++;
            }else if(j > r){
                arr[k] = tempArray[i];
                i++;
            }else if(tempArray[i] .compareTo(tempArray[j]) <= 0){
                arr[k] = tempArray[i];
                i++;
            }else{
                arr[k] = tempArray[j];
                j++;
            }
        }
    }
}
