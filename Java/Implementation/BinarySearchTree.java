import com.sun.source.tree.Tree;

public class BinarySearchTree {

    TreeNode root;
    int length;

    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.inOrderTraversal();
        System.out.println();
        bst.isPresent(3);
        bst.isValidBst();
    }

    private void isValidBst() {
        System.out.println(isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    private boolean isValidBst(TreeNode root, long minValue, long maxValue) {
        if(root == null) {
            return true;
        }
        if(root.data <= minValue || root.data >= maxValue) {
            return false;
        }
        boolean left =  isValidBst(root.left, minValue, root.data);
        if(left) {
            boolean right = isValidBst(root.right, root.data, maxValue);
            return right;
        }
        return false;
    }

    private void isPresent(int data) {
        if(isPresent(root, data) != null) {
            System.out.println("Data found");
        } else {
            System.out.println("Data not found");
        }
    }

    private TreeNode isPresent(TreeNode root, int data) {
        if(root == null || root.data == data) {
            return root;
        }
        if(data < root.data) {
            return isPresent(root.left, data);
        } else {
            return isPresent(root.right, data);
        }
    }

    private void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private void insert(int data) {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode root, int data) {
        TreeNode newNode = new TreeNode(data);
        if(root == null) {
            root = newNode;
            return root;
        }
        if(data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
