import java.util.*;

public class LruCache {

    private Map<Long,Node> map = new HashMap<>();

    private Node head ;

    private Node tail ;



    public void add(Long orderNo){
        if (orderNo == null) {
            return ;
        }

        deleteNode(orderNo) ;
        addTail(new Node(orderNo,System.currentTimeMillis()));
    }

    private boolean deleteNode(Long orderNo) {
        if (map.get(orderNo) == null) {
            return false ;
        }

        if (head.equals(tail)){
            head = null ;
            tail = null ;
        } else{
            Node tmp = map.get(orderNo) ;
            if (tmp.equals(head)){
                head = head.next ;
                head.prev = null ;
            } else if (tmp.equals(tail)){
                tail = tail.prev ;
                tail.next = null ;
            } else {
                tmp.prev.next = tmp.next ;
                tmp.next.prev = tmp.prev ;
                tmp.next = null ;
                tmp.prev = null ;
            }
        }

        map.remove(orderNo) ;
        return true ;

    }

    private void addTail(Node node) {
        if(head == null ){
            head = node ;
            tail = head ;
        } else{
            tail.next = node ;
            tail = node ;
        }
        map.put(node.orderNo,node) ;
    }


    public void print(){
        Node tmp = head ;
        while(tmp != null){
            System.out.print("("+tmp.orderNo+","+tmp.visitTime+")"+"->") ;
            tmp = tmp.next ;
        }

        System.out.println() ;
    }

    static class Node{

        public Long orderNo ;

        public Long visitTime ;

        public Node prev ;

        public Node next ;


        public Node(Long orderNo,Long visitTime) {
            this.orderNo = orderNo ;
            this.visitTime = visitTime ;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(orderNo, node.orderNo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(orderNo);
        }
    }


    public static void main(String[] args) {
        LruCache cache = new LruCache() ;

        cache.add(1l);
        cache.add(2l);
        cache.add(3l);

        cache.print();
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cache.add(1l);

        cache.print();
    }
}
