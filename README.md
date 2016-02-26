Apache Thrift 是 Facebook 实现的一种高效的、支持多种编程语言的远程服务调用的框架。本项目将从 Java 开发人员角度详细介绍 Apache Thrift 的架构、开发和部署，并且针对不同的传输协议和服务类型给出相应的 Java 实例

>常见的服务端类型有以下几种：
TSimpleServer —— 单线程服务器端使用标准的阻塞式 I/O
代码如下：
*使用 TSimpleServer 服务端构建的 HelloServiceServer.java
  // 设置调用的服务地址为本地，端口为 7911 
   TTransport transport = new TSocket("localhost", 7911); 
   transport.open(); 
   // 设置传输协议为 TBinaryProtocol 
   TProtocol protocol = new TBinaryProtocol(transport); 
   Hello.Client client = new Hello.Client(protocol); 
   // 调用服务的 helloVoid 方法
   client.helloVoid(); 
   transport.close(); 
*TThreadPoolServer —— 多线程服务器端使用标准的阻塞式 I/O
   // 设置调用的服务地址为本地，端口为 7911 
   TTransport transport = new TSocket("localhost", 7911); 
   transport.open(); 
   // 设置传输协议为 TBinaryProtocol 
   TProtocol protocol = new TBinaryProtocol(transport); 
   Hello.Client client = new Hello.Client(protocol); 
   // 调用服务的 helloVoid 方法
   client.helloVoid(); 
   transport.close(); 
*TNonblockingServer —— 多线程服务器端使用非阻塞式 I/O
  // 设置调用的服务地址为本地，端口为 7911 
  TTransport transport = new TFramedTransport(new TSocket("localhost", 10005));
  transport.open(); 
  // 设置传输协议为 TBinaryProtocol 
  TProtocol protocol = new TBinaryProtocol(transport); 
  Hello.Client client = new Hello.Client(protocol); 
  // 调用服务的 helloVoid 方法
  client.helloVoid(); 
  transport.close(); 
