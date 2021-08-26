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
public class threadIP implements Runnable{
    public void run()
    {
        try{
            findIP ip=new findIP();
            ip.setVisible(true);
            ip.startFunc();
        }
catch(Exception e)
{
}// TODO
    }
}
