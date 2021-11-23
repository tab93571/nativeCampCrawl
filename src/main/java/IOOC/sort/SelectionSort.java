package IOOC.sort;

import IOOC.util.ArrayGenerator;
import IOOC.util.SortingHelper;

public class SelectionSort {

    public static void main(String[] args) {

//        Integer[]arr = new Integer[]{5,8,9,3,1,6};
//        sort(arr);
//        for(int i :arr){
//            System.out.println(i);
//        }
//
//        Student[] students = {new Student("Alice",98),
//                new Student("Austin",100),
//                new Student("Gen",70)
//
//        };

//        for(Student one :students){
//            System.out.println(one);
//        }

        int[] dataSize = {1000,10000,100000};
        for(int n:dataSize){

            Integer[] arr = ArrayGenerator.generateRandomArray(n,n);

//            SortingHelper.sortTest("SelectionSort",arr);
            SortingHelper.sortTest("SelectionSortReverse",arr);

        }





    }

    public static <E extends Comparable> void sort(E [] arr){

        for(int i =0 ;i<arr.length;i++){
            int minIndex = i;
            for(int j = i+1; j<arr.length;j++){
                if(arr[j].compareTo(arr[minIndex])<0){
                    minIndex=j;
                }
            }

            SortingHelper.swap(arr,minIndex,i);

        }


    }

    public static <E extends Comparable> void sortReverseWay(E [] arr){

        for(int i =arr.length-1 ;i>0;i--){
            int maxIndex = i;
            for(int j = i-1; j>=0;j--){
                if(arr[j].compareTo(arr[maxIndex])>0){
                    maxIndex=j;
                }
            }

            SortingHelper.swap(arr,maxIndex,i);

        }


    }






}
