package IOOC.sort;

import java.util.Arrays;

public class Offer51 {

    static int res = 0;

    public static void main(String[] args) {
        int[] nums = {1,9,3,5,8,1,45,79,17,9,5,3,1,7,9,18,387,49,65,18,186,357,16,8,638};
        System.out.println(reversePairs(nums));

        int[] nums2 = {1,9,3,5,8,1,45,79,17,9,5,3,1,7,9,18,387,49,65,18,186,357,16,8,638};
        System.out.println(reversePairsMerge(nums2));
        System.out.println("----------------------------------------------------------");
        for(int i: nums2){
            System.out.println(i);
        }
    }



    public static int reversePairs(int[] nums){

        int res = 0;
        for(int i = 0 ; i < nums.length ; i ++ ){
            for(int j = i+1 ; j < nums.length ; j ++){
                if(nums[i] > nums[j]){
                    res ++;
                }
            }
        }
        return res;

    }

    public static int reversePairsMerge(int[] arr){

        int[] tempArray = new int[arr.length];

        res = 0;
        sort(arr,0,arr.length - 1 , tempArray );

        return res;
    }

    private static  void sort(int[] arr,int l,int r,int[] temp){

        if(l >= r ){
            return;
        }

        int mid = (r + l) / 2;

        sort(arr,l,mid,temp);
        sort(arr,mid+1,r,temp);

        if(arr[mid] > arr[mid+1]){
            merge(arr,l,mid,r,temp);
        }
    }

    private  static void merge(int[] arr, int l, int mid, int r, int[] temp) {

        System.arraycopy(arr, l, temp, l,r - l + 1);

        int i = l, j = mid + 1;

        for(int k = l ; k <= r ; k ++){
            if(i > mid){
                arr[k] = temp[j];
                j++;
            }else if(j > r){
                arr[k] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            }else{
                arr[k] = temp[j];
                j++;
                res += (mid-i+1);
            }
        }
    }
}

