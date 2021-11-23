package dataStructure.stackAndQueue;

public class TestArrayStack {
    public static void main(String[] args) {
        StackByArray stackByArray = new StackByArray();
        stackByArray.create();
        stackByArray.push(1);
        stackByArray.push(3);
        System.out.println(stackByArray.pop());
        System.out.println(stackByArray.top());
        System.out.println(stackByArray.pop());

        System.out.println(stackByArray.isFull());
        System.out.println(stackByArray.isEmpty());


    }
}
