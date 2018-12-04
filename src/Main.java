public class Main {
    public static void main(String[] args) {

        Node root = new Node(5);

        root.addR(6);
        root.addR(4);
        root.addR(3);
        root.addR(7);
        root.addR(8);
        root.addR(1);
        root.addR(2);
        root.addR(8);

        //System.out.println(root.hasNodeR(5));
        //System.out.println(root.hasNodeR(6));
        //System.out.println(root.hasNodeR(3));
        //System.out.println(root.hasNodeR(2));

        //root.writeTree();

        NodeBST rootBST = new NodeBST(15);

        rootBST.addI(5);
        rootBST.addI(16);
        rootBST.addI(20);
        rootBST.addI(18);
        rootBST.addI(16);
        rootBST.addI(23);
        rootBST.addI(3);
        rootBST.addI(12);
        rootBST.addI(10);
        rootBST.addI(13);
        rootBST.addI(6);
        rootBST.addI(7);

        rootBST.delete(5);








        rootBST.writeTree();


    }
}
