package list_operate;

import java.util.HashMap;

/**
 * create by wangpb 2019/3/18
 **/
public class CopyList {

    public static class Node{
        public int value;
        public Node next;
        public Node rand;
        public Node(int data){
            this.value=data;
        }
    }

    public static Node copyListWithRand1(Node head){

        HashMap<Node,Node> map=new HashMap<>();
        Node cur=head;
        while (cur!=null){
            map.put(cur,new Node(cur.value));
            cur=cur.next;
        }

        cur=head;
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).rand=map.get(cur.rand);
            cur=cur.next;
        }

        return map.get(head);

    }

    public static void printRandList(Node head){
        Node cur=head;
        System.out.println("order: ");
        while (cur!=null){
            System.out.println(cur.value+" ");
            cur=cur.next;
        }

        System.out.println();
        cur=head;
        System.out.println("rand: ");
        while (cur!=null){
            System.out.println(cur.rand==null ? "-" : cur.rand.value + " ");
            cur=cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head.next.next.next.next.next=new Node(6);

        head.rand=head.next.next.next.next.next; //1->6
        head.next.rand=head.next.next.next.next.next; //2->6
        head.next.next.rand=head.next.next.next.next; //3->5
        head.next.next.next.rand=head.next.next; //4->3
        head.next.next.next.next.rand=null; //5->null
        head.next.next.next.next.next.rand=head.next.next.next; //6->4

        printRandList(head);
        Node res1=copyListWithRand1(head);
        printRandList(res1);

    }

}
