
## cft (ClassFileTransformer) ##

Instrumentation基本功能：通过代理的替换原有功能

如何创建一个代理呢？


1. 代理实现类必须实现ClassFileTransformer接口，并实现transform（）方法。通过这个方法，代理可以得到虚拟机载入的类的字节码（classfileBuffer），代理的功能一般通过操作这一串字节码得以实现。
2. 需要提供一个公共的静态方法Premain。一般在这个方法中创建代理对象，通过inst的addTransform()方法将创建的代理对象传递给虚拟机。

代理工作原理图：

![](https://www.ibm.com/developerworks/cn/java/j-lo-instrumentation/pic1.JPG)

使用方法：

1、将项目中的META-INF替换src的META-INF，打包成jar

2、将agentclass copy到jar包统计目录

3、使用如下命令

    
    -- 正常调用main方法，返回结果1
    java -cp XXX.jar Main
    
    	
    --使用代理，调用premain方法，读取agentclass的文件，返回结果2	 
    java -agent:XXX.jar -cp XXX.jar Main 




