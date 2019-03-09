package quicksort;

/**
 * create by wangpb 2019/3/5
 **/
public class QuickSort1 {

    public static void main(String[] args) {

        int[] arr={4,7,2,6,8,5,1,3,6,9,6,1,2,1};
//        int[] arr={3,5 ,2, 6 ,1};
        long l = System.nanoTime();
        quicksort(arr,0,arr.length-1);
        System.out.println(System.nanoTime()-l);
        for (int anArr : arr) {
            System.out.print(anArr);
        }
        System.out.println();

    }

    private static void quicksort(int[] arr,int begin,int end){

          if(begin<end){
              // 随机快排，对经典快排的一个选择优化
//              swap(arr,begin+(int)(Math.random()*(end-begin+1)),end);
              int[] partition = partition(arr, begin, end);
//              System.out.println("left:"+partition[0]+", right:"+partition[1]);
              quicksort(arr,begin,partition[0]-1);
              quicksort(arr,partition[1]+1,end);

          }
    }

    private static int[] partition(int[] arr,int left,int right){

        int less=left-1;
        int more=right;
        while(left<more){

            if(arr[left]<arr[right]){
                swap(arr,++less,left++);
            }else if(arr[left]>arr[right]){
                swap(arr,--more,left);
            }else{
                left++;
            }


        }
        swap(arr,more,right);
        return new int[]{less+1,more};

    }

    private static void swap(int[] arr,int i,int j){
        if(i!=j){
            int tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
        }
    }

}
