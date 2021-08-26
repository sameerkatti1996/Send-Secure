/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendsecrets;
/**
 *
 * @author ImSam
 */
public class SendSecrets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        receiveMessage mrt = new receiveMessage();
        Thread t = new Thread(mrt);
        t.start();
        new imageEncode().imageEncodeLoad();// TODO code application logic here
            }
    
}
