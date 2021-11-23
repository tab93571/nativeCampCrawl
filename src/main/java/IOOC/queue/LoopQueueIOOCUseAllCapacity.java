package IOOC.queue;

public class LoopQueueIOOCUseAllCapacity<E> implements QueueIOOC<E> {

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueueIOOCUseAllCapacity(int capacity){
        data = (E[])new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueIOOCUseAllCapacity(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }



    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {

//        if((tail == front) && size >0){
        if(size == getCapacity()){
            resize(getCapacity()*2);
        }

        data[tail] = e;
        tail = (tail + 1 ) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Can not deque from an empty queue");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size -- ;

        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2 );
        }

        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Can not deque from an empty queue");
        }

        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];

        for(int i = 0 ; i <size ; i ++){
            newData[i] = data[(front+i)%data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        //與resize 的遍歷方式比較 toString 的方式為到tail的前一個，也就是最後一個
        //resize的方式則是用size表示最後一個

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");


        //這個在front == tail時會出錯
//        for(int i = front ; i != tail ; i = (i+1) % data.length){
//            res.append(data[i]);
//            if((i+1) % data.length != tail){
//                res.append(", ");
//            }
//        }


        // 注意，我们的循环遍历打印队列的逻辑也有相应的更改 :-)
//        for(int i = 0; i < size; i ++){
//            res.append(data[(front + i) % data.length]);
//            if((i + front + 1) % data.length != tail)
//                res.append(", ");
//        }

        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {

        QueueIOOC<Integer> queueIOOC = new LoopQueueIOOCUseAllCapacity<>();

        for(int i = 0 ; i < 10 ; i ++){
            queueIOOC.enqueue(i);
            System.out.println(queueIOOC);

//            if(i % 3 == 2){
//                queue.dequeue();
//                System.out.println(queue);
//            }
        }
        System.out.println(queueIOOC);

    }


}
