package IOOC.linearSearch;

import IOOC.util.ArrayGenerator;

public class LinearSearch {
    public static<E> int search(E[] data,E target){
        for(int i=0;i< data.length;i++){
            if(data[i] .equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        Integer[]data = {24,18,12,9,16,66,32,4};

        Integer[]data = ArrayGenerator.generateOrderedArray(100000);

        int res = LinearSearch.<Integer>search(data,100000);

        System.out.println(res);

//        int res2 = LinearSearch.search(data,77);
//        System.out.println(res);
//        System.out.println(res2);

//        Student[]students = {new Student("Austin"),new Student("Bob"),
//                new Student("Chris")};
//
//        int res3 = LinearSearch.search(students,new Student("Austin"));
//        System.out.println(res3);

    }
}
