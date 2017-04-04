package binary.tree;

import util.Node;

public class HeightBinaryTree {

    public <T extends Comparable<T>> boolean isBalanced(Node<T> root) {
        if (root == null) return true;
        int lh = getMaxHeightRecursive(root.getLeftNode());
        int rh = getMaxHeightRecursive(root.getRightNode());
        return isBalanced(root.getLeftNode())
                && isBalanced(root.getRightNode())
                && Math.abs(lh - rh) <= 1;
    }

    public <T extends Comparable<T>> int getMinHeightRecursive(Node<T> node) {
        if (node == null) {
            return 0;
        }

        if (isLeafNode(node)) {
            return 1;
        }

        int left = getMinHeightRecursive(node.getLeftNode());
        int right = getMinHeightRecursive(node.getRightNode());

        return 1 + Math.min(left, right);
    }

    public <T extends Comparable<T>> int getMaxHeightRecursive(Node<T> node) {
        if (node == null) {
            return 0;
        }

        if (isLeafNode(node)) {
            return 1;
        }

        int left = getMaxHeightRecursive(node.getLeftNode());
        ;
        int right = getMaxHeightRecursive(node.getRightNode());

        return 1 + Math.max(left, right);
    }

    private <T extends Comparable<T>> boolean isLeafNode(Node<T> node) {
        return node.getRightNode() == null || node.getLeftNode() == null;
    }
}
