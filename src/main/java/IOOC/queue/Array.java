package IOOC.queue;

public class Array<E> {

    private E[]data;
    private int size;

    /**
     * 建構子，傳入數組容量capacity構造Array
     * @param capacity
     */

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
   // 無參數的建構子，默認初始容量capacity =
    public Array(){
        this(10);
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size == 0 ;
    }
    public void  addLast(E e){
//        if(size == data.length){
//            throw new IllegalArgumentException("AddList failed. Array is full");
//        }
//        data[size] = e;
//        size++;
        add(e,size);
    }

    public void addFirst(E e){
        add(e,0);
    }

    public void add(E e,int index){

        if(index<0 ||index>size){
            throw new IllegalArgumentException("AddList failed. Require index<0 ||index>size");
        }

        if(size == data.length){
//            throw new IllegalArgumentException("AddList failed. Array is full");
            resize(2*data.length);
        }

        for(int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;


    }
    public E get(int index){

        if(index<0 || index>=size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }



    public void set(int index,E e){

        if(index<0 || index>=size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;

    }

    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("delete fail index < 0 || index >= size");
        }
        E ret = data[index];

        for(int i=index+1;i<size;i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null; // loitering objects != memory leak 這句不寫可以，data[size] 本來就不會用到

        if(size == data.length/4 && data.length /2 != 0){
            resize(data.length/2);
        }



        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
      return  remove(size-1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index !=-1){
            remove(index);
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

         res.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
         res.append(('['));
         for(int i =0;i<size;i++){
             res.append(data[i]);
             if(i!=size-1){
                 res.append(", ");
             }
         }
         res.append(']');
         return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData=  (E[])new Object[newCapacity];
        for(int i=0;i<size;i++){
           newData[i] = data[i];
        }
        data = newData;
    }
}
