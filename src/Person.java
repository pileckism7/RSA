/**
 * 
 * @author Kieran Walsh, Martin Price, Mantas Pileckis
 *
 */
public class Person {
	private long exponent;
	private long modulus;
	private long base;
	private long d;
	
	/**
	 * Constructor
	 * @param e exponent
	 * @param m modulus
	 * @param b base
	 */
	public Person(long e, long m, long b)
	{
		exponent = e;
		modulus = m;
		base = b;
		d = RSA.inverse(e, m);
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
			long x = RSA.modPower(l, d, modulus);
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
			encrypted[i] = RSA.modPower(base, p.getE(), p.getM());
		}
		return encrypted;
	}
	
	/**
	 * 
	 * @return public exponent
	 * @author martinprice
	 */
	public long getE() 
	{ return exponent; }
	
	/**
	 * 
	 * @return public modulus
	 * @author martinprice
	 */
	public long getM()
	{ return modulus; }
	
	/**
	 * Calculates the person public key
	 * @return the persons public key
	 * @author martinprice
	 */
	public long getPublicKey()
	{ return RSA.modPower(base, exponent, modulus); }
