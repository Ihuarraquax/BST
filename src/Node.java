import java.util.LinkedList;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public boolean hasNodeR(int value) {
        if (this.value == value) return true;
        if (left == null && right == null) return false;
        if (left == null && right != null) return right.hasNodeR(value);
        if (left != null && right == null) return left.hasNodeR(value);
        return left.hasNodeR(value) | right.hasNodeR(value);
    }

    public void addR(int value) {
        addR(new Node(value));
    }

    public void addR(Node node) {
        if (node.value > value) {
            if (right == null) {
                right = node;

            } else {
                right.addR(node);
            }
        } else {
            if (left == null) {
                left = node;

            } else {
                left.addR(node);
            }
        }
    }


    public void writeTree() {
        LinkedList<Node> q = new LinkedList<>();
        q.add(this);

        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.println(n.value + ":L-" + n.left + " R-" + n.right);

            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);

        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    protected boolean hasChild() {
        return left!=null||right!=null;
    }
}
