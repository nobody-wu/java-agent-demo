package cn.iocoder.learning.javaagent01.permain;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 16:38 2018/8/2
 */
public class TestMainInJar {

    public static void main(String[] args) {
        System.out.println(new TransClass().getNumber());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

