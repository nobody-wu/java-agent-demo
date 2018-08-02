package cn.iocoder.learning.javaagent01;

import java.lang.instrument.Instrumentation;

public class Agent {

    /**
     * premain(String agentArgs, Instrumentation inst) 优先级高于 premain(String agentArgs)
     * 如果同时存在，会忽略 premain(String agentArgs)
     */
    public static void premain(String agentArgs) {
        System.out.println("我是一个萌萌哒的 Java Agent");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在 manifest 属性当中加入” Premain-Class”来指定执行当前类的premain方法
     *
     * premain顾名思义，就是在main方法之前执行
     *
     * @param agentArgs
     * @param instrumentation
     */
    public static void premain(String agentArgs, Instrumentation instrumentation)  {

        // 除开用 addTransformer 的方式，Instrumentation 当中还有另外一个方法“redefineClasses”来实现 premain 当中指定的转换
        // redefineClasses 的功能比较强大，可以批量转换很多类。
        instrumentation.addTransformer(new ClassFileTransformerDemo());

        System.out.println("一点不萌");
    }

}
