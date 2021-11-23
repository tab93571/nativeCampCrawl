package IOOC.queue;

import java.util.Random;

public class Main {

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
        int opCount =10000;
//        Queue<Integer> arrayQueue = new ArrayQueue<>();
//        double time1 = testQueue(arrayQueue, opCount);
//        System.out.println("ArrayQueue, time: " + time1 + " s");

        QueueIOOC<Integer> loopQueueIOOC = new LoopQueueIOOC<>();
        double time2 = testQueue(loopQueueIOOC, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
    }
}
