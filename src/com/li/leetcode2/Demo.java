package com.li.leetcode2;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.li.leetcode2
 * @date 2020/11/16 20:19
 * @example:
 * @Description:
 */
public class Demo {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public int getVal() {
            return val;
        }
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode l4 = l3;
        int i = 0;
        while (l1!=null || l2!=null || i==1) {
            int sum = (l1==null?0:l1.val) + (l2==null?0:l2.val) + i;
            if (sum > 9){
                l3.next = new ListNode(sum % 10);
                i = 1;
            } else {
                l3.next = new ListNode(sum);
                i = 0;
            }
            l3 = l3.next;
            if (l1!=null) l1 = l1.next;
            if (l2!=null )l2 = l2.next;
        }
        return l4.next;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode();

        ListNode l4 = l3;

        int i = 0;


        while (l1!=null && l2!=null) {


            if (l1.val+l2.val+i > 9){
                l3.val = (l1.val+l2.val+i) % 10;
                i = 1;
            } else {
                l3.val = l1.val+l2.val+i;
                i = 0;
            }
            if(l1.next != null || l2.next != null) {
                l3.next = new ListNode();
                l3 = l3.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null){
            while (l1 != null){
                if (l1.val+i > 9){
                    l3.val = (l1.val+i) % 10;
                    i = 1;
                } else {
                    l3.val = l1.val+i;
                    i = 0;
                }
                if(l1.next != null) {
                    l3.next = new ListNode();
                    l3 = l3.next;
                }


                l1 = l1.next;
            }
        }
        if (l2 != null){
            while (l2 != null){
                if (l2.val+i > 9){
                    l3.val = (l2.val+i) % 10;
                    i = 1;
                } else {
                    l3.val = l2.val+i;
                    i = 0;
                }
                if(l2.next != null) {
                    l3.next = new ListNode();
                    l3 = l3.next;
                }


                l2 = l2.next;
            }
        }

        if (i==1){
            l3.next = new ListNode(i);
        }


        return l4;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = addTwoNumbers(l1, l2);

        ListNode l4 = new ListNode(0, l3);
        String res = "( ";
        while (l4.next != null){
            res = res + l4.next.getVal() + "->";
            l4 = l4.next;
        }
        res = res + " )";
        System.out.println(res);
    }
}
