/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendsecrets;

import java.net.*;    
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.math.BigInteger;
/**
 *
 * @author ImSam
 */
    
class receiveMessage implements Runnable{
 
    public static int myCount = 0;
    public receiveMessage(){
         
    }
    public void run() {
        while(true){
    String location="E:/downloadedpicback.jpg";
    final long FILE_SIZE = 6022386;
        try{
            ServerSocket sersock = new ServerSocket(4000);
     Socket sock = sersock.accept();            // binding with port: 4000
                                                                                                 
                               // reading the file name from client
     InputStream istream = sock.getInputStream( );
     BufferedReader fileRead =new BufferedReader(new InputStreamReader(istream));
                             // reading file contents
                             RSA r=new RSA();
     OutputStream  ostream = sock.getOutputStream( );
     PrintWriter pwrite = new PrintWriter(ostream, true);
     pwrite.println(r.N);
     pwrite.println(r.e);
     String key=fileRead.readLine();
     if(key.equals(""))
         key="No Key";
      
     BufferedImage img=ImageIO.read(ImageIO.createImageInputStream(sock.getInputStream()));
      File outputfile = new File("E:/saved.png");
     
      ImageIO.write(img, "PNG", outputfile);
     
    
      new imageDecode(img,r,key).imageDecodeLoad(img,r,key);  
          sock.close();  sersock.close();       // closing network sockets
       fileRead.close();
        }
        catch(Exception e){}
        }
        }
    }
    

