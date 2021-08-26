import java.lang.*;
import java.lang.*;
import java.util.Random;
import java.math.BigInteger;
class RSA
{
BigInteger p,q,n,phi,e,d,x;
Random r=new Random();
RSA()
{
p=BigInteger.probablePrime(5,r);
q=BigInteger.probablePrime(5,r);
n=p.multiply(q);
phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
x=BigInteger.probablePrime(5/2,r);
x=x.add(BigInteger.ONE);
while(x.gcd(phi).compareTo(BigInteger.ONE)>0&&x.compareTo(phi)<0)
{
x=x.add(BigInteger.ONE);
}
d=x.modInverse(phi);
}
public String encryptRSA(String message)
{
   return ""+(new BigInteger(message)).modPow(x,n);
}
public String decryptRSA(String message)
{
   return ""+(new BigInteger(message)).modPow(d,n);
}
}
class CaesarCipher
{
public String encryptData(int key,String message)
{
String encrypted="";
for(int i=0;i<message.length();i++)
   encrypted+=(char)(((byte)message.charAt(i)+key)%128);
return encrypted;
}
public String decryptData(int key,String message)
{
String encrypted="";
for(int i=0;i<message.length();i++)
   encrypted+=(char)(((byte)message.charAt(i)-key)%128);
return encrypted;
}

public static void main(String args[])
{
Random rand = new Random(); 
int key = rand.nextInt(50); 
CaesarCipher cc=new CaesarCipher();
String encrypted=cc.encryptData(key,"BMSCE");

System.out.println("Key"+key+"\nMessage "+"BMSCE"+"\nEncrypted Message: "+encrypted);
RSA r=new RSA();
String encryptedKey=r.encryptRSA(""+key+"");
System.out.println("Encrypted Key "+encryptedKey);
int decryptedKey=Integer.parseInt(r.decryptRSA(""+encryptedKey+""));
System.out.println("Decrypted Key "+decryptedKey);

String mess=cc.decryptData(decryptedKey,encrypted);
System.out.println("Final Message: "+mess);
}
}