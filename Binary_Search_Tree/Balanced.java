import java.util.*;

public class Balanced {
    static class Node{
        int data; Node right,left;
        Node(int data){
            this.data=data;
        }
    }
    public static void preorder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void getinorder(Node root,ArrayList<Integer> inorder){
        if(root==null) return;
        getinorder(root.left,inorder);
        inorder.add(root.data);
        getinorder(root.right,inorder);
    }
    public static Node createBST(ArrayList<Integer> inorder,int si,int ei){
        if(si>ei) return null;
        int mid=si+(ei-si)/2;
        Node root=new Node(inorder.get(mid));
        root.left=createBST(inorder,si,mid-1);
        root.right=createBST(inorder,mid+1,ei);
        return root;
    }
    public static Node balancedBST(Node root){
        ArrayList<Integer> inorder=new ArrayList<>();
        getinorder(root,inorder);
        return createBST(inorder,0,inorder.size()-1);
    }
    public static void main(String args[]){
        Node root=new Node(8);
        root.left=new Node(6);
        root.left.left=new Node(5);
        root.left.left.left=new Node(3);
        root.left.left.left.left=new Node(1);
        root.right=new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);

        root=balancedBST(root);
        preorder(root);
    }
}
