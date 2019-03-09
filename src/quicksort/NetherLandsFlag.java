package quicksort;

/**
 * create by wangpb 2019/3/5
 **/
public class NetherLandsFlag {

    public static void main(String[] args) {

        int[] arr={4,7,2,6,8,5,1,3,6,9,6};
        flag(arr,0,arr.length-1,6);
        for (int anArr : arr) {
            System.out.println(anArr);
        }

    }

    private static void flag(int[] arr,int left,int right,int num){

        int less=left-1;
        int more=right+1;
        int current=left;

        while (current<more){

            if(arr[current]<num){
                swap(arr,++less,current++);
            }else if(arr[current]>num){
                swap(arr,--more,current);
            }else{
                current++;
            }

        }

    }

    private static void swap(int[] arr,int i,int j){

        if(i!=j){
            int tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
        }

    }

}
