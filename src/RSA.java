/**
 * 
 * @author Kieran Walsh, Martin Price, Mantas Pileckis
 *
 */
public class RSA {

	public RSA(){
	}

	public static void main (String args[])
	{ 	
		Person Alice = new Person();
		Person Bob = new Person();

		String msg = new String ("Bob, let's have lunch."); 	// message to be sent to Bob
		long []  cipher;
		cipher =  Alice.encryptTo(msg, Bob);			// encrypted, with Bob's public key

		System.out.println ("Message is: " + msg);
		System.out.println ("Alice sends:");
		show (cipher);

		System.out.println ("Bob decodes and reads: " + Bob.decrypt (cipher));	// decrypted,
								// with Bob's private key.
		System.out.println ();

		msg = new String ("No thanks, I'm busy");
		cipher = Bob.encryptTo (msg, Alice);
	
		System.out.println ("Message is: " + msg);
		System.out.println ("Bob sends:");
		show (cipher);

		System.out.println ("Alice decodes and reads: " + Alice.decrypt (cipher));
	}
	//Find the multiplicative inverse of a long int, mod m
	public static long inverse(long e, long m)
	{
		return null;
	}
	//Convert a long to 2 chars
	public static String longTo2Chars(long x){
		return null;
	}
	//Raise a number, b, to a power, p, modulo m
	public static long	modPower(long b, long p, long m){
		return null;
	}
	// Find a randomg prime number
	public static long	randPrime(int m, int n, java.util.Random rand) {
		return null;
	}
	//Find a random number relatively prime to a given long int
	public static long	relPrime(long n, java.util.Random rand) {
		return null;
	}
	//Display an array of longs on stdout
	public static void	show(long[] cipher) {
	}
	//Convert two numeric chars to a long
	public static long	toLong(java.lang.String msg, int p) {
		return null;
	}


}
