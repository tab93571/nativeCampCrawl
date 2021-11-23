package IOOC.algorithmArray;

import IOOC.linearSearch.Student;

public class Main {
    public static void main(String[] args) {


        Array<Integer> arr = new Array();
        for(int i =0;i<10;i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(100,1);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);


        Array<Student> arrStudent = new Array<>();
        arrStudent.addLast(new Student("Alice",100));
        arrStudent.addLast(new Student("Bob",76));
        arrStudent.addLast(new Student("Charlie",65));
        System.out.println(arrStudent);

    }
}
