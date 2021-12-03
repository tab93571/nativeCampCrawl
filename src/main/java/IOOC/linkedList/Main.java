package IOOC.linkedList;

import IOOC.queue.ArrayQueueIOOC;
import IOOC.queue.LoopQueueIOOC;
import IOOC.queue.QueueIOOC;
import IOOC.stack.ArrayStack;
import IOOC.stack.Stack;

import java.util.Random;

public class Main {

    //測試使用q 運行 opCount 個enqueue和dequeue操作所需要的時間,單位: 秒
    private static double testStack(Stack<Integer> q , int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i++){
            q.push(random.nextInt(Integer.MAX_VALUE));
        }

        for(int i = 0 ; i < opCount ; i++){
            q.pop();
        }


        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000000.0;

    }


    //測試使用q 運行 opCount 個enqueue和dequeue操作所需要的時間,單位: 秒
    private static double testQueue(QueueIOOC<Integer> q , int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for(int i = 0 ; i < opCount ; i++){
            q.dequeue();
        }


        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000000.0;

    }

    public static void main(String[] args) {
//        int opCount =10000000;
//        Stack<Integer> linkedListStack = new LinkedListStack<>();
//        double time1 = testStack(linkedListStack, opCount);
//        System.out.println("linkedListStack, time: " + time1 + " s");
//
//        Stack<Integer> arrayStack = new ArrayStack<>();
//        double time2 = testStack(arrayStack, opCount);
//        System.out.println("arrayStack, time: " + time2 + " s");


        int opCount =100000;
        QueueIOOC<Integer> loopQueueIOOC = new LoopQueueIOOC<>();
        double time1 = testQueue(loopQueueIOOC, opCount);
        System.out.println("loopQueueIOOC, time: " + time1 + " s");

        QueueIOOC<Integer> linkedListQueue = new LinkedListQueue<>();
        double time2 = testQueue(linkedListQueue, opCount);
        System.out.println("linkedListQueue, time: " + time2 + " s");

        QueueIOOC<Integer> arrayListQueue = new ArrayQueueIOOC<>();
        double time3 = testQueue(arrayListQueue, opCount);
        System.out.println("arrayListQueue, time: " + time3 + " s");
    }
}
