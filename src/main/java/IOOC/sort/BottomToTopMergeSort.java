package IOOC.sort;

import java.util.Arrays;

public class BottomToTopMergeSort {

    public static void main(String[] args) {

//        Integer[] arr = {3,1,5,6,4,3,8,7,5,6};
//        sort(arr);


    }


    public static <E extends Comparable> void sort(E[] arr){
        E[] tempArray = Arrays.copyOf(arr,arr.length);
        int n = arr.length;

        //遍歷合併區間長度
        for(int sz = 1; sz < n; sz += sz){
            //遍歷兩個區間的起始位置i
            //合[i, i+sz -1]和[i + sz,Math.min(i+sz+sz-1,n-1)]
            for(int i = 0; i + sz < n ; i += sz + sz){

                //todo figure out why i+sz<n 會是迴圈終止條件

                if(arr[i + sz - 1].compareTo(arr[i + sz]) > 0){
                    merge(arr,i,i+sz-1, Math.min(i+sz+sz-1,n-1), tempArray);
                }
            }
        }
    }


    private  static <E extends Comparable> void merge(E[] arr,int l,int mid,int r,E[] tempArray) {

        System.arraycopy(arr,l,tempArray,l,r-l+1);

        int i = l ,j= mid +1;

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
