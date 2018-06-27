import java.util.Arrays;


public class SuperBalancedBinaryTree {

    public static void main(String[] args) {
        new SuperBalancedBinaryTree().solve();
    }

    public void solve() {

        Node n9 = new Node(null, null);
        Node n10 = new Node(null, null);

        Node n7 = new Node(null, null);
        Node n8 = new Node(n9, n10);

        Node n3 = new Node(null, null);
        Node n4 = new Node(null, null);
        Node n5 = new Node(null, null);
        Node n6 = new Node(n7, n8);

        Node n1 = new Node(n3, n4);
        Node n2 = new Node(n5, n6);

        Node root = new Node(n1, n2);
        System.out.println("isSuperbalanced()=" + isSuperbalanced(root));
        System.out.println("isSuperbalanced()=" + isSuperbalanced(n8));
    }

    private boolean isSuperbalanced(Node root) {
        if (root == null) { return true; }
        int[] depths = new int[2];
        Arrays.fill(depths, -1);
        boolean isSuperbalanced = isSuperbalanced(root, 0, depths);
        System.out.println("depths=" + Arrays.toString(depths));
        return isSuperbalanced;
    }

    private boolean isSuperbalanced(Node root, int depth, int[] depths) {
        if (root == null) { return true; }
        if (root.left == null && root.right == null) {
            boolean isBalancedDepth = false;
            int emptySlot = -1;
            for (int i = 0; i < depths.length; i++) {
                if (depths[i] == depth) { isBalancedDepth = true; }
                if (depths[i] == -1) { emptySlot = i; }
            }
            if (!isBalancedDepth) {
                if (emptySlot == -1) {
                    return false;
                } else {
                    depths[emptySlot] = depth;
                    for (int i : depths) {
                        if (i != -1 && depth - i > 1) { return false; }
                    }
                }
            }
        }
        return isSuperbalanced(root.left, depth + 1, depths) && isSuperbalanced(root.right, depth + 1, depths);
    }

    private class Node<K, V> {
        Node left;
        Node right;
        K key;
        V value;
        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

}