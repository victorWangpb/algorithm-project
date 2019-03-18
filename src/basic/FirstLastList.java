package basic;

/**
 * create by wangpb 2019/3/18
 **/
public class FirstLastList {

    static class Link{
        public long dData;
        public Link next;

        public Link(long d){
            dData=d;
        }

        public void displayLink(){
            System.out.println(dData+" ");
        }
    }

    static class FirstLastLinkedList{

        private Link first;
        private Link last;

        public FirstLastLinkedList(){
            first=null;
            last=null;
        }

        public boolean isEmpty(){
            return first==null;
        }

        public void insertFirst(long dd){

            Link newLink=new Link(dd);
            if(isEmpty()){
                last=newLink;
            }
            newLink.next=first;
            first=newLink;
        }

        public void insertLast(long dd){
            Link newLink =new Link(dd);
            if(isEmpty()){
                first=newLink;
            }else{
                last.next=newLink;
            }
            last=newLink;
        }

        public long deleteFirst(){
            long tmp=first.dData;
            if(first.next==null){
                last=null;
            }
            first=first.next;
            return tmp;
        }

        public void displayList(){
            System.out.println("list (first --> last): ");
            Link cur=first;
            while (cur!=null){
                cur.displayLink();
                cur=cur.next;
            }

            System.out.println();
        }


    }

    public static void main(String[] args) {
        FirstLastLinkedList firstLastLinkedList=new FirstLastLinkedList();
        firstLastLinkedList.insertFirst(22);
        firstLastLinkedList.insertFirst(44);
        firstLastLinkedList.insertFirst(66);
        firstLastLinkedList.insertLast(11);
        firstLastLinkedList.insertLast(33);
        firstLastLinkedList.insertLast(55);
        firstLastLinkedList.displayList();

        firstLastLinkedList.deleteFirst();
        firstLastLinkedList.displayList();
    }

}
