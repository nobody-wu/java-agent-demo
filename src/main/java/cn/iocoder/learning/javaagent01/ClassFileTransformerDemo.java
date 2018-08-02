package cn.iocoder.learning.javaagent01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class ClassFileTransformerDemo implements ClassFileTransformer {

    /**
     * 要转换类的编译后的文件路径
     */
    public static final String classNumberReturns2 = "/Users/cornelius/workspaces/IDEAprojects/cornelius/learning/javaagent01/target/classes/cn/iocoder/learning/javaagent01/permain/TransClass2.class";

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
//        System.out.println("className: " + className);
//        if (!className.equalsIgnoreCase("cn/iocoder/learning/Dog")) {
//            return null;
//        }
////        return getBytesFromFile("cn/iocoder/learning/Cat");
//        return getBytesFromFile("/Users/yunai/Java/learning/example01/Dog.class");

        // 如果是TransClass这个类，就进行转换
        if (!className.equals("cn/iocoder/learning/javaagent01/permain/TransClass")) {
            return null;
        }
        return getBytesFromFile(classNumberReturns2);
    }

    public static byte[] getBytesFromFile(String fileName) {
        File file = new File(fileName);
        try (InputStream is = new FileInputStream(file)) {
            // precondition

            long length = file.length();
            byte[] bytes = new byte[(int) length];

            // Read in the bytes
            int offset = 0;
            int numRead = 0;
            while (offset <bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset < bytes.length) {
                throw new IOException("Could not completely read file "
                        + file.getName());
            }
            is.close();
            return bytes;
        } catch (Exception e) {
            System.out.println("error occurs in _ClassTransformer!"
                    + e.getClass().getName());
            return null;
        }
    }

}
