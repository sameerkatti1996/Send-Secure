
import java.net.*;    
import java.io.*;
public class receiveImage   
{
  public static void main(String args[]) throws Exception
  {                           // establishing the connection with the server
     ServerSocket sersock = new ServerSocket(4000);
     System.out.println("Server ready for connection");
     Socket sock = sersock.accept();            // binding with port: 4000
     System.out.println("Connection is successful and wating for chatting");
                                                                                                 
                               // reading the file name from client
     InputStream istream = sock.getInputStream( );
     BufferedReader fileRead =new BufferedReader(new InputStreamReader(istream));
     String fname = fileRead.readLine( );
                             // reading file contents
     OutputStream  ostream = sock.getOutputStream( );
     PrintWriter pwrite = new PrintWriter(ostream, true);
     pwrite.println("Hello"); 
     System.out.println(fname);     sock.close();  sersock.close();       // closing network sockets
       fileRead.close(); 
  }
  
  }
