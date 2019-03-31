package list.q08;

import base.DataUtils;
import base.ListNode;

/**
 * 判断一个链表的长度是偶数还是奇数
 *
 * 方法1：遍历一边，直接取得
 * 方法2：每次head往后移动两个位置
 */
public class Main {

    public static void main(String[] args) {
        isNodeListEven(DataUtils.getListNode());
    }

    public static void isNodeListEven(ListNode head) {
        while (head != null && head.getNext() != null) {
            head = head.getNext().getNext();
        }
        if (head == null) {
            System.out.println("长度是偶数");
        } else {
            System.out.println("长度是奇数");
        }
    }
}
