public class BinaryTree {

    Node root;

    public void preorderTraversal(Node node){
        if(node == null) return;
        System.out.print(node.value+" ");
        preorderTraversal(node.linkerkind);
        preorderTraversal(node.regterkind);
    }
    
}
