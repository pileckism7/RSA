/**
 * 
 * @author Kieran Walsh, Martin Price, Mantas Pileckis
 *
 */
public class RSA {

	public RSA(){
	}

	/**public static void main (String args[])
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
	}**/
	public static void main (String args[]) {
		// Test for inverse, Works good. // 13inverse mod 60 == 37.
		System.out.println(inverse(13,60));
		
		// Test for Mod power, Works good.  // 17^13 mod 77 == 73.
		System.out.println(modPower(17,13,77));
	}
	
	/**@author Mantas Pileckis
	 * 	Find the multiplicative inverse of a long e, mod m
	 * @param e Number
	 * @param m Modulus
	 * @return Result of inverse Number modded by m
	 */

	public static long inverse(long e, long m) { 
        long m0 = m; 
        long y = 0;
        long x = 1; 
  
        if (m == 1) {
            return 0;
        }
        while (e > 1) { 
            long q = e / m; 
            long t = m; 
            m = e % m; 
            e = t; 
            t = y; 
            y = x - q * y; 
            x = t; 
        } 
        if (x < 0) {
            x += m0;
        }
  
        return x; 
    } 
	//Convert a long to 2 chars
	public static String longTo2Chars(long x){
		return null;
	}
	/**@author Mantas Pileckis
	 * Raise a number, b, to a power, p, modulo m
	 * @param b Number
	 * @param p Power 
	 * @param m Modulus
	 * @return Result of (number raised to power) mod
	 *
	 */
	public static long	modPower(long b, long p, long m) {
		long result = 1;      
		b = b % m;  
		while (p > 0) { 
			if((p & 1)==1) {
				result = (result * b) % m;
			}
			p = p >> 1;  
			b = (b * b) % m;  
		} 
		return result; 
	}
	// Find a random prime number
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
