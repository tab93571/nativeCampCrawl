package IOOC.sort;

import IOOC.util.SortingHelper;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] testMerge = {1,3,8,9,2,4,5,6};
        merge(testMerge,0,3,7);

        for(Integer one : testMerge){
            System.out.println(one);
        }

        //1,2,3,4,5,6,8,9

    }


    public static <E extends Comparable> void sort(E[] arr,int l,int r){
        if(l >= r){
            return;
        }

        int mid = (l+r)/2;

        sort(arr,l,mid);
        sort(arr,mid+1,r);

        merge(arr,l,mid,r);
    }

    public  static <E extends Comparable> void merge(E[] arr,int l,int mid,int r){

        E[]tempArray = (E[]) new Integer[r-l+1];

        int count = 0;

        for(int i = l ; i <= r ; i++ ){
            tempArray[count] = arr[i];
            count ++;
        }

        int p= 0;
        int q = mid+1;
        int initIndex = l;

        while(p != mid - initIndex  || q != r - initIndex){

            if((tempArray[p].compareTo( tempArray[q]) <= 0 && p != mid - initIndex)  || q == r - initIndex){
                arr[l] = tempArray[p];
                p++;
            }else if((tempArray[p].compareTo( tempArray[q]) > 0 && q != r - initIndex) || p == mid - initIndex){
                arr[l] = tempArray[q];
                q++;
            }
            l++;

        }


    }

}
