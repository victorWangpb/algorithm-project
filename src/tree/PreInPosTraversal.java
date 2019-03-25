package tree;

import java.util.Stack;

/**
 * create by wangpb 2019/3/19
 * 先/中/后序遍历二叉树
 **/
public class PreInPosTraversal {

    public static void main(String[] args) {

        Node head=new Node(5);
        head.left=new Node(3);
        head.right=new Node(8);
        head.left.left=new Node(2);
        head.left.right=new Node(4);
        head.left.left.left=new Node(1);
        head.right.left=new Node(7);
        head.right.left.left=new Node(6);
        head.right.right=new Node(10);
        head.right.right.left=new Node(9);
        head.right.right.right=new Node(11);

        System.out.println("============recursive===============");
        System.out.println("pre-order");
        preOrderRecur(head);
        System.out.println();
        System.out.println("in-order");
        inOrderRecur(head);
        System.out.println();
        System.out.println("pos-order");
        posOrderRecur(head);
        System.out.println();

        System.out.println("==============unrecursive===========");
        System.out.println("pre-order");
        preOrderUnRecur(head);
        System.out.println();
        System.out.println("in-order");
        inOrderUnRecur(head);
        System.out.println();
        System.out.println("pos-order");
        posOrderUnRecur1(head);
        System.out.println();
        posOrderUnRecur2(head);


    }

    static class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value=value;
        }
    }

    /**
     * recursive  root--left--right order
     * @param head node
     */
    private static void preOrderRecur(Node head){
        if(head==null){
            return;
        }

        System.out.print(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);

    }

    /**
     * recursive left--root--right order
     * @param head node
     */
    private static void inOrderRecur(Node head){
        if(head==null){
            return;
        }

        inOrderRecur(head.left);
        System.out.print(head.value+" ");
        inOrderRecur(head.right);
    }

    /**
     * recursive left--right--root order
     * @param head node
     */
    private static void posOrderRecur(Node head){
        if(head==null){
            return;
        }

        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value+" ");
    }

    /**
     * unuse recursive root--left--right
     * @param head node
     */
    private static void preOrderUnRecur(Node head){

        if(head !=null){
            Stack<Node> stack=new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head =stack.pop();
                System.out.print(head.value+" ");
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }
        }

    }

    /**
     * unuse recursive left--root--right
     * @param head node
     */
    private static void inOrderUnRecur(Node head){
        if(head!=null){
            Stack<Node> stack=new Stack<>();
            while (!stack.isEmpty() || head!=null){
                if(head!=null){
                    stack.push(head);
                    head=head.left;
                }else{
                    head=stack.pop();
                    System.out.print(head.value+" ");
                    head=head.right;
                }
            }
        }
    }

    /**
     * unuse recursive left--right--root
     * use two stack
     * @param head node
     */
    private static void posOrderUnRecur1(Node head){
        if(head!=null){
            Stack<Node> stack1=new Stack<>();
            Stack<Node> stack2=new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()){
                head=stack1.pop();
                stack2.push(head);
                if(head.left!=null){
                    stack1.push(head.left);
                }
                if(head.right!=null){
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().value+" ");
            }
        }
    }

    /**
     * unuse recursive left--right--root
     * use one stack
     * @param head node
     */
    private static void posOrderUnRecur2(Node head){
        if(head!=null){
            Stack<Node> stack=new Stack<>();
            stack.push(head);
            Node c;
            while (!stack.isEmpty()){
                c=stack.peek();
                if(c.left!=null && head!=c.left && head!=c.right){
                    stack.push(c.left);
                }else if (c.right!=null && head!=c.right){
                    stack.push(c.right);
                }else{
                    System.out.print(stack.pop().value+ " ");
                    head=c;
                }
            }
        }
    }

}
