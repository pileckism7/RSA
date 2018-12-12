/**
 * 
 * @author Kieran Walsh, Martin Price, Mantas Pileckis
 *
 */
public class Person {
	private long exponent;
	private long modulus;
	private long base;
	
	//TODO
	//Generate a public key for this person, consisting of exponent,e, and modulus, m.
	//Generate a private key, consisting of an exponent, d.
	//Provide access to the public key only.
	public Person(long e, long m, long b)
	{
		exponent = e;
		modulus = m;
		base = b;
	}
	// Decrypt the cipher text
	public String decrypt(long[] cipher) 
	{
		String s = "";
		for(long l : cipher)
		{
			long x = (long)Math.pow(l, exponent) % modulus;
			s += (char)x;
		}
		return s;
	}
	
	// Encrypt a plain text message to she.
	public  long[]	encryptTo(String msg, Person p) 
	{
		long[] encrypted = new long[msg.length()];
		long key = p.getPublicKey();
		for(int i = 0; i < msg.length(); i++)
		{
			int asc = (int)msg.charAt(i);
			encrypted[i] = (long)Math.pow(asc, key) % modulus;
		}
		return encrypted;
	}
	
	//Access the public encryption exponent
	public long getE() 
	{ return exponent; }
	
	//Access the public modulus
	public long getM()
	{ return modulus; }
	
	public long getPublicKey()
	{ return (long)Math.pow(base, exponent) % modulus; }
}
