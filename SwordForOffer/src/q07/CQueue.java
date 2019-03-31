package q07;

/**
 * 用两个栈实现一个队列，完成两个函数 appendTail 和 deletedHead，分别是在队列尾部插入节点和在队列头部删除节点的功能
 * <p>
 * 思路：内部创建 A B 两个栈，加元素只往 A 里加，弹出元素，先判断 B 是否有元素，如果有直接弹出，如果没有，A 所有元素出栈，依次放入 B 中，然后从 B 中出栈
 */
public class CQueue {

}
