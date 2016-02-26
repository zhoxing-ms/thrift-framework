package impl;
import org.apache.thrift.TException; 
public class HelloServiceImpl implements Hello.Iface { 
   public boolean helloBoolean(boolean para) throws TException { 
       return para; 
   } 
   public int helloInt(int para) throws TException { 
       try { 
           Thread.sleep(20000); 
       } catch (InterruptedException e) { 
           e.printStackTrace(); 
       } 
       return para; 
   } 
   public String helloNull() throws TException { 
       return null; 
   } 
   public String helloString(String para) throws TException { 
       return para; 
   } 
   public void helloVoid() throws TException { 
       System.out.println("Hello World"); 
   } 
}