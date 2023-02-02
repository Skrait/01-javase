import org.testng.annotations.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author Peekaboo
 * @date 2023年01月30日 22:18
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * CountDownLatch要从2一直减到0,主线程才可以执行
     * 否则的话,主线程(main函数)只能一直等待
     */
    @Test
    public void test1(){
        System.out.println("全班同学开始考试:一共2个学生");
        new Thread( () -> {
            System.out.println("第一个同学交卷,countDownLatch减1");
            countDownLatch.countDown();
        }).start();
        new Thread( () -> {
            System.out.println("第二个同学交卷,countDownLatch减1");
            countDownLatch.countDown();
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("老师清点试卷，在此之前，只要一个学生没交" + "countDownLatch不为0，不能离开考场");
    }
}
