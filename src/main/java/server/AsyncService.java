package server;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TNonblockingServer.Args;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import impl.Hello;
import impl.Hello.Processor;
import impl.HelloServiceImpl;
public class AsyncService {
	/** 
     * 启动 Thrift 异步服务器
     * @param args 
     */ 
    public static void main(String[] args) { 
        TNonblockingServerTransport serverTransport; 
        try { 
            serverTransport = new TNonblockingServerSocket(10005); 
            Processor processor = new Hello.Processor(new HelloServiceImpl()); 
            TServer server = new TNonblockingServer(new Args(serverTransport).processor(processor)); 
            System.out.println("Start server on port 10005 ..."); 
            server.serve(); 
        } catch (TTransportException e) { 
            e.printStackTrace(); 
        } 
    } 
}
