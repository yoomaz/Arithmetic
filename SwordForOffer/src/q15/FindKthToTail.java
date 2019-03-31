package q15;

/**
 * 输入一个链表，输出该链表的倒数第K个结点
 * <p>
 * 在 Base->list->q02
 * <p>
 * 思路：第 k 个节点，就是正数第 n-k+1 个节点，如果知道长度，直接取就好了；
 * 如果不知道长度，就定义两个下标，第一个下标先走 k 个节点的距离，然后第二个下标开始和和第一个下标一起走，当第一个下标走到最后一个节点的时候，此时第二个下标的位置就是目标位置
 */
public class FindKthToTail {

}
