package list.q02;

import base.DataUtils;
import base.ListNode;

/**
 * 找到链表的倒数第 n 个节点
 *
 * 倒数第n个，就是整数 m-1+1 个，m为总数
 * <p>
 * 1. 蛮力法：两次遍历，第一次记录链表总个数 m，第二次去取第 m-n+1 的元素
 * 2. 散列表法: 一次遍历，用 HashMap 记录，key是位置，value 是node对象引用，一次遍历完后，直接取key是 m-n+1 的元素
 * 3. 两个引用法：两个引用(p1,p2)都指向 head, 一个引用(p1)先移动 n 个节点，然后两个引用一起移动，直到(p1)移动到未节点，然后p2就是需要的节点
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(nthNodeFromEnd(DataUtils.getListNode(), 1));
        System.out.println(nthNodeFromEnd(DataUtils.getListNode(), 3));
    }


    public static ListNode nthNodeFromEnd(ListNode head, int nthNode) {
        ListNode node;
        ListNode nodeTemp = head;
        // nodeTemp 移动 nthNode 位置
        for (int i = 0; i < nthNode; i++) {
            if (nodeTemp != null) {
                nodeTemp = nodeTemp.getNext();
            }
        }
        // 链表没有这么多元素
        if (nodeTemp == null) {

            return null;
        }
        // 开始移动
        node = head;
        while (nodeTemp != null) {
            node = node.getNext();
            nodeTemp = nodeTemp.getNext();
        }

        return node;
    }
























}
