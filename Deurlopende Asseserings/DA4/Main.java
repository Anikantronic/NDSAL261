public class Main {

    public static void main(String[] args) {
        
        BinaryTree boom = new BinaryTree();

        Node vyftig = new Node(50);
        boom.root = vyftig;
        Node dertig = new Node(30);
        boom.root.linkerkind = dertig;
        Node twintig = new Node(20);
        boom.root.linkerkind.linkerkind = twintig;
        Node veertig = new Node(40);
        boom.root.linkerkind.regterkind = veertig;
        Node seventig = new Node(70);
        boom.root.regterkind = seventig;
        Node negentig = new Node(90);
        boom.root.regterkind.regterkind = negentig;

        System.out.println("Voor-orde traversering:");
        boom.preorderTraversal(vyftig);
        System.out.println();

        Node tagtig = new Node(80);
        boom.root.regterkind.linkerkind = tagtig;

        System.out.println("Nuwe node bygevoeg:");
        boom.preorderTraversal(vyftig);
    }
    
}
