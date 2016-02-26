package server;
import org.apache.thrift.TProcessor; 
import org.apache.thrift.protocol.TBinaryProtocol; 
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer; 
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket; 
import org.apache.thrift.transport.TTransportException;
import impl.Hello;
import impl.HelloServiceImpl; 
public class TThreadPoolService { 
   /**
    * 多线程服务器端使用标准的阻塞式 I/O
    * @param args
    */
   public static void main(String[] args) { 
       try { 
           // 设置服务端口为 7911 
           TServerSocket serverTransport = new TServerSocket(7911); 
           // 设置协议工厂为 TBinaryProtocol.Factory 
           Factory proFactory = new TBinaryProtocol.Factory();  
/*			使用 TCompactProtocol 协议构建的 HelloServiceServer.java
           TCompactProtocol.Factory proFactory = new TCompactProtocol.Factory();
         	使用 TJSONProtocol 协议构建的 HelloServiceServer.java
        	TJSONProtocol.Factory proFactory = new TJSONProtocol.Factory();
         	使用 TJSONProtocol 协议的 HelloServiceClient.java
         	TJSONProtocol protocol = new TJSONProtocol(transport);
			使用 TCompactProtocol 协议的 HelloServiceClient.java
			TCompactProtocol protocol = new TCompactProtocol(transport);*/
           // 关联处理器与 Hello 服务的实现      
           TProcessor processor = new Hello.Processor(new HelloServiceImpl()); 
           TServer server = new TThreadPoolServer(new Args(serverTransport).processor(processor)); 
           System.out.println("Start server on port 7911..."); 
           server.serve(); 
       } catch (TTransportException e) { 
           e.printStackTrace(); 
       } 
   } 
}
