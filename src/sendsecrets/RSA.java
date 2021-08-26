package sendsecrets;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
 
public class RSA
{
    BigInteger p;
    BigInteger q;
    BigInteger N;
    BigInteger phi;
    BigInteger e;
    BigInteger d;
    int        bitlength = 1024;
    Random     r;
 
    public RSA()
    {
        r = new Random();
        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
        {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }
 
    public RSA(BigInteger e, BigInteger d, BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.N = N;
    }
 
    
    public String RSAEncrypt(String message,BigInteger E,BigInteger n) throws IOException
    {
        byte[] encrypted = this.encrypt(message.getBytes(),E,n);
        // decrypt
       return bytesToString(encrypted);
    }
    public String RSADecrypt(String message,BigInteger D,BigInteger n) throws IOException
    {
        byte[] decrypted = this.decrypt(StringToBytes(message),D,n); 
       return finalString(decrypted);
    }
    public String finalString(byte[] decrypted)
    {
        String s=new String(decrypted);
        return s;
    }
     private static byte[] StringToBytes(String encrypted)
    {
        String[] parts = encrypted.split("\n");
        byte[] h=new byte[parts.length];
        for(int i=0;i<parts.length;i++){
         h[i]=Byte.valueOf(parts[i]);
         }
        return h;
    }

    private static String bytesToString(byte[] encrypted)
    {
        String test = "";
        for (byte b : encrypted)
        {
            test += Byte.toString(b);
            test+="\n";
        }
        return test;
    }
 
    // Encrypt message
    public byte[] encrypt(byte[] message,BigInteger E, BigInteger n)
    {
        return (new BigInteger(message)).modPow(E, n).toByteArray();
    }
 
    // Decrypt message
    public byte[] decrypt(byte[] message,BigInteger D, BigInteger n)
    {
     return (new BigInteger(message)).modPow(D, n).toByteArray();
    }
}
