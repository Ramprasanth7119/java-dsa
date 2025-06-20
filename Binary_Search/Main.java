

public class Main {

    public static void main(String args[]){

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(10);
        tree.insert(8);
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);

        System.out.print("Inorder Travesal : ");
        tree.printTreeInorder();  // 1 5 8 10

        System.out.println();

        System.out.print("Preorder Travesal : ");
        tree.printTreePreorder(); // 

        System.out.println();

        System.out.print("Postorder Travesal : ");
        tree.printTreePostorder(); //

    }

}
