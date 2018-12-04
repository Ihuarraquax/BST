import java.util.LinkedList;

public class NodeBST extends Node {

    public NodeBST parent;

    public NodeBST(int value) {
        super(value);
    }

    public void addR(int value) {
        addR(new NodeBST(value));
    }

    public void addR(NodeBST node) {
        if (node.value > value) {
            if (right == null) {
                right = node;
                node.parent = this;

            } else {
                right.addR(node);
            }
        } else {
            if (left == null) {
                left = node;
                node.parent = this;

            } else {
                left.addR(node);
            }
        }
    }

    public void addI(int value) {
        LinkedList<NodeBST> q = new LinkedList<>();
        q.add(this);

        while (!q.isEmpty()) {
            NodeBST n = q.remove();
            if (value > n.value) {
                if (n.right == null) {
                    n.right = new NodeBST(value);
                    ((NodeBST) n.right).parent = n;
                } else q.add((NodeBST) n.right);
            } else {
                if (n.left == null) {
                    n.left = new NodeBST(value);
                    ((NodeBST) n.left).parent = n;
                } else q.add((NodeBST) n.left);
            }

        }
    }

    public boolean hasNodeI(int value) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(this);

        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.value == value) return true;
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return false;
    }

    public NodeBST find(int value) {

        LinkedList<NodeBST> q = new LinkedList<>();
        q.add(this);
//todo wyszukiwanie przez dzielenie
        while (!q.isEmpty()) {
            NodeBST n = q.remove();
            if (n.value == value) return n;
            if (n.left != null) {
                q.add((NodeBST) n.left);
            }
            if (n.right != null) {
                q.add((NodeBST) n.right);
            }
        }
        return null;

    }


    public void delete(int value) {
        if (find(value) != null) {

            NodeBST deleted = find(value);



            deleteWithChildOrNone(deleted);



            if (deleted.left != null && deleted.right != null) {
                //todo dodac rzut moneta a lub b

                //a najmniejszy z najwiekszych
                NodeBST swaper = (NodeBST) deleted.right;

                while (swaper.left != null){
                    swaper = (NodeBST) swaper.left;
                }
                deleteWithChildOrNone(swaper);

                //wstawienie w miejsce usunietego

                swaper.parent = deleted.parent;
                swaper.left = deleted.left;
                swaper.right = deleted.right;

                if(deleted.parent.left.value == deleted.value) deleted.parent.left= swaper;
                else deleted.parent.right = swaper;


            }





        }
    }

    private void deleteWithChildOrNone(NodeBST deleted) {

                    //Je?li z nie ma synów, to w jego ojcu
                    // rodzic[z] zast?pujemy wska?nik
                    // do z warto?ci? NULL, zobacz Rys. 1


                    //Je?li w?ze? ma tylko jednego syna,
                    // to usuwamy z przez ustalenie wska?nika
                    // mi?dzy jego ojcem a jedynym
                    //synem, zobacz Rys. 2
        if (deleted.left == null && deleted.right == null) {
            if (deleted.parent.value < deleted.value) {
                deleted.parent.right = null;
            } else deleted.parent.left = null;
        }

                    //Je?li w?ze? ma dwóch synów, to w miejscu
                    // usuwanego w?z?a z wstawiamy:
                    //a. nast?pnik z w zbiorze wierzcho?ków
                    //   (najmniejszy z elementów wi?kszych od z)
                    //   patrz . Rys. 3
                    //b. poprzednik z w zbiorze wierzcho?ków(czyli
                    //   najwi?kszy spo?ród wszystkich elementów
                    //   mniejszych od z)
        if (deleted.left != null && deleted.right == null) {
            if (deleted.parent.value < deleted.value) {
                deleted.parent.right = deleted.left;
                ((NodeBST) deleted.left).parent = deleted.parent;

            } else {
                deleted.parent.left = deleted.left;
                ((NodeBST) deleted.left).parent = deleted.parent;
            }
        }
        if (deleted.left == null && deleted.right != null) {
            if (deleted.parent.value < deleted.value) {
                deleted.parent.right = deleted.right;
                ((NodeBST) deleted.right).parent = deleted.parent;
            } else {
                deleted.parent.left = deleted.right;
                ((NodeBST) deleted.right).parent = deleted.parent;
            }
        }
    }


}
