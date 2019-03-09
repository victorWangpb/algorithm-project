import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * create by wangpb 2019/3/9
 **/
public class FirstNoRepeatNum {

    public static void main(String[] args) {

        int[] arr={23,54,21,89,57,20,73,59,23,57,20,73,59,23,57,20,73,59};
        System.out.println(get_first_2(arr));

    }

    public static int get(int[] arr){

        SortedMap<Integer,Integer> map=new TreeMap<>();


        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }

        int num=0;
        for(Integer key:map.keySet()){
            if(map.get(key)==1){
                num=key;
                break;
            }
        }

//         AtomicInteger num = new AtomicInteger();
//
//        map.forEach((k,v)->{
//            if(v==1){
//                num.set(k);
//                return ;
//            }
//        });

        return num;
    }

    public static int get_first(int[] arr){

        int num=0;

        List<Integer> list=new ArrayList<>();
        List<Integer> resultList=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(list.contains(arr[i])){
                resultList.add(arr[i]);
            }
            list.add(arr[i]);
        }

        for(int i=0;i<arr.length;i++){
            if(!resultList.contains(arr[i])){
                num=arr[i];
                break;
            }
        }

        return num;
    }

    public static int get_first_2(int[] arr){

        int num=0;

        List<Integer> list=new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        for(int i=0;i<arr.length;i++){
            if(list.contains(arr[i])){
                int i1 = list.indexOf(arr[i]);
                list.remove(i1);
                list.add(arr[i]);
            }else {
                list.add(0,arr[i]);
            }
        }

        if(list.indexOf(Integer.MIN_VALUE)>0){
            num=list.get(list.indexOf(Integer.MIN_VALUE)-1);
        }

        return num;
    }

}
