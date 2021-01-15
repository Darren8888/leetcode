package com.example.sort.list;

public class ListReverse {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node reverse(Node head, int n) {
        if (null == head || 0>=n) return head;

        int count = 0;
        Node pre = head, current = head, next = head;
        boolean isFirst = true;
        Node firstReverseHead = head;
        Node newHead = null;
        while (null != next) {
            if (count == n) {
                newHead = reverseInner(newHead, pre, current);
                if (isFirst) {
                    firstReverseHead = newHead;
                    isFirst = false;
                }

                pre = current = next;
                count = 0;
                continue;
            }

            ++count;
            current = next;
            next = next.next;
        }

        if (n == count) {
            newHead = reverseInner(newHead, pre, current);
            pre = null;
            if (isFirst) {
                firstReverseHead = newHead;
            }
        }

        if (null != newHead) {
            Node node = lastNode(newHead);
            if (null == pre) {
                node.next = null;
            } else {
                node.next = pre;
            }
        }

        return firstReverseHead;
    }

    private static Node reverseInner(Node preHead, Node start, Node end) {
        Node node = null;
        if (null != preHead) {
            node = lastNode(preHead);
        }

        Node currentNewHead = reverse(start, end);

        if (null != node)
            node.next = currentNewHead;

        return currentNewHead;
    }

    private static Node reverse(Node head, Node end) {
        if (head == end) return end;

        if (head.next == end) {
            end.next = head;
            head.next = null;
        } else {
            Node pre = head, next = head.next;
            head.next = null;
            while (next != end) {
                Node newNode = next.next;
                next.next = pre;
                pre = next;
                next = newNode;
            }
            end.next = pre;
        }

        return end;
    }

    private static Node lastNode(Node head) {
        if (null == head || (null == head.next)) return head;

        Node node = head;
        while (null != node.next) {
            node = node.next;
        }

        return node;
    }

}
