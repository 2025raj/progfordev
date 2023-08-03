//question 4b

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeBrothers {
    private TreeNode parentX;
    private TreeNode parentY;
    private int depthX;
    private int depthY;

    public boolean areBrothers(TreeNode root, int x, int y) {
        // Find nodes with values x and y and their parents and depths
        findNodes(root, null, 0, x, y);
        
        // Check if nodes are at the same depth and have different parents
        return depthX == depthY && parentX != parentY;
    }

    private void findNodes(TreeNode node, TreeNode parent, int depth, int x, int y) {
        // Base case: If node is null, return
        if (node == null) {
            return;
        }

        // Check if current node's value is x or y
        if (node.val == x) {
            parentX = parent;
            depthX = depth;
        } else if (node.val == y) {
            parentY = parent;
            depthY = depth;
        }

        // Recursively search for x and y in left and right subtrees
        findNodes(node.left, node, depth + 1, x, y);
        findNodes(node.right, node, depth + 1, x, y);
    }

    public static void main(String[] args) {
        // Create a binary tree with root value 1 and given structure
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        // Nodes to check if they are brothers
        int x = 4;
        int y = 3;

        // Create the BinaryTreeBrothers object and check if nodes are brothers
        BinaryTreeBrothers bt = new BinaryTreeBrothers();
        boolean result = bt.areBrothers(root, x, y);
        
        // Output the result
        System.out.println(result); // Output: false
    }
}
