/**
 * 
 * @author Kieran Walsh, Martin Price, Mantas Pileckis
 *
 */
import java.util.Random;
public class Person 
{
	/** Instance Variables */
	private long privKey;	//Decrypt with
	private long mod;
	private long p;
	private long q;
	
	/**
	 * Constructor
	 * @param e exponent
	 * @param m modulus
	 * @param b base
	 */
	public Person()
	{
		long p = RSA.randPrime((int)(Math.sqrt(Math.sqrt(Long.MAX_VALUE))), (int)Math.sqrt(Long.MAX_VALUE), new Random());
		long q = RSA.randPrime((int)(Math.sqrt(Math.sqrt(Long.MAX_VALUE))), (int)Math.sqrt(Long.MAX_VALUE), new Random());
		mod = p * q;
		privKey = RSA.inverse(getPublicKey(), ((p-1)*(q-1)));
	}
	
	/**
	 * Decrypts the cipher message
	 * 
	 * @param cipher : long array representing the cipher message
	 * @return : decrypted cipher
	 * @author martinprice
	 */
	public String decrypt(long[] cipher) 
	{
		String s = "";
		for(long l : cipher)
		{
			long x = RSA.modPower(l, privKey, mod);
			s += RSA.longTo2Chars(x);
		}
		return s;
	}
	
	/**
	 * Encrypts the message
	 * @param msg message to encrypt
	 * @param p recipient of encrypted message
	 * @return encrypted message
	 * @author martinprice
	 */
	public  long[]	encryptTo(String msg, Person p) 
	{
		long[] encrypted = new long[msg.length()];
		long key = p.getPublicKey();
		for(int i = 0; i < msg.length(); i++)
		{
			int asc = (int)msg.charAt(i);
			encrypted[i] = RSA.modPower(asc, key, p.getM());
		}
		return encrypted;
	}
	
	/**
	 * 
	 * @return public modulus
	 * @author martinprice
	 */
	public long getM()
	{ return mod; }
	
	/**
	 * Calculates the person public key
	 * @return the persons public key
	 * @author martinprice
	 */
	public long getPublicKey()
	{ return RSA.relPrime(((p-1) * (q-1)), new Random()); }
}
