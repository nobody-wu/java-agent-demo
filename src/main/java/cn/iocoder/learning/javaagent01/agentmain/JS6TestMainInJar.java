package cn.iocoder.learning.javaagent01.agentmain;

import cn.iocoder.learning.javaagent01.permain.TransClass;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 16:38 2018/8/2
 */
public class JS6TestMainInJar {

    public static void main(String[] args) {
        System.out.println(new TransClass().getNumber());
        int count = 0;
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            int number = new TransClass().getNumber();
            System.out.println(number);
            if (3 == number || count >= 10) {
                break;
            }
        }
    }

}

