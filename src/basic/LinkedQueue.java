package basic;

/**
 * create by wangpb 2019/3/19
 **/
public class LinkedQueue {

    static class Link{
        public long dData;
        public Link next;
        public Link(long dData){
            this.dData=dData;
        }

        public void displayLink(){
            System.out.println(dData+" ");
        }
    }

    static class FisrtLastQueueList{
        private Link first;
        private Link last;
        public FisrtLastQueueList(){
            first=null;
            last=null;
        }
        public boolean isEmpty(){
            return first==null;

        }

        public void insertLast(long dData){
            Link link=new Link(dData);
            if(isEmpty()){
                first=link;
            }else {
                last.next=link;
            }
            last=link;

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
            Link cur=first;
            while (cur!=null){
                cur.displayLink();
                cur=cur.next;
            }
        }
    }

    static class LinkQueue{

        private FisrtLastQueueList firstLastList;
        public LinkQueue(){
            firstLastList=new FisrtLastQueueList();
        }

        public boolean isEmpty(){
            return firstLastList.isEmpty();
        }

        public void insert(long j){
            firstLastList.insertLast(j);
        }

        public long remove(){
            return firstLastList.deleteFirst();
        }

        public void displayQueue(){
            System.out.println("queue (front --> rear): ");
            firstLastList.displayList();
        }

    }

    public static void main(String[] args) {
        LinkQueue queue=new LinkQueue();
        queue.insert(20);
        queue.insert(40);
        queue.displayQueue();

        queue.insert(60);
        queue.insert(80);
        queue.displayQueue();

        queue.remove();
        queue.remove();
        queue.displayQueue();
    }

}
