package basic;

/**
 * create by wangpb 2019/3/19
 **/
public class LinkStack {

    static class Link{
        private long dData;
        private Link next;

        public Link(long dData){
            this.dData=dData;
        }

        public void displayLink(){
            System.out.println(dData+ " ");
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

        public void insertFirst(long dData){
            Link link=new Link(dData);
            link.next=first;
            first=link;
        }

        public long deleteFirst(){
            Link tmp=first;
            first=first.next;
            return tmp.dData;
        }

        public void displayList(){
            Link cur=first;
            while (cur!=null){
                cur.displayLink();
                cur=cur.next;
            }
        }
    }

    static class LinkedStack{
        private LinkedList linkedList;
        public LinkedStack(){
            linkedList=new LinkedList();
        }

        public void push(long j){
            linkedList.insertFirst(j);
        }
        public long pop(){
            return linkedList.deleteFirst();
        }

        public boolean isEmpty(){
            return linkedList.isEmpty();
        }

        public void displayStack(){
            System.out.println("stack (top --> bottom): ");
            linkedList.displayList();
        }
    }

    public static void main(String[] args) {
        LinkedStack linkedStack=new LinkedStack();
        linkedStack.push(22);
        linkedStack.push(44);
        linkedStack.displayStack();

        linkedStack.push(66);
        linkedStack.push(88);
        linkedStack.displayStack();

        linkedStack.pop();
        linkedStack.pop();
        linkedStack.displayStack();
    }

}
