
1. Instrumentation 的基本功能和用法

2. Java SE 6 的新特性：虚拟机启动后的动态 instrument

```
在 Java SE 5 当中，开发者只能在 premain 当中施展想象力，所作的 Instrumentation 也仅限与 main 函数执行前，这样的方式存在一定的局限性。
在 Java SE 5 的基础上，Java SE 6 针对这种状况做出了改进，开发者可以在 main 函数开始执行以后，再启动自己的 Instrumentation 程序。
在 Java SE 6 的 Instrumentation 当中，有一个跟 premain“并驾齐驱”的“agentmain”方法，可以在 main 函数开始运行之后再运行。
```

学习资源：https://www.ibm.com/developerworks/cn/java/j-lo-jse61/index.html