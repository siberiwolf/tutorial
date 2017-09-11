1.java.io基于流，通过Stream对象一次移动一个字节，java.nio基于块，块I/O比流I/O高效很多，主要针对最耗时的 I/O 操作(即填充和提取缓冲区)

2.nio核心概念是通道(Channel)和缓冲区(Buffer)，Channel是对Stream的模拟，所有需要写到Channel的内容都必须先写到Buffer中，所有从Channel读取的内容也必须先读到Buffer中

3.Buffer实质上是一个数组，但Buffer不仅仅是一个数组，Buffer提供了对数据的结构化访问(???)，而且可以跟踪系统的读/写进程(???)

4.Channel和Stream的区别，Channel是双向的，Stream分为InputStream和OutputStream，数据单向流动，Channel则可用于读、写或同时读/写