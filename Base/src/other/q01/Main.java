package other.q01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * 三个线程，依次输入 A , B, C ，输入10次
 */
public class Main {

    private static int index = 0;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

//        method1();

        // method1 更优雅的写法
        method2();
    }

    private static void method1() {
        Thread threadA = new Thread(() -> {
            while (index < 30) {
                lock.lock();

                if (index >= 30) {
                    lock.unlock();

                    break;
                }

                if (index % 3 == 0) {
                    System.out.println(index + ":A");

                    index++;
                }

                lock.unlock();

            }
        });
        Thread threadB = new Thread(() -> {
            while (index < 30) {
                lock.lock();

                if (index >= 30) {
                    lock.unlock();

                    break;
                }

                if (index % 3 == 1) {
                    System.out.println(index + ":B");

                    index++;
                }

                lock.unlock();

            }
        });
        Thread threadC = new Thread(() -> {
            while (index < 30) {
                lock.lock();

                if (index >= 30) {
                    lock.unlock();

                    break;
                }

                if (index % 3 == 2) {
                    System.out.println(index + ":C");

                    index++;
                }

                lock.unlock();

            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }


    private static void method2() {
        Thread threadA = work(i -> i % 3 == 0, () -> System.out.println("A"));
        Thread threadB = work(i -> i % 3 == 1, () -> System.out.println("B"));
        Thread threadC = work(i -> i % 3 == 2, () -> System.out.println("C"));

        threadA.start();
        threadB.start();
        threadC.start();
    }


    public static Thread work(Predicate<Integer> condition, Runnable func) {
        return new Thread(() -> {
            while (index < 30) {
                lock.lock();

                // 因为 while 判断是在 lock 之前的，所有可能存在进入的时候 <30 进入之后在其他线程加 1 ，导致 >30
                if (index >= 30) {
                    // 释放进入的锁
                    lock.unlock();

                    break;
                }

                if (condition.test(index)) {
                    func.run();

                    index++;
                }

                lock.unlock();
            }
        });
    }
}
