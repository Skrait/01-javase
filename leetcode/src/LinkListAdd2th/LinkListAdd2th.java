package LinkListAdd2th;

import org.junit.Test;

/**
 * @author Peekaboo
 * @date 2023年02月02日 17:08
 * 2.两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class LinkListAdd2th {

    @Test
    public void addTwoNumbersTest1(){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode res = addTwoNumbers(l1, l4);
        while (res != null){
            System.out.print(res.val + "");
            res = res.next;
        }

    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }
}
