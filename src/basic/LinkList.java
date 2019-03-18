package basic;

import java.util.ArrayList;

/**
 * create by wangpb 2019/3/18
 **/
public class LinkList{
    static class Link{
        public int iData;
        public double dData;
        public Link next;

        public Link(int id,double dd){
            iData=id;
            dData=dd;
        }

        public void displayLink(){
            System.out.println("{"+iData+", "+dData+"}");
        }
    }

    static class LinkedList{
        private Link first;

        public LinkedList(){
            first=null;
        }

        public boolean isEmpty(){
            return first==null;
        }

        public void insertFirst(int iData,double dDate){
            Link newLink=new Link(iData,dDate);
            newLink.next=first;
            first=newLink;
        }

        public Link deleteFirst(){
            Link tmp = first;
            first=first.next;
            return tmp ;
        }

        public Link find(int key){
            Link cur=first;
            while (cur.iData !=key){
                if(cur.next ==null){
                    return null;
                }else{
                    cur=cur.next;
                }
            }
            return cur;
        }

        public Link delete(int key){
            Link cur=first;
            Link pre=first;
            while (cur.iData!=key){
                if(cur.next==null){ // next node is null
                    return null;
                }

                pre=cur;
                cur=cur.next;
            }

            if(cur==first){
                first=first.next;
            }else {
                pre.next=cur.next;
            }

            return cur;
        }

        public void displayList(){
            System.out.println("list (first -->last): ");
            Link cur=first;
            while (cur!=null){
                cur.displayLink();
                cur=cur.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList myList=new LinkedList();
        myList.insertFirst(22,2.99);
        myList.insertFirst(44,4.99);
        myList.insertFirst(66,6.99);
        myList.insertFirst(88,8.99);
        myList.displayList();

//        while (!myList.isEmpty()){
//            Link link = myList.deleteFirst();
//            System.out.print("deleted ");
//            link.displayLink();
//        }
//        myList.displayList();

        Link link = myList.find(33);
        if(link!=null) {
            link.displayLink();
        }else{
            System.out.println("no this key");
        }

        Link delete = myList.delete(44);
        if(delete==null){
            System.out.println("can't find this key");
        }else{
            delete.displayLink();
        }
        myList.displayList();

    }
}
