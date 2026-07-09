import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class IterativePostorderTraversal {
    static Scanner sc = new Scanner(System.in);
    static TreeNode buildTree() {
        System.out.print("Enter root value (-1 for no node): ");
        int data = sc.nextInt();
        if (data == -1)
            return null;
        TreeNode root = new TreeNode(data);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            System.out.print("Enter left child of " + current.val + " (-1 if none): ");
            int left = sc.nextInt();

            if (left != -1) {
                current.left = new TreeNode(left);
                queue.offer(current.left);
            }

            System.out.print("Enter right child of " + current.val + " (-1 if none): ");
            int right = sc.nextInt();

            if (right != -1) {
                current.right = new TreeNode(right);
                queue.offer(current.right);
            }
        }

        return root;
    }


    static List<Integer> postorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.left != null)
                stack.push(node.left);

            if (node.right != null)
                stack.push(node.right);
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = buildTree();

        List<Integer> result = postorder(root);

        System.out.println("Postorder Traversal:");
        System.out.println(result);
    }
}