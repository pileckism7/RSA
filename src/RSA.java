import java.util.Arrays;
import java.lang.Math;
import java.math.BigInteger;
import java.util.Random;
/**
 * 
 * @author Kieran Walsh, Martin Price, Mantas Pileckis
 *
 */
public class RSA {

	public RSA()
	{
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
	
	/**
	 * Convert a long to 2 chars
	 * @author Walsh
	 * @param long x
	 * @return String of 2 chars
	 */
	public static String longTo2Chars(long x)
	{
		String result = Long.toString(x).substring(0,2);
		return result;
	}
	
	
	/**
	 * Find a random prime number within range n to m.
	 * 
	 * @param int m, n (bounds) java.util.Random rand (Random number generator)
	 * @return long num a random prime number
	 * @author Walsh
	 */
	public static long	randPrime(int m, int n, java.util.Random rand) 
	{
		rand = new Random();
		int num = rand.nextInt(n - m) + m;

		while(!isPrime(num))
		{
			num = rand.nextInt(n - m) + m;
		}
		return num;
	}
	
	/**
	 * Used in randPrime to check if a number is prime.
	 * @param int number
	 * @return boolean
	 * @author Walsh
	 */
	private static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Find relatively prime number to n.
	 * 
	 * @param n
	 * @param rand
	 * @return long m
	 * @author Walsh
	 */
	public static long	relPrime(long n, java.util.Random rand) 
	{
		long m = rand.nextInt((int) (n-1));
		while(BigInteger.valueOf(n).gcd(BigInteger.valueOf(m)).intValue() != 1)
		{
			m = rand.nextInt((int) n-1);
		}
		return m;
	}
	
	/**
	 * Display an array of longs on stdout
	 * @param cipher
	 * @author Walsh
	 */
	public static void	show(long[] cipher) 
	{
		System.out.println(Arrays.toString(cipher));
	}
	
	/**
	 * Convert two numeric chars to a long
	 * @param msg
	 * @param p
	 * @return long
	 * @author Walsh
	 */
	public static long	toLong(java.lang.String msg, int p) 
	{
		String temp = msg.substring(p,p+1);
		return Long.parseLong(temp);
	}


}