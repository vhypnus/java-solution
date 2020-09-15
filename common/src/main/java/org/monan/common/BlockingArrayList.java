package org.monan.common;

/**
 * 适用于单线程生产单线程消费无锁
 */
public class BlockingArrayList {

    private Object []objs ;

    private int size ;

    private int head ;

    private int tail ;

    public BlockingArrayList(int size) {
        this.size = size;
        this.objs = new Object[size] ;
        this.head = 0 ;
        this.tail = 0 ;
    }

    public void add(Object o) {
        // reject
        if (tail > head){
            if (tail - head +1 >= size ){
                throw new OverflowException("overflow") ;
            }
        } else {
            if (head-tail == 1){
                throw new OverflowException("overflow") ;
            }
        }

        // add
        objs[tail] = o ;
        if (tail + 1 == size) {
            tail = 0 ;
        } else {
            tail++ ;
        }
    }

    public Object poll(){
        if (head == tail ){
            return null ;
        }

        // poll
        Object o =  objs[head] ;
        // help GC
        objs[head] = null ;
        if (head+1 == size){
            head = 0 ;
        } else {
            head++ ;
        }
        return o ;
    }
}
