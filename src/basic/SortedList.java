package basic;

/**
 * create by wangpb 2019/3/19
 **/
public class SortedList {

    static class Link{

        private long dData;
        private Link next;

        public Link(long dData){
            this.dData=dData;
        }

        public void displayLink (){
            System.out.println(dData+ " ");
        }

    }

    static class SortList{

        private Link first;

        public SortList(){
            first=null;
        }

        public boolean isEmpty(){
            return first==null;
        }

        public void insert(long dData ){

            Link link=new Link(dData);
            Link pre=null;
            Link cur=first;
            while (cur!=null && dData>cur.dData){
                pre=cur;
                cur=cur.next;
            }
            if(pre==null){
                first=link;
            }else{
                pre.next=link;
            }
            link.next=cur;

        }

        public Link remove(){
            Link tmp=first;
            first=first.next;
            return tmp;
        }

        public void displayList(){
            System.out.println("list (first --> last): ");
            Link link=first;
            while (link!=null){
                link.displayLink();
                link=link.next;
            }
        }

    }

    public static void main(String[] args) {
        SortList sortList=new SortList();

        sortList.insert(20);
        sortList.insert(40);
        sortList.displayList();

        sortList.insert(10);
        sortList.insert(30);
        sortList.insert(50);
        sortList.displayList();

        sortList.remove();
        sortList.displayList();
    }

}
