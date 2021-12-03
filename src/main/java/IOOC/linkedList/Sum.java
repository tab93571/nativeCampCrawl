package IOOC.linkedList;

public class Sum {

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    //計算arr[l...n)這個區間內所有數字的和
    public static int sum(int[]arr,int l){

        if(l == arr.length){ //求解最基本的問題
            return 0;
        }
        return arr[l]+sum(arr,l+1);//把原問題轉化為更小的問題
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(sum(nums));
    }
}
