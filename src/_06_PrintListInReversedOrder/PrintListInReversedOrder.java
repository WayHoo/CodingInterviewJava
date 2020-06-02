package _06_PrintListInReversedOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huwei
 * @date 2020/5/31 16:23
 */
public class PrintListInReversedOrder {

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        for (int i = 9; i > 0; i--) {
            addNode(head, i);
        }
        int[] nums = reversePrint(head);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

    public static int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while( node != null ){
            list.add(node.val);
            node = node.next;
        }
        int[] nums = new int[list.size()];
        for (int i = list.size() - 1, j = 0; i >= 0; i--,j++) {
            nums[j] = list.get(i);
        }
        return nums;
    }

    /**
     * 向已有链表中添加节点
     * 用于在main方法添加测试数据
     */
    public static void addNode(ListNode head, int val) {
        ListNode node = new ListNode(val);
        ListNode tmpNode = head;
        if( tmpNode == null )
            return;
        while( tmpNode.next != null )
            tmpNode = tmpNode.next;
        tmpNode.next = node;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}