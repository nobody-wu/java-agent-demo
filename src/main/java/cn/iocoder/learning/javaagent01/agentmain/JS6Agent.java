package cn.iocoder.learning.javaagent01.agentmain;

import cn.iocoder.learning.javaagent01.ClassFileTransformerDemo;
import cn.iocoder.learning.javaagent01.permain.TransClass;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * 与“Premain-Class”类似，开发者必须在 manifest 文件里面设置“Agent-Class”来指定包含 agentmain 函数的类。
 *
 * 可是，跟 premain 不同的是，agentmain 需要在 main 函数开始运行后才启动
 *
 */
public class JS6Agent {

    /**
     * agentmain(String agentArgs, Instrumentation inst) 优先级高于 agentmain(String agentArgs)
     */
    public static void agentmain(String agentArgs) {
        System.out.println("我是一个萌萌哒的 Java Agent");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void agentmain(String agentArgs, Instrumentation inst) throws UnmodifiableClassException {

        inst.addTransformer(new ClassFileTransformerDemo());
        // 批量转换类定义，多用于 agentmain 场合。
        inst.retransformClasses(TransClass.class);
        System.out.println("一点不萌1");
    }

}
