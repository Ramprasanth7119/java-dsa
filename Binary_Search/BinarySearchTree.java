
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}


public class BinarySearchTree {

    Node root;

    public void insert(int el){

        root = insertRec(root, el);

    }

    public Node insertRec(Node root, int el){

        if(root == null){
            root = new Node(el);
        } else if(root.data < el){
            root.right = insertRec(root.right, el);
        } else if(root.data > el){
            root.left = insertRec(root.left, el);
        }
        return root;
    }

    // Inorder Travesal
    public void printTreeInorder(){

        printTreeInorderRec(root);

    }

    public void printTreeInorderRec(Node root){

        if(root != null){

            printTreeInorderRec(root.left);
            System.out.print(root.data+" ");
            printTreeInorderRec(root.right);

        }

    }

    //Pre-Order Travesal
    public void printTreePreorder(){

        printTreePreorderRec(root);

    }

    public void printTreePreorderRec(Node root){

        if(root != null){

            System.out.print(root.data+" ");
            printTreePreorderRec(root.left);
            printTreePreorderRec(root.right);

        }

    }

    // Post-Order Travesal
    public void printTreePostorder(){

        printTreePostorderRec(root);

    }

    public void printTreePostorderRec(Node root){

        if(root != null){

            printTreePostorderRec(root.left);
            printTreePostorderRec(root.right);
            System.out.print(root.data+" ");
        }

    }

}
