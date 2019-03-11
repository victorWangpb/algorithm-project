package bucketsort;

/**
 * create by wangpb 2019/3/9
 **/
public class MaxGap {

    public static void main(String[] args) {
        int[] arr ={1,3,7,9,10};
        System.out.println(maxGap(arr));
    }

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[length + 1];
        int[] maxs = new int[length + 1];
        int[] mins = new int[length + 1];
        int bid = 0;
        for (int i = 0; i < length; i++) {
            bid = bucket(nums[i], length, min, max);
            mins[bid]=hasNum[bid]?Math.min(mins[bid],nums[i]):nums[i];
            maxs[bid]=hasNum[bid]?Math.max(maxs[bid],nums[i]):nums[i];
            hasNum[bid]=true;
        }
        int res=0;
        int lastmax=maxs[0];
        int i=1;
        for(;i<=length;i++){
            if(hasNum[i]){
                res=Math.max(res,mins[i]-lastmax);
                lastmax=maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

}
