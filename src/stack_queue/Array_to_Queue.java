package stack_queue;

/**
 * create by wangpb 2019/3/12
 **/
public class Array_to_Queue {

    public static class ArrayQueue {

        private Integer arr[];
        private Integer index;
        private Integer start;
        private Integer end;

        public ArrayQueue(int initSize) {

            if (initSize < 0) {
                throw new IllegalArgumentException("the init size is less than zero");
            }

            arr = new Integer[initSize];
            index = 0;
            start = 0;
            end = 0;

        }

        public Integer peek() {
            if (index == 0) {
                return null;
            }
            return arr[start];
        }

        public void push(int obj) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("the queue is full");
            }
            index++;
            arr[end] = obj;
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        public Integer poll() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            }
            index--;
            int tmp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[tmp];
        }

    }

}
