/**
 * create by wangpb 2019/3/4
 **/
public class SecondMinNum {

    public static void main(String[] args) {

        int[] arr={23,54,21,89,57,20,73,59};

        System.out.println(get(arr));

    }


    public static int get(int[] arr){

        int max=arr[0];
        int sec=arr[1];
        if(sec>max){
            max=arr[1];
            sec=arr[0];
        }

        for(int i=2;i<arr.length;i++){
            if(arr[i]>max){
                sec=max;
                max=arr[i];
            }else if(arr[i]>sec){
                sec=arr[i];
            }
        }


        return sec;
    }

}
