package server;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TNonblockingServer.Args;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import impl.Hello;
import impl.HelloServiceImpl;
public class TNonblockingService {
	/*
	 * 使用非阻塞方式，按块的大小进行传输，类似于 Java 中的 NIO
	 */
	public static void main(String[] args) { 
       try { 
    	   TNonblockingServerTransport serverTransport; 
    	   serverTransport = new TNonblockingServerSocket(10005); 
    	   Hello.Processor processor = new Hello.Processor(new HelloServiceImpl()); 
    	   TServer server = new TNonblockingServer(new Args(serverTransport).processor(processor)); 
    	   System.out.println("Start server on port 10005 ..."); 
    	   server.serve();
	   } catch (TTransportException e) { 
	       e.printStackTrace(); 
	   } 
	}
}
