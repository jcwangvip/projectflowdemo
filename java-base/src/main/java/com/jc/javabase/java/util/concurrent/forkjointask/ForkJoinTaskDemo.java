package com.jc.javabase.java.util.concurrent.forkjointask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-11-27
 */
public class ForkJoinTaskDemo extends RecursiveTask<Integer> {

    protected int start;
    protected int end;


    public ForkJoinTaskDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        int m = 2000, s = start, n = end, r = 0;
        // 创建子任务列表,每个子任务处理m个数字
        List<ForkJoinTask<Integer>> lt = new ArrayList<>();
        do {
            if (n - s < m * 1.5f) {
                for (int i = s; i <= n; i++) {
                    r += 1;
                }
                System.out.println("Sum " + s + "~~" + n + " = " + r);
            } else {
                n = Math.min(s + m - 1, n);
                lt.add(new ForkJoinTaskDemo(s, n).fork());
            }
            s = n + 1;
            n = end;
        } while (s <= end);

        for (ForkJoinTask<Integer> t : lt) {
            r += t.join();
        }
        return r;
    }

    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        int ss = 1, nn = 10001;
        Future<Integer> result = fjp.submit(new ForkJoinTaskDemo(ss, nn));
        try {
            Integer value = result.get();
            System.out.println("最后计算结果 = " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
