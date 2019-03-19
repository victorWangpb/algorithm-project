package basic;

/**
 * create by wangpb 2019/3/19
 **/
public class DoubleLinkedList {

    static class Link{
        public long dData;
        public Link next;
        public Link pre;

        public Link(long dData){
            this.dData=dData;
        }

        public void displayLink(){
            System.out.print(dData+" ");
        }
    }

    static class DoubleLinkList{
        private Link first;
        private Link last;

        public DoubleLinkList(){
            first=null;
            last=null;
        }

        public boolean isEmpty(){
            return first==null;
        }

        public void insertFirst(long dData){
            Link link=new Link(dData);

            if(isEmpty()){
                last=link;
            }else{
                first.pre=link;
            }
            link.next=first;
            first=link;
        }

        public void insertLast(long dData){
            Link link=new Link(dData);
            if(isEmpty()){
                first=link;
            }else{
                last.next=link;  //old last --> new link
                link.pre=last;  // new link pre --> old last
            }
            last=link;
        }

        public Link deleteFirst(){
            Link tmp=first;
            if(first.next==null){
                last=null;
            }else{
                first.next.pre=null;

            }
            first=first.next;
            return tmp;

        }

        public Link deleteLast(){
            Link tmp=last;
            if(first.next==null){
                first=null;
            }else{
                last.pre.next=null;
            }
            last=last.pre;
            return tmp;

        }

        public boolean insertAfter(long key,long dData){
            Link cur=first;
            while (cur.dData!=key){
                cur=cur.next;
                if(cur==null){
                    return false;
                }
            }

            Link link=new Link(dData);
            if(cur==last){
                link.next=null;
                last=link;
            }else{
                link.next=cur.next;
                cur.next.pre=link;
            }

            link.pre=cur;
            cur.next=link;
            return true;
        }

        public Link deleteKey(long key){
            Link cur=first;
            while (cur.dData!=key){
                cur=cur.next;
                if(cur==null){
                    return null;
                }
            }

            if(cur==first){
                first=cur.next;
            }else{
                cur.next.pre=cur.pre;
            }
            return cur;
        }

        public void displayForward(){
            System.out.println("list (first --> last ): ");
            Link cur=first;
            while (cur!=null){
                cur.displayLink();
                cur=cur.next;
            }
            System.out.println();
        }

        public void displayBackward(){
            System.out.println("list (last --> first ): ");
            Link cur=last;
            while (cur!=null){
                cur.displayLink();
                cur=cur.pre;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoubleLinkList doubleLinkList=new DoubleLinkList();

        doubleLinkList.insertFirst(22);
        doubleLinkList.insertFirst(44);
        doubleLinkList.insertFirst(66);
        doubleLinkList.displayForward();
        doubleLinkList.displayBackward();

        doubleLinkList.insertLast(11);
        doubleLinkList.insertLast(33);
        doubleLinkList.insertLast(55);
        doubleLinkList.displayForward();
        doubleLinkList.displayBackward();

        doubleLinkList.insertAfter(22,77);
        doubleLinkList.insertAfter(33,88);
        doubleLinkList.displayForward();

    }

}
