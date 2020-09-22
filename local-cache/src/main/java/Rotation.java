public class Rotation {

    public Node rotation(Node head,int k ){
        Node newHead = null ;
        Node newTail = null ;

        Node tmpHead = null ;
        Node tmpTail = null ;

        Node next = null ;
        int index = 0 ;
        while(head != null) {


            next = head.next ;
            head.next = null ;
            // add to head
            tmpHead = addHead(tmpHead,head) ;
            if (tmpTail == null){
                tmpTail = tmpHead ;
            }
            head = next ;
            index++ ;

            if (index == k){
                if (newHead ==null && newTail == null){
                    newHead = tmpHead ;
                } else{
                    newTail.next = tmpHead ;
                }
                newTail = tmpTail ;
                tmpHead = null ;
                tmpTail = null ;
                index = 0 ;
            }
        }

        if(tmpHead != null ){
            newTail.next = tmpHead ;
        }


        return newHead ;
    }

    public Node rotation(Node head) {
        Node next= null ;
        Node newHead = null ;
        while(head != null){
            next = head.next ;
            //从链表拆分
            head.next = null ;
            newHead = addHead(newHead,head) ;
            head = next ;
        }
        return newHead ;
    }

    public Node addHead(Node head,Node node){
        if (node == null){
            return head ;
        }

        if (head != null) {
            node.next = head ;
        } else{
            node.next = null ;
        }
        return node ;
    }

    public void print(Node head){
        Node tmp = head ;
        while(tmp != null){
            System.out.print(tmp.val+"->") ;
            tmp = tmp.next ;
        }

        System.out.println() ;
    }




    static class Node{

        public Integer val ;

        public Node next ;

        public Node(Integer val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1) ;
        Node node2 = new Node(2) ;
        Node node3 = new Node(3) ;
        Node node4 = new Node(4) ;
        Node node5 = new Node(5) ;
        node1.next = node2 ;
        node2.next = node3 ;
        node3.next = node4 ;
        node4.next = node5 ;

        Rotation r = new Rotation() ;
        r.print(node1);
        Node head = r.rotation(node1,3) ;
        r.print(head);
    }
}
