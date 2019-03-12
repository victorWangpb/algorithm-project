package stack_queue;

/**
 * create by wangpb 2019/3/12
 **/
public  class Array_to_Stack {

    public static class ArrayStack{

        private Integer[] arr;
        private Integer index;

        public ArrayStack(int initSize){
            if(initSize<0){
                throw new IllegalArgumentException("the init size is less than zero");
            }
            arr=new Integer[initSize];
            index=0;
        }

        public Integer peek(){
            if(index==0){
                return null;
            }
            return arr[index-1];
        }

        public void push(int obj){
            if(index==arr.length){
                throw new ArrayIndexOutOfBoundsException("the stack is full");
            }
            arr[index++] = obj;
        }

        public Integer pop(){
            if(index==0){
                throw new ArrayIndexOutOfBoundsException("the stack is empty");
            }
            return arr[--index];
        }


        public static void main(String[] args) {
            ArrayStack arrayStack=new ArrayStack(3);
            arrayStack.push(1);
            arrayStack.push(2);
            arrayStack.pop();
            arrayStack.push(3);

        }

    }

}
