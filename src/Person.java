/**
 * 
 * @author Kieran Walsh, Martin Price, Mantas Pileckis
 *
 */
public class Person {
	long exponent;
	long modulus;
	
	public Person(){
		//TODO
		//Generate a public key for this person, consisting of exponent,e, and modulus, m.
		//Generate a private key, consisting of an exponent, d.
		//Provide access to the public key only.
		
	}
	// Decrypt the cipher text
	public String decrypt(long[] cipher) {
		return null;
	}
	
	// Encrypt a plain text message to she.
	public  long[]	encryptTo(java.lang.String msg, Person she) {
		return null;
	}
	
	//Access the public encryption exponent
	public  long getE() {
		return exponent;
	}
	
	//Access the public modulus
	public long getM(){
		return modulus;
	}
}
