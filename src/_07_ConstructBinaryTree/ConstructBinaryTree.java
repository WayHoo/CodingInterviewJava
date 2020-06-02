package _07_ConstructBinaryTree;

/**
 * @author huwei
 * @date 2020/5/31 18:30
 */
public class ConstructBinaryTree {

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = buildTree(preorder, inorder);
        postOrderPrint(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if( preorder == null || preorder.length == 0 )
            return null;
        TreeNode head = buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
        return head;
    }

    /**
     * 根据前序遍历和中序遍历的特点将原二叉树切分为左子树和右子树，然后递归构建
     * @param preorder - 前序遍历数组
     * @param preLeft - 子树在前序遍历数组中对应的起始下标（包含）
     * @param preRight - 子树在前序遍历数组中对应的终止下标（包含）
     * @param inorder - 中序遍历数组
     * @param inLeft - 子树在中序遍历数组中对应的起始下标（包含）
     * @param inRight - 子树在中序遍历数组中对应的终止下标（包含）
     * @return 使用preorder[preLeft]值构建的TreeNode结点引用
     */
    public static TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                                     int[] inorder, int inLeft, int inRight) {
        if( inLeft > inRight )
            return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        for (int i = inLeft; i <= inRight ; i++) {
            if( inorder[i] == preorder[preLeft] ){
                root.left = buildTree(preorder, preLeft + 1, preLeft + i - inLeft,
                        inorder, inLeft, i - 1);
                root.right = buildTree(preorder, preLeft + i - inLeft + 1, preRight,
                        inorder, i + 1, inRight);
                break;
            }
        }
        return root;
    }

    /**
     * 递归后序遍历，用于main方法中测试
     */
    public static void postOrderPrint(TreeNode head) {
        if( head == null )
            return;
        postOrderPrint(head.left);
        postOrderPrint(head.right);
        System.out.print(head.val + "\t");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
