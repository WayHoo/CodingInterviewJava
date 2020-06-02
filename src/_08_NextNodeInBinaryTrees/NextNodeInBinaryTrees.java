package _08_NextNodeInBinaryTrees;

import java.util.Stack;

/**
 * @author huwei
 * @date 2020/6/1 10:58
 */
public class NextNodeInBinaryTrees {

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = buildTree(preorder, inorder);
        TreeNode node = findNode(root, 1);
        TreeNode next = getNext(node);
        System.out.println(next != null ? next.val : null);
    }

    /**
     * 给定二叉树中的一个节点，寻找在中序遍历访问方式下该节点的下一个节点
     */
    public static TreeNode getNext(TreeNode node) {
        if( node == null )
            return null;
        TreeNode next = null;
        //如果该节点的右子节点不空，则下一个节点为右子树中最靠左的那个节点
        if( node.right != null ) {
            TreeNode tmpNode = node.right;
            while( tmpNode.left != null )
                tmpNode = tmpNode.left;
            next = tmpNode;
        }
        //如果右子节点为空，且当前节点为父节点的左子节点，那么父节点即为下一个节点
        else if( node.parent != null && node.parent.left == node )
            next = node.parent;
        //如果右子节点为空，且当前节点为父节点的右子节点，则一直向上遍历，直到找到一个是它父节点左子节点的结点
        else {
            TreeNode tmpNode = node.parent;
            while( tmpNode != null ){
                if( tmpNode.parent != null && tmpNode.parent.left == tmpNode ) {
                    next = tmpNode.parent;
                    break;
                }
                tmpNode = tmpNode.parent;
            }
        }
        return next;
    }

    /**
     * 使用二叉树的前序遍历和中序遍历数组构建一棵二叉树
     * 其中子树结点中包含一个指向父节点的指针
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if( preorder == null || preorder.length == 0 )
            return null;
        TreeNode head = buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
        return head;
    }

    public static TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                                     int[] inorder, int inLeft, int inRight) {
        if( inLeft > inRight )
            return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        for (int i = inLeft; i <= inRight ; i++) {
            if( inorder[i] == preorder[preLeft] ){
                TreeNode leftNode = buildTree(preorder, preLeft + 1,
                        preLeft + i - inLeft, inorder, inLeft, i - 1);
                root.left = leftNode;
                if( leftNode != null )
                    leftNode.parent = root;
                TreeNode rightNode = buildTree(preorder, preLeft + i - inLeft + 1,
                        preRight, inorder, i + 1, inRight);
                root.right = rightNode;
                if( rightNode != null )
                    rightNode.parent = root;
                break;
            }
        }
        return root;
    }

    /**
     * 利用堆栈进行层序遍历，查找值为val的结点并返回
     */
    public static TreeNode findNode(TreeNode head, int val) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while( !stack.empty() ) {
            TreeNode curNode = stack.pop();
            if( curNode != null ) {
                if( curNode.val == val )
                    return curNode;
                else {
                    stack.push(curNode.left);
                    stack.push(curNode.right);
                }
            }
        }
        return null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode(int x) {
        val = x;
    }
}
