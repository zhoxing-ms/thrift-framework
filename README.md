Apache Thrift 是 Facebook 实现的一种高效的、支持多种编程语言的远程服务调用的框架。本项目将从 Java 开发人员角度详细介绍 Apache Thrift 的架构、开发和部署，并且针对不同的传输协议和服务类型给出相应的 Java 实例

#常见的服务端类型有以下几种：
TSimpleServer —— 单线程服务器端使用标准的阻塞式 I/O
代码如下：
使用 TSimpleServer 服务端构建的 HelloServiceServer.java
TServerSocket serverTransport = new TServerSocket(7911); 
TProcessor processor = new Hello.Processor(new HelloServiceImpl()); 
TServer server = new TSimpleServer(processor, serverTransport); 
System.out.println("Start server on port 7911..."); 
server.serve();
TThreadPoolServer —— 多线程服务器端使用标准的阻塞式 I/O
使用方法如清单 3 所示。
TNonblockingServer —— 多线程服务器端使用非阻塞式 I/O
使用方法请参考 Thrift 异步客户端构建
