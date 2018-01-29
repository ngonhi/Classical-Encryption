import java.util.Scanner;

public class CeaserCipher {

	/** 
	 * encode takes in an int and a String
	 *  to return an encoded String using
	 *  Ceaser Cipher method
	 *  
	 * @param int n 
	 * @param String str
	 * @return String 
	 */
	public static String encode (int n, String str) {
		/* Set the base as the value of 'a', first character in the alphabet */
		int base = (int) 'a';
		char[] encoded = str.toCharArray();

		/* Encode each character in the original string */
		for (int i = 0; i < encoded.length; i++) {
			int encodeVal = (int) (encoded[i] - base + n);
			encoded[i] = (char) (encodeVal % 26 + base);
		}

		return new String(encoded);
	}

	/**
	 * decode takes in an int and a String 
	 *  to return an decoded String using
	 *  Ceaser Cipher method
	 *  
	 * @param int n 
	 * @param String str
	 * @return String 
	 */
	public static String decode (int n, String str) {
		/* Set the base as the value of 'a', first character in the alphabet */
		int base = (int) 'a';
		char[] decoded = str.toCharArray();

		/* Decode each character in the original string */
		for (int i = 0; i < decoded.length; i++) {
			int decodeVal = (int) (decoded[i] - base - n);
			if (decodeVal >= 0) {
				decoded[i] = (char) (decodeVal % 26 + base);
			} else {
				decoded[i] = (char) (decodeVal + 26 + base);
			}
		}

		return new String(decoded);
	}

	/**
	 * inputOperator checks user input and acts accordingly
	 *  The string that the user enters after is assumed to be all lowercase
	 *   with no whitespace
	 * 
	 * @return int
	 */
	public static int inputOperator () {
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();

		try {
			/* User input can be "encode", "decode"
			 *  or anything else that would terminate the program */
			if (response.compareTo("encode") == 0) {
				System.out.print("Enter the string to encode: ");
				String plaintext = in.nextLine();
				for (int i = 0; i < 26; i++) {
					String encoded = new String(encode (i, plaintext));
					System.out.printf("n = %d: %s\n", i, encoded);
				}
			} else if (response.compareTo("decode") == 0) {
				System.out.print("Enter the string to decode: ");
				String ciphertext = in.nextLine();
				for (int i = 0; i < 26; i++) {
					String decoded = new String(decode (i, ciphertext));
					System.out.printf("n = %d: %s\n", i, decoded);
				}
			} else {
				System.out.println("Valid options are \"encode\" or \"decode\"");
			}
		} finally {
			in.close();
		}

		return 0;
	}

	/**
	 * main runs the program
	 * 
	 * @param args
	 */
	public static void main (String[] args) {
		/* Program description */
		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher");
		System.out.print("Would you like to encode or decode a message? ");
		inputOperator();
	}
}
