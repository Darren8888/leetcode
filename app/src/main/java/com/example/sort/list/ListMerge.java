package com.example.sort.list;

public class ListMerge {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int value) {
            this.val = value;
        }
        public ListNode(int value, ListNode next) {
            this.val = value;
            this.next = next;
        }
    }

    public static ListNode mergeTowList(ListNode left, ListNode right) {
        if (null == left) return right;
        if (null == right) return left;

        ListNode node = null;
        if (left.val >= right.val) {
            node = new ListNode(right.val, mergeTowList(left, right.next));
        } else {
            node = new ListNode(left.val, mergeTowList(left.next, right));
        }
        return node;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if ((null == lists) || (0 == lists.length)) return null;
        if (1 == lists.length) return lists[0];
        if (2 == lists.length) return mergeTowList(lists[0], lists[1]);

        int mid = lists.length/2;
        ListNode[] list1 = new ListNode[mid];
        for (int i=0; i<mid; ++i) {
            list1[i] = lists[i];
        }
        ListNode left = mergeKLists(list1);

        ListNode[] list2 = new ListNode[lists.length-mid];
        for (int i=0; i<list2.length; ++i) {
            list2[i] = lists[mid+i];
        }
        ListNode right = mergeKLists(list2);

        return mergeTowList(left, right);
    }
}
